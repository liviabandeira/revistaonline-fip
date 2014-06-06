package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import freemarker.template.TemplateException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.freemarker.Freemarker;
import br.com.caelum.vraptor.simplemail.Mailer;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.Autenticador;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.AuthException;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.UsuarioInfo;
import br.com.fip.gati.revistaonline.domain.util.GeraToken;
import br.com.fip.gati.revistaonline.domain.util.ShaEncrypt;
import br.com.fip.gati.revistaonline.infrastructure.mail.EmailException;
import br.com.fip.gati.revistaonline.infrastructure.mail.RevistaMailer;
import br.com.fip.gati.revistaonline.resources.web.Controllers;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;

@Resource
public class LoginController {
	private Autenticador autenticador;
	private UsuarioLogado usuarioLogado;
	private Validator validator;
	private Localization localization;
	private Result result;
	private Environment environment;
	private UsuarioRepositorio usuarioRepositorio;
	private RevistaMailer mailer;
	private Mailer vraptorMailer;
	private ServletContext context;
	private final HttpServletRequest request;
	private Freemarker freemarker;

	public LoginController(Autenticador autenticador, Environment environment,
			UsuarioLogado usuarioLogado, Validator validator,
			Localization localization, Result result,
			UsuarioRepositorio usuarioRepositorio, RevistaMailer mailer,
			ServletContext context, HttpServletRequest request,
			Freemarker freemarker) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.autenticador = autenticador;
		this.validator = validator;
		this.localization = localization;
		this.environment = environment;
		this.usuarioRepositorio = usuarioRepositorio;
		this.mailer = mailer;
		this.context = context;
		this.request = request;
		this.freemarker = freemarker;
	}

	@Get("/login")
	public void login() {

	}

	@Get("/login/username")
	public void username() {

	}

	@Get("/login/formulario")
	public void resetarSenha() {
	}

	@Get("/login/error")
	public void erroaoResetarSenha() {

	}

	@Get("/login/confirmacaoEmail")
	public void confirmacaoEmail() {

	}

	@Post
	public void enviarEmail(String username) throws EmailException,
			IOException, TemplateException {
		Usuario usuario = usuarioRepositorio.getUsuario(username);
		if(usuario == null){
			Controllers.includeError(result,
					"Usuário não existe");
			result.redirectTo(this).username();
			return;
		}
		String token = GeraToken.gerarToken();
		usuario.setToken(token);
		usuario.setDataHora(Calendar.getInstance());
		usuarioRepositorio.update(usuario);
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(request.getScheme()).append("://")
				.append(request.getServerName()).append(":")
				.append(request.getServerPort())
				.append(request.getContextPath()).append("/esqueciMinhaSenha/")
				.append(token);
		String body = freemarker.use("send_mail")
				.with("link", stringbuilder.toString()).getContent();
		mailer.send(this.environment.get("mail.subject"), body, usuario.getEmail());
		result.redirectTo(this).confirmacaoEmail();
	}

	@Get("/esqueciMinhaSenha/{token}")
	public Usuario validarTempoToken(String token) {
		Usuario user = this.usuarioRepositorio.getUsuarioPorToken(token);
		if (usuarioRepositorio.validarToken(user, token)) {
			result.include("token", token);
			result.redirectTo(this).resetarSenha();
			return user;
		} else {
			result.redirectTo(this).erroaoResetarSenha();
			return user;
		}
	}

	@Post("/novaSenha/{token}")
	public void esqueciminhaSenha(String token, String novaSenha,
			String confirmacao) {
		Usuario usuariodb = usuarioRepositorio.getUsuarioPorToken(token);
		if (novaSenha.length() < 8) {
			Controllers.includeError(result,
					"A senha precisa ter no mÃ­nimo 8 caracteres");
		} else if (!novaSenha.equals(confirmacao)) {
			Controllers
					.includeError(result,
							"Os valores da nova senha e da confirmaÃ§Ã£o da nova senha precisam ser iguais.");
		}
		usuariodb.setSenha(ShaEncrypt.hash(novaSenha,
				this.environment.get("encryption.salt")));
		this.usuarioRepositorio.update(usuariodb);
		result.redirectTo(this).login();
	}

	@Post("/auth")
	public void auth(Usuario usuario) {
		try {
			if (usuario.getLogin() == null
					|| usuario.getLogin().trim().isEmpty()
					|| usuario.getSenha() == null
					|| usuario.getSenha().trim().isEmpty()) {
				validator.add(new ValidationMessage(localization
						.getMessage("autenticacao.credencial.vazio"),
						localization.getMessage("autenticacao.credencial")));
			}
			validator.onErrorRedirectTo(IndexController.class).index();
			usuario.setSenha(ShaEncrypt.hash(usuario.getSenha(),
					this.environment.get("encryption.salt")));
			UsuarioInfo credencial = autenticador.autenticar(usuario);
			if (credencial != null) {
				usuarioLogado.setUsuarioInfo(credencial);
				result.redirectTo(IndexController.class).index();
			} else {
				result.include(
						"errors",
						Arrays.asList(new ValidationMessage(localization
								.getMessage("autenticacao.credencial.erro"),
								localization
										.getMessage("autenticacao.credencial"))))
						.redirectTo(IndexController.class).index();
			}

		} catch (ValidationException vex) {
			throw vex;
		} catch (AuthException authex) {
			authex.printStackTrace();
			result.include(
					"errors",
					Arrays.asList(new ValidationMessage(authex.getMessage(),
							localization.getMessage("autenticacao.credencial"))))
					.redirectTo(IndexController.class).index();
		} catch (Exception e) {
			e.printStackTrace();
			result.include(
					"errors",
					Arrays.asList(new ValidationMessage(localization
							.getMessage("autenticacao.credencial.erro"),
							localization.getMessage("autenticacao.credencial"))))
					.redirectTo(IndexController.class).index();
		}
	}

	@Get("/logout")
	public void logout() {
		this.usuarioLogado.logout();
		result.redirectTo(IndexController.class).index();
	}

}
