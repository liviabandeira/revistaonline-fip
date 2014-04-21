package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.Arrays;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.fip.gati.revistaonline.application.UsuarioService;
import br.com.fip.gati.revistaonline.domain.exception.RevistaException;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;
import br.com.fip.gati.revistaonline.domain.service.roles.AdminManager;
import br.com.fip.gati.revistaonline.domain.service.roles.ZeroAdministradoresException;
import br.com.fip.gati.revistaonline.resources.web.Controllers;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;


@Resource
public class UsuarioController {
	private AdminManager roles;
	private UsuarioRepositorio usuarioRepositorio;
	private UsuarioLogado usuarioLogado;
	private final Result result;
	private final Validator valitador;
	private UsuarioService usuarioService;

	public UsuarioController(AdminManager roles, UsuarioService usuarioService, UsuarioRepositorio usuarioRepositorio, UsuarioLogado usuarioLogado,
			Result result, Validator validator) {
		this.roles = roles;
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.valitador = validator;
		this.usuarioService = usuarioService;
	}
	
	@Path("/cadastro")
	public void formulario() {
		result.include("action", "new");
	}
	
	@Path("/alterarSenha")
	public void alterarSenha() {
		
	}
	
	@Post
	public void salvar(Usuario usuario, Autor autor) {
		this.valitador.validate(usuario);
		this.valitador.validate(autor);
		
		if(usuario != null) {
			if(usuario.getSenha() == null || usuario.getConfirmacaoSenha() == null) {
				Controllers.includeValidationError(this.valitador, "senha", "Senha deve ser preenchida");
			} else {
				if(!usuario.getSenha().equals(usuario.getConfirmacaoSenha())) {
					Controllers.includeValidationError(this.valitador, "senha", "Senhas não conferem");
				}
			}
		}
		
		this.valitador.onErrorRedirectTo(this).formulario();

		result.include("usuario", usuario);
		result.include("autor", autor);
		usuario.setAutor(autor);
		
		try {
			
			usuarioService.cadastrarUsuario(usuario);
			Controllers.includeSucess(result, "Usuario cadastrado com sucesso");
			result.redirectTo(UsuarioController.class).ok();
		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			Controllers.includeError(result, e.getMessage());
			result.redirectTo(this).formulario();
		} catch (RevistaException e) {
			e.printStackTrace();
			Controllers.includeError(result, e.getMessage());
			result.redirectTo(this).formulario();
		}
	}
	
	public void ok() {		
	}
	
	@Get("/usuario/{id}/perfil")
	public void perfil(Long id) {
		Usuario user = this.usuarioRepositorio.load(usuarioLogado.getID());
		result.include("action", "edit");
		result.include("usuario", user);
		result.include("autor", user.getAutor());
	}
	
	@Put("/usuario/{usuario.id}")
	public void atualizar(Usuario usuario, Autor autor) {
		Usuario usuariodb = usuarioRepositorio.load(usuarioLogado.getID());
		usuario.setId(usuariodb.getId());
		usuario.setSenha("aaaaaaaaaaaaaaaaaaaa");
		
		this.valitador.validate(usuario);
		this.valitador.validate(autor);
		this.valitador.onErrorRedirectTo(this).perfil(usuarioLogado.getID());
		
		result.include("usuario", usuario);
		result.include("autor", autor);
		
		usuario.setAutor(autor);
		usuarioService.atualizarUsuario(usuario);
		usuariodb = usuarioRepositorio.load(usuarioLogado.getID());
		usuarioLogado.setUsuarioInfo(usuariodb.getUsuarioInfo());
		
		Controllers.includeSucess(result, "Perfil alterado com sucesso");
		result.redirectTo(UsuarioController.class).ok();
	}
	
	@Get("/usuario/alterarSenha/{usuario.id}")
	public Usuario alterarSenha(Usuario usuario) {
		Usuario user = this.usuarioRepositorio.load(usuario.getId());
		return user;
	}
	
	@Post
	public void atualizarSenha(Usuario usuario, String senhaAtual, String novaSenha, String confirmacao) {
		Usuario usuariodb = this.usuarioRepositorio.load(usuario.getId());
		String senhaAnterior = usuariodb.getSenha();
		senhaAtual.trim();
		novaSenha.trim();
		confirmacao.trim();
		if (senhaAtual.equals("") || novaSenha.equals("") || confirmacao.equals("")) {
			this.valitador.add(new ValidationMessage("Todos os campos devem ser preenchidos", "Error"));
		} else if (!senhaAtual.equals(senhaAnterior)) {

			this.valitador.add(new ValidationMessage("A senha atual e a anterior não conferem!", "Error"));

		} else if (novaSenha.length() < 8) {
			this.valitador.add(new ValidationMessage("A senha precisa ter no mínimo 8 caracteres", "Error"));
		} else if (!novaSenha.equals(confirmacao)) {
			this.valitador.add(new ValidationMessage("Os valores da nova senha e da confirmação da nova senha precisam ser iguais.", "Error"));
		} else if (!novaSenha.matches("[a-zA-Z][0-9]")) {
			this.valitador.add(new ValidationMessage("A senha precisa ter numeros,letras minusculas e letras maiusculas", "Error"));
		}

		this.valitador.onErrorRedirectTo(this).alterarSenha(usuario);
		usuariodb.setSenha(novaSenha);
		this.usuarioRepositorio.update(usuariodb);
		result.include("message", "Senha alterada com sucesso.").redirectTo(IndexController.class).index();
		;
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
	
	@Put("/usuario/{usuario.id}/admin")
	public void addRoleAdmin(Usuario usuario) {
		if (!this.usuarioLogado.isAdmin()) {
			result.use(Results.http()).sendError(403, "O usuário autenticado deve ser administrador");
		}
		
		if(this.usuarioLogado.getUsuarioInfo().getID().equals(usuario.getId())) {
			result.include("errors", Arrays.asList(new ValidationMessage("Não é permitido alterar as próprias permissões", "erro")));
		} else {
			roles.tornarAdmin(usuario);
		}
		result.redirectTo(this).listar();
	}
	
	@Delete("/usuario/{usuario.id}/admin")
	public void delRoleAdmin(Usuario usuario) {
		if(!this.usuarioLogado.isAdmin()) {
			result.use(Results.http()).sendError(403, "O usuário autenticado deve ser administrador");
		}
		
		if(this.usuarioLogado.getUsuarioInfo().getID().equals(usuario.getId())) {
			result.include("errors", Arrays.asList(new ValidationMessage("Não é permitido alterar as próprias permissões", "erro"))).redirectTo(this).listar();
		} else {
			try {
				roles.removerAdmin(usuario);
				result.redirectTo(this).listar();
			} catch (ZeroAdministradoresException e) {
				e.printStackTrace();
				result.include("errors", Arrays.asList(new ValidationMessage(e.getMessage(), "erro"))).redirectTo(this).listar();
			}
		}
		
	}
}
