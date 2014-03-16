package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;

@Resource
public class RevistaController {

	private final Result result;
	private final RevistaRepositorio repositorio;
	private final Validator validator;
	
	public RevistaController(RevistaRepositorio repositorio, Validator validator, Result result) {
		this.repositorio = repositorio;
		this.validator = validator;
		this.result = result;
	}
	
	@Get("/revistas")
	public void index() {
		result.include("revistaList", repositorio.listAll());
	}
	
	@Get("/revista/new")
	public Revista newRevista() {
		result.include("action", "new");
		return new Revista();
	}
	
	@Post("/revista")
	public void create(Revista revista) {
		result.include("action", "new");
		
		validator.validate(revista);
		validator.onErrorUsePageOf(this).newRevista();
		
		repositorio.save(revista);
		result.redirectTo(this).index();
	}

	
	@Put("/revista")
	public void update(Revista revista) {
		Revista dbRevista = repositorio.load(revista.getId());
		
		dbRevista.setIssn(revista.getIssn());
		
		validator.validate(dbRevista);
		validator.onErrorUsePageOf(this).edit(revista);
		
		repositorio.update(dbRevista);
		result.redirectTo(this).index();
	}
	
	@Get("/revista/{revista.id}/edit")
	public Revista edit(Revista revista) {
		result.include("action", "edit");
		return repositorio.load(revista.getId());
	}

	@Get("/revista/{revista.id}")
	public Revista show(Revista revista) {
		return repositorio.load(revista.getId());
	}

	@Delete("/revista/{revista.id}")
	public void destroy(Revista revista) {
		repositorio.delete(repositorio.load(revista.getId()));
		result.redirectTo(this).index();
	}
	
}
