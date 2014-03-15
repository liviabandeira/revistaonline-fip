package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;

@Resource
public class UsuarioController {
	
	private UsuarioRepositorio usuarioRepositorio;
	private final Result result;
	private final Validator valitador;

	public UsuarioController(UsuarioRepositorio usuarioRep, Result result,
			Validator validator) {
		this.usuarioRepositorio = usuarioRep;
		this.result = result;
		this.valitador = validator;
	}
	
	@Path("/cadastro")
	public void formulario() {
		
	}
	
	@Post
	public void salvar(Usuario usuario) {
		//EFETUAR VALIDAÇÕES
		this.valitador.validate(usuario);
		this.valitador.onErrorRedirectTo(this).formulario();
		usuario.setAlterarSenhaProximoAcesso(false);
		usuario.setDtaCadastro(new Date());
		usuario.setDtaUltimoAcesso(new Date());
		usuario.setStatus("A");
		usuario.setTentativasLogon(0);
		this.usuarioRepositorio.save(usuario);
		result.redirectTo(this).formulario();
	}
	
	@Get("/usuario/{usuario.id}")
	public Usuario visualizar(Usuario usuario) {
		Usuario user = this.usuarioRepositorio.load(usuario.getId());
		return user;
	}
	
	@Put("/usuario/{usuario.id}")
	public void atualizar(Usuario usuario) {
		this.valitador.validate(usuario);
		this.valitador.onErrorRedirectTo(this).formulario();
		this.usuarioRepositorio.update(usuario);
		result.include("success", "Cadastrou").redirectTo(IndexController.class).index();
	}
	
	@Get("/usuario/editar/{usuario.id}")
	public Usuario editar(Usuario usuario) {
		Usuario user = this.usuarioRepositorio.load(usuario.getId());
		return user;
	}
	
	@Delete("/usuario/{usuario.id}")
	public void excluir(Usuario usuario) {
		Usuario user = this.usuarioRepositorio.load(usuario.getId());
		this.usuarioRepositorio.delete(user);
		result.redirectTo(this).listar();
	}
	
	@Get("/usuarios")
	public List<Usuario> listar() {
		return usuarioRepositorio.listAll();
	}
}
