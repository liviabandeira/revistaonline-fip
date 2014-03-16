package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Edicao;
import br.com.fip.gati.revistaonline.domain.repositorio.EdicaoRepositorio;

@Resource
public class EdicaoController {

	private final Result result;
	private final EdicaoRepositorio repository;
	private final Validator validator;
	
	public EdicaoController(EdicaoRepositorio repository, Validator validator, Result result) {
		this.repository = repository;
		this.validator = validator;
		this.result = result;
	}
	
	@Get("/edicoes")
	public void index() {
		result.include("edicaoList", repository.listAll());
	}
	
	@Get("/edicao/new")
	public Edicao newEdicao() {
		result.include("action", "new");
		return new Edicao();
	}
	
	@Post("/edicao")
	public void create(Edicao edicao) {
		result.include("action", "new");
		
		validator.validate(edicao);
		validator.onErrorUsePageOf(this).newEdicao();
		
		repository.save(edicao);
		result.redirectTo(this).index();
	}

	
	@Put("/edicao")
	public void update(Edicao edicao) {
		Edicao dbEdicao = repository.load(edicao.getId());
		
		dbEdicao.setNumero(edicao.getNumero());
		dbEdicao.setVolume(edicao.getVolume());
		
		validator.validate(dbEdicao);
		validator.onErrorUsePageOf(this).edit(edicao);
		repository.update(dbEdicao);
		result.redirectTo(this).index();
	}
	
	@Get("/edicao/{edicao.id}/edit")
	public Edicao edit(Edicao edicao) {
		result.include("action", "edit");
		return repository.load(edicao.getId());
	}

	@Get("/edicao/{edicao.id}")
	public Edicao show(Edicao edicao) {
		return repository.load(edicao.getId());
	}

	@Delete("/edicao/{edicao.id}")
	public void destroy(Edicao edicao) {
		repository.delete(repository.load(edicao.getId()));
		result.redirectTo(this).index();
	}
	
}
