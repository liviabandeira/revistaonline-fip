package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.Arrays;
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
import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.TipoUsuario;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;
import br.com.fip.gati.revistaonline.domain.service.roles.AdminManager;
import br.com.fip.gati.revistaonline.domain.service.roles.ZeroAdministradoresException;
import br.com.fip.gati.revistaonline.domain.util.ShaEncrypt;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;


@Resource
public class UsuarioController {
	private AdminManager roles;
	private UsuarioRepositorio usuarioRepositorio;
	private UsuarioLogado usuarioLogado;
	private final Result result;
	private final Validator valitador;
	private Environment environment;

	public UsuarioController(Environment environment, AdminManager roles, UsuarioRepositorio usuarioRepositorio, UsuarioLogado usuarioLogado,
			Result result, Validator validator) {
		this.roles = roles;
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.valitador = validator;
		this.environment = environment;
	}
	
	@Path("/cadastro")
	public void formulario() {
		
	}
	
	@Path("/alterarSenha")
	public void alterarSenha() {
		
	}
	
	@Post
	public void salvar(Usuario usuario) {
		this.valitador.validate(usuario);
		this.valitador.onErrorRedirectTo(this).formulario();

		usuario.setSenha(ShaEncrypt.hash(usuario.getSenha(), this.environment.get("encryption.salt")));
		usuario.setAlterarSenhaProximoAcesso(false);
		usuario.setDtaCadastro(new Date());
		usuario.setDtaUltimoAcesso(new Date());
		usuario.setAtivo();
		usuario.setTentativasLogon(0);
		
		TipoUsuario autor = new Autor();
		autor.setUsuario(usuario);
		usuario.addTipo(autor);

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
		this.valitador.onErrorRedirectTo(this).editar(usuario);

		Usuario usuariodb = this.usuarioRepositorio.load(usuario.getId());
		usuariodb.setNome(usuario.getNome());
		usuariodb.setSenha(ShaEncrypt.hash(usuario.getSenha(), this.environment.get("encryption.salt")));
		this.usuarioRepositorio.update(usuariodb);
		result.include("success", "Cadastrou").redirectTo(IndexController.class).index();
	}
	
	@Get("/usuario/editar/{usuario.id}")
	public Usuario editar(Usuario usuario) {
		Usuario user = this.usuarioRepositorio.load(usuario.getId());
		return user;
	}
	
	
	@Get("/usuario/alterarSenha/{usuario.id}")
	public Usuario alterarSenha(Usuario usuario) {
		Usuario user = this.usuarioRepositorio.load(usuario.getId());
		return user;
	}
	
	@Post
	public void atualizarSenha(Usuario usuario,String senhaAtual, String novaSenha,String confirmacao) {
		Usuario usuariodb = this.usuarioRepositorio.load(usuario.getId());
		String senhaAnterior = usuariodb.getSenha();
		senhaAtual.trim();
		novaSenha.trim();
		confirmacao.trim();
		if(senhaAtual.equals("") || novaSenha.equals("") || confirmacao.equals("")){
			this.valitador.add(new ValidationMessage("Todos os campos devem ser preenchidos",
					"Error"));
		}else if (!senhaAtual.equals(senhaAnterior)) {

			this.valitador.add(new ValidationMessage(
					"A senha atual e a anterior n�o conferem!", "Error"));

		} else if (novaSenha.length() < 8) {
			this.valitador.add(new ValidationMessage(
					"A senha precisa ter no m�nimo 8 caracteres", "Error"));
		}else if (!novaSenha.equals(confirmacao)) {
			this.valitador
			.add(new ValidationMessage(
					"Os valores da nova senha e da confirma��o da nova senha precisam ser iguais.",
					"Error"));
		}else if(!novaSenha.matches("[a-zA-Z][0-9]")){
				this.valitador.add(new ValidationMessage(
						"A senha precisa ter numeros,letras minusculas e letras maiusculas", "Error"));
		}

		this.valitador.onErrorRedirectTo(this).alterarSenha(usuario);
		usuariodb.setSenha(novaSenha);
		this.usuarioRepositorio.update(usuariodb);
		result.include("message", "Senha alterada com sucesso.")
				.redirectTo(IndexController.class).index();
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
