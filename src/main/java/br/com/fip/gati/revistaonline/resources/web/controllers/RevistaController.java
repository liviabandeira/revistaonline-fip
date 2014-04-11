package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.AutorRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;
import static br.com.fip.gati.revistaonline.resources.web.ControllerUtil.*;

@Resource
public class RevistaController {

	private final Result result;
	private final RevistaRepositorio revistas;
	private final AutorRepositorio autores;
	private AvaliadorRepositorio avaliadores;
	private final Validator validator;
	
	public RevistaController(RevistaRepositorio repositorio, AutorRepositorio autorRepo, AvaliadorRepositorio avaliadores, Validator validator, Result result) {
		this.revistas = repositorio;
		this.autores = autorRepo;
		this.validator = validator;
		this.avaliadores = avaliadores;
		this.result = result;
	}
	
	@Get("/revistas")
	public void index() {
		result.include("revistaList", revistas.listAll());
	}
	
	@Get("/office/revista/new")
	public Revista newRevista() {
		result.include("action", "new");
		return new Revista();
	}
	
	@Post("/office/revista")
	public void create(Revista revista) {
		result.include("action", "new");
		
		validator.validate(revista);
		validator.onErrorUsePageOf(this).newRevista();
		
		revistas.save(revista);
		result.redirectTo(this).index();
	}

	
	@Put("/office/revista")
	public void update(Revista revista) {
		Revista dbRevista = revistas.load(revista.getId());
		
		dbRevista.setIssn(revista.getIssn());
		
		validator.validate(dbRevista);
		validator.onErrorUsePageOf(this).edit(revista);
		
		revistas.update(dbRevista);
		result.redirectTo(this).index();
	}
	
	@Get("/office/revista/{revista.id}/edit")
	public Revista edit(Revista revista) {
		result.include("action", "edit");
		return revistas.load(revista.getId());
	}

	@Get("/revista/{revista.id}")
	public Revista show(Revista revista) {
		return revistas.load(revista.getId());
	}

	@Delete("/office/revista/{revista.id}")
	public void destroy(Revista revista) {
		revistas.delete(revistas.load(revista.getId()));
		result.redirectTo(this).index();
	}
	
	@Get("/office/revista/{revista.id}/avaliadores")
	public void avaliadores(Revista revista) {
		Revista revistadb = revistas.load(revista.getId());
		result.include("revista", revistadb);
		result.include("avaliadorList", revistadb.getAvaliadores());
	}
	
	@Get("/office/revista/{revista.id}/avaliador/new")
	public void newAvaliador(Revista revista) {
		Revista revistadb = revistas.load(revista.getId());
		result.include("revista", revistadb);
	}

	@Post("/office/revista/{revista.id}/avaliador")
	public void createAvaliador(Revista revista, Autor autor) {
		Revista revistadb = revistas.load(revista.getId());
		Autor autordb = autores.load(autor.getId());
		
		Avaliador avaliador = null;
		if(autordb.isAvaliador()) {
			avaliador = autordb.getAvaliador();
		} else {
			avaliador = new Avaliador(autordb);
			avaliadores.save(avaliador);
		}
		
		if(revistadb.hasAvaliador(avaliador)) {
			includeError(result, "O usuário já é avaliador da revista");
			result.redirectTo(this).avaliadores(revistadb);
		} else {
			revistadb.addAvaliador(avaliador);
			revistas.update(revistadb);
			result.redirectTo(this).avaliadores(revistadb);
		}
	}
	
	@Delete("/office/revista/{revista.id}/avaliador/{avaliador.id}")
	public void removerAvaliador(Revista revista, Avaliador avaliador) {
		Revista revistadb = revistas.load(revista.getId());
		Avaliador avaliadordb = avaliadores.load(avaliador.getId());
		if(!revistadb.hasAvaliador(avaliadordb)) {
			includeError(result, "A revista não possui o avaliador informado");
			result.redirectTo(this).avaliadores(revistadb);
		} else {
			revistadb.removeAvaliador(avaliadordb);
			result.redirectTo(this).avaliadores(revistadb);
		}
	}
	
	@Get("/office/revista/{revista.id}/avaliador/buscar")
	public void buscarAvaliador(Revista revista, String nome) {
		result.include("autorList", autores.getPorNome(nome)).redirectTo(this).newAvaliador(revista);
	}
	
}
