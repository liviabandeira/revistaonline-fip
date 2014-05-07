package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;


@Resource
public class ArtigoController {
	
	private ArtigoRepositorio artigoRepositorio;
	private final Result result;
	private final Validator valitador;

	public ArtigoController(ArtigoRepositorio artigoRep, Result result, Validator validator) {
		this.artigoRepositorio = artigoRep;
		this.result = result;
		this.valitador = validator;
	}
	
	@Get("/submissao")
	public void formulario() {
		
	}
	
	@Post
	public void salvar(Artigo artigo) {
		//EFETUAR VALIDAÇÕES
		
		this.artigoRepositorio.save(artigo);
		result.redirectTo(this).formulario();
	}
	
	@Get("/artigo/{artigo.id}")
	public Artigo visualizar(Artigo artigo) {
		Artigo art = this.artigoRepositorio.load(artigo.getId());
		return art;
	}
	
	@Put("/artigo/{artigo.id}")
	public void atualizar(Artigo artigo) {

		this.valitador.validate(artigo);
		this.valitador.onErrorRedirectTo(this).formulario();
		this.artigoRepositorio.update(artigo);
		result.include("success", "Cadastrou").redirectTo(IndexController.class).index();
	}
	@Get("/artigo/editar/{artigo.id}")
	public Artigo editar(Artigo artigo) {
		Artigo arti = this.artigoRepositorio.load(artigo.getId());
		return arti;
	}
	
	@Delete("/office/artigo/{artigo.id}")
	public void excluir(Artigo artigo) {
		Artigo arti = this.artigoRepositorio.load(artigo.getId());
		this.artigoRepositorio.delete(arti);
		result.redirectTo(this).listar();
	}
	
	@Get("/artigos")
	public List<Artigo> listar() {
		return artigoRepositorio.listAll();
	}
}
