package br.com.fip.gati.revistaonline.resources.web.controllers;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Edicao;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.EdicaoRepositorio;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;

@Resource
public class EdicaoController {

	private final Result result;
	private final EdicaoRepositorio edicaoRepositorio;
	private final RevistaRepositorio revistaRepositorio;
	private final Validator validator;
	
	public EdicaoController(EdicaoRepositorio repository, Validator validator, Result result, RevistaRepositorio revistaRepositorio) {
		this.edicaoRepositorio = repository;
		this.validator = validator;
		this.result = result;
		this.revistaRepositorio = revistaRepositorio;
	}
	
	@Get("/edicoes")
	public void index() {
		result.include("edicaoList", edicaoRepositorio.listAll());
	}
	
	@Get("/revistas/{revista.id}/edicoes")
	public void edicoes(Revista revista){
		Revista rev = revistaRepositorio.load(revista.getId());
		result.include("revista", rev.getIssn());
		result.include("edicaoList", edicaoRepositorio.listByRevista(revista));		
	}
	
	@Get("/office/revista/{revista.id}/edicao/new")
	public Edicao newEdicao(Revista revista) {
		result.include("action", "new");
		result.include("revista", revista);
		return new Edicao();
	}
	
	@Post("/office/edicao")
	public void create(Edicao edicao) {
		result.include("action", "new");
		
		validator.validate(edicao);
		//validator.onErrorUsePageOf(this).newEdicao();
		
		edicaoRepositorio.save(edicao);
		result.redirectTo(this).index();
	}

	
	@Put("/edicao")
	public void update(Edicao edicao) {
		Edicao dbEdicao = edicaoRepositorio.load(edicao.getId());
		
		dbEdicao.setNumero(edicao.getNumero());
		dbEdicao.setVolume(edicao.getVolume());
		
		validator.validate(dbEdicao);
		validator.onErrorUsePageOf(this).edit(edicao);
		edicaoRepositorio.update(dbEdicao);
		result.redirectTo(this).index();
	}
	
	@Get("/edicao/{edicao.id}/edit")
	public Edicao edit(Edicao edicao) {
		result.include("action", "edit");
		return edicaoRepositorio.load(edicao.getId());
	}

	@Get("/edicao/{edicao.id}")
	public Edicao show(Edicao edicao) {
		return edicaoRepositorio.load(edicao.getId());
	}

	@Delete("/edicao/{edicao.id}")
	public void destroy(Edicao edicao) {
		edicaoRepositorio.delete(edicaoRepositorio.load(edicao.getId()));
		result.redirectTo(this).index();
	}
	
}
