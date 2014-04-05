package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.List;

import org.hibernate.Hibernate;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Newsletter;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.NewsLetterRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;
import br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate.NewsLetterDAO;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;

@Resource
public class RevistaController {

	private final Result result;
	private final RevistaRepositorio repositorio;
	private final NewsLetterRepositorio repositorioNewsletter;
	private final Validator validator;
	private UsuarioLogado usuarioLogado;

	public RevistaController(RevistaRepositorio repositorio,
			Validator validator, Result result,
			NewsLetterRepositorio repositorioNewsletter,
			UsuarioLogado usuarioLogado) {
		this.repositorio = repositorio;
		this.validator = validator;
		this.result = result;
		this.repositorioNewsletter = repositorioNewsletter;
		this.usuarioLogado = usuarioLogado;
	}

	@Get("/revistas")
	public void index() {
		result.include("revistaList", repositorio.listAll());
	}

	@Get("/deletar")
	public void deletarAssinatura() {

	}

	@Get("/assinantedestarevista")
	public void errorAssinatura() {

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

	@Get("/revista/assinar/{revista.id}")
	public Revista assinar(Revista revista) {
		Revista rev = this.repositorio.load(revista.getId());
		return rev;
	}

	@Post("/revista/assinarlogado/{revista.id}")
	public void assinarLogado(Revista revista) {
		Revista idRevista = repositorio.load(revista.getId());
		Newsletter nw = new Newsletter();
		Hibernate.initialize(idRevista.getNewsletters());
		
		String mailLogado = usuarioLogado.getUsuarioInfo().getEmail();
		String nomeLogado = usuarioLogado.getUsuarioInfo().getNome();
		
		for (int i = 0; i < idRevista.getNewsletters().size(); i++) {
			Newsletter n = idRevista.getNewsletters().get(i);
			if (n.getEmail().equals(mailLogado)) {
				result.redirectTo(this).errorAssinatura();
				return;
			}
		}
		
		List<Newsletter> listaAssinantes = repositorioNewsletter.listAll();
		for (int i = 0; i < listaAssinantes.size(); i++) {
			Newsletter n = listaAssinantes.get(i);
			if (n.getEmail().equals(mailLogado)) {
				nw = n;
				idRevista.addNewsletter(nw);
				repositorio.update(idRevista);
				result.redirectTo(this).index();
				return;
			}
		}
		
		nw.setNome(nomeLogado);
		nw.setEmail(mailLogado);
		nw.setAssinante(true);
		idRevista.addNewsletter(nw);
		repositorioNewsletter.save(nw);
		repositorio.update(idRevista);
		result.redirectTo(this).index();
	}
	
	
	@Post("/revista/assinatura/{revista.id}")
	public void assinarRevista(Revista revista, String email, String nome) {
		Revista idRevista = repositorio.load(revista.getId());
		Newsletter nw = new Newsletter();
		Hibernate.initialize(idRevista.getNewsletters());
		
		for (int i = 0; i < idRevista.getNewsletters().size(); i++) {
			Newsletter n = idRevista.getNewsletters().get(i);
			if (n.getEmail().equals(email)) {
				result.redirectTo(this).errorAssinatura();
				return;
			}
		}

		List<Newsletter> listaAssinantes = repositorioNewsletter.listAll();
		for (int i = 0; i < listaAssinantes.size(); i++) {
			Newsletter n = listaAssinantes.get(i);
			if (n.getEmail().equals(email)) {
				nw = n;
				idRevista.addNewsletter(nw);
				repositorio.update(idRevista);
				result.redirectTo(this).index();
				return;
			}
		}

		nw.setNome(nome);
		nw.setEmail(email);
		nw.setAssinante(true);
		this.validator.validate(nw);
		this.validator.onErrorRedirectTo(this).index();
		idRevista.addNewsletter(nw);
		repositorioNewsletter.save(nw);
		repositorio.update(idRevista);
		result.redirectTo(this).index();

	}

	@Get("/revista/deletarAssinatura/{revista.id}")
	public Revista deletarAssinatura(Revista revista) {
		Revista rev = this.repositorio.load(revista.getId());
		return rev;
	}

	@Post
	public void deleteNewsletter(Revista revista, String email) {
		Revista idRevista = repositorio.load(revista.getId());
		Hibernate.initialize(idRevista.getNewsletters());
		Newsletter nw = new Newsletter();
		for (int i = 0; i < idRevista.getNewsletters().size(); i++) {
			Newsletter n = idRevista.getNewsletters().get(i);
			if (n.getEmail().equals(email)) {
				nw = n;
			}
		}
		idRevista.getNewsletters().remove(nw);
		repositorio.update(idRevista);
		result.redirectTo(this).index();
	}
}
