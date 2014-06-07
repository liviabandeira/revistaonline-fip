package br.com.fip.gati.revistaonline.resources.web.controllers;

import static br.com.fip.gati.revistaonline.resources.web.Controllers.includeError;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.environment.Environment;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.Newsletter;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.AutorRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.NewsLetterRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;
import br.com.fip.gati.revistaonline.resources.web.Controllers;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;

@Resource
public class RevistaController {

	private final Result result;
	private final RevistaRepositorio revistas;
	private final AutorRepositorio autores;
	private AvaliadorRepositorio avaliadores;
	private NewsLetterRepositorio repositorioNewsletter;
	private final Validator validator;
	private UsuarioLogado usuarioLogado;
	private Environment environment;
	private ServletContext context;

	public RevistaController(ServletContext context, Environment environment,
			RevistaRepositorio repositorio, AutorRepositorio autorRepo,
			AvaliadorRepositorio avaliadores,
			NewsLetterRepositorio repositorioNewsletter,
			UsuarioLogado usuarioLogado, Validator validator, Result result) {

		this.revistas = repositorio;
		this.autores = autorRepo;
		this.validator = validator;
		this.avaliadores = avaliadores;
		this.result = result;
		this.repositorioNewsletter = repositorioNewsletter;
		this.usuarioLogado = usuarioLogado;
		this.environment = environment;
		this.context = context;
	}

	@Get("/revistas")
	public void revistas() {
		result.include("revistaList", revistas.listAll());
		result.include("pathToFrontPage", context.getRealPath(this.environment
				.get("upload.frontpag.dir")));
	}

	@Get("/revistasindex")
	public void index() {
		result.include("revistaList", revistas.listAll());
	}

	@Get("/office/revista/new")
	public Revista newRevista() {
		result.include("action", "new");
		return new Revista();
	}

	@Get("/deletar")
	public void deletarAssinatura() {

	}
	
	@Get("/deletarAssinatura/error") 
	public void deletarAssinaturaError(){
		
	}
	
	@Get("/assinantedestarevista")
	public void errorAssinatura() {

	}

	@Post("/office/revista")
	public void create(Revista revista) {
		result.include("action", "new");

		validator.validate(revista);
		validator.onErrorUsePageOf(this).newRevista();

		revistas.save(revista);
		// result.redirectTo(this).revistas();

		result.redirectTo(OfficeController.class).revistas();
	}

	@Put("/office/revista")
	public void update(Revista revista) {
		Revista dbRevista = this.revistas.load(revista.getId());
		dbRevista.setTitulo(revista.getTitulo());
		dbRevista.setDescricao(revista.getDescricao());
		dbRevista.setIssn(revista.getIssn());

		validator.validate(dbRevista);
		validator.onErrorUsePageOf(this).edit(revista);

		revistas.update(dbRevista);
		// result.redirectTo(this).revistas();

		result.redirectTo(OfficeController.class).revistas();
	}

	@Get("/office/revista/{revista.id}/edit")
	public Revista edit(Revista revista) {
		result.include("action", "edit");
		return revistas.load(revista.getId());
	}

	// @Get("/revista/{revista.id}")
	@Get("/office/revista/{revista.id}")
	public Revista show(Revista revista) {
		result.include("action", "show");
		return revistas.load(revista.getId());
	}

	@Delete("/office/revista/{revista.id}")
	public void destroy(Revista revista) {
		revistas.delete(revistas.load(revista.getId()));
		result.redirectTo(this).revistas();
	}

	@Get("/revista/newsletter/{revista.id}")
	public Revista assinar(Revista revista) {
		Revista rev = this.revistas.load(revista.getId());
		return rev;
	}

	@Post("/newsletter/Usuariologado/{revista.id}")
	public void assinarLogado(Revista revista) {
		Revista idRevista = this.revistas.load(revista.getId());
		Newsletter nw = new Newsletter();
		Hibernate.initialize(idRevista.getNewsletters());

		String mailLogado = usuarioLogado.getUsuarioInfo().getEmail();
		String nomeLogado = usuarioLogado.getUsuarioInfo().getNome();

		if (repositorioNewsletter.verificaNewsletterExistente(idRevista,
				mailLogado)) {
			result.redirectTo(this).errorAssinatura();
			return;
		}

		nw.setNome(nomeLogado);
		nw.setEmail(mailLogado);
		nw.setAssinante(true);
		idRevista.addNewsletter(nw);
		repositorioNewsletter.save(nw);
		this.revistas.update(idRevista);
		result.redirectTo(this).revistas();
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
		if (autordb.isAvaliador()) {
			avaliador = autordb.getAvaliador();
		} else {
			avaliador = new Avaliador(autordb);
			avaliadores.save(avaliador);
		}

		if (revistadb.hasAvaliador(avaliador)) {
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
		if (!revistadb.hasAvaliador(avaliadordb)) {
			includeError(result, "A revista não possui o avaliador informado");
			result.redirectTo(this).avaliadores(revistadb);
		} else {
			revistadb.removeAvaliador(avaliadordb);
			result.redirectTo(this).avaliadores(revistadb);
		}
	}

	@Get("/office/revista/{revista.id}/avaliador/buscar")
	public void buscarAvaliador(Revista revista, String nome) {
		// result.include("autorList",
		// autores.getPorNome(nome)).redirectTo(this).newAvaliador(revista);

		result.include("nome", nome);
		result.include("revista", revista);
		result.include("autorList", autores.getPorPreNome(nome))
				.redirectTo(this).newAvaliador(revista);
	}

	@Post("/newsletter/{revista.id}")
	public void assinarRevista(Revista revista, String email, String nome) {
		Revista idRevista = revistas.load(revista.getId());
		Newsletter nw = new Newsletter();
		Hibernate.initialize(idRevista.getNewsletters());

		if (repositorioNewsletter
				.verificaNewsletterExistente(idRevista, email)) {
			result.redirectTo(this).errorAssinatura();
			return;
		}
		nw.setNome(nome);
		nw.setEmail(email);
		nw.setAssinante(true);
		idRevista.addNewsletter(nw);
		repositorioNewsletter.save(nw);
		revistas.update(idRevista);
		result.redirectTo(this).revistas();

	}

	@Get("/revista/deletarAssinatura/{revista.id}")
	public Revista deletarAssinatura(Revista revista) {
		Revista rev = this.revistas.load(revista.getId());
		return rev;
	}

	@Post
	public void deleteNewsletter(Revista revista, String email, String nome) {
		Revista idRevista = revistas.load(revista.getId());
		Hibernate.initialize(idRevista.getNewsletters());
		Newsletter nw = new Newsletter();
		Newsletter newsletter = repositorioNewsletter.getNewsletter(email);
		if(newsletter != null){
			nw = newsletter; 
		}
		idRevista.getNewsletters().remove(nw);
		revistas.update(idRevista);
		repositorioNewsletter.delete(nw);
		result.redirectTo(this).revistas();
	}
}
