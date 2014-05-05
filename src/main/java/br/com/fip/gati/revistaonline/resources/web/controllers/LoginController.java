package br.com.fip.gati.revistaonline.resources.web.controllers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.mail.Email;
import org.hibernate.type.descriptor.java.CalendarTypeDescriptor.CalendarMutabilityPlan;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.environment.Environment;
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
	
	public LoginController(Autenticador autenticador,Environment environment, UsuarioLogado usuarioLogado, Validator validator, Localization localization, Result result, UsuarioRepositorio usuarioRepositorio, RevistaMailer mailer) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.autenticador = autenticador;
		this.validator = validator;
		this.localization = localization;
		this.environment = environment;
		this.usuarioRepositorio = usuarioRepositorio;
		this.mailer = mailer;
	}
	
	@Get("/login")
	public void login() {
		
	}
	
	@Get("/login/username")
	public void username() {
		
	}
	
	@Get("/login/resetarSenha")
	public void resetarSenha() {
	}
	
	@Get("/login/erroaoResetarSenha")
	public void erroaoResetarSenha(){
		
	}
	
	@Get("/login/confirmacaoEmail")
	public void confirmacaoEmail() {
		
	}
	@Post
	public void enviarEmail(String username) throws EmailException{
		Usuario usuario = usuarioRepositorio.getUsuario(username);
		String token = GeraToken.gerarToken();
		System.out.println(token);
		usuario.setToken(token);
		usuario.setDataHora(Calendar.getInstance());
		usuarioRepositorio.update(usuario);
		String link = "http://localhost:8080/revistaonline/login/esqueciMinhasenha/" + token;
		mailer.send("Esqueci minha senha", link , usuario.getEmail());
		result.redirectTo(this).confirmacaoEmail();
	}
	
	@Get("/login/validacao/{token}")
	public Usuario validarTempo(String token) {
		System.out.println(token);
		Usuario user = this.usuarioRepositorio.getUsuarioPorToken(token);
		Calendar time = user.getDataHora();
		if((time.getTimeInMillis() - Calendar.getInstance().getTimeInMillis()) > -900000 ){
			result.include("token", token);
			result.redirectTo(this).resetarSenha();
			return user;	
		}else{
			result.redirectTo(this).erroaoResetarSenha();
			return user;
		}
	}
	
	@Post("/login/resetarSenha/{token}")
	public void esqueciminhaSenha(String token, String novaSenha, String confirmacao) {
		Usuario usuariodb = usuarioRepositorio.getUsuarioPorToken(token);
		if (novaSenha.length() < 8) {
			this.validator.add(new ValidationMessage("A senha precisa ter no mínimo 8 caracteres", "Error"));
		} else if (!novaSenha.equals(confirmacao)) {
			this.validator.add(new ValidationMessage("Os valores da nova senha e da confirmação da nova senha precisam ser iguais.", "Error"));
		}
		this.validator.onErrorRedirectTo(this).validarTempo(token);
		usuariodb.setSenha(ShaEncrypt.hash(novaSenha, this.environment.get("encryption.salt")));
		this.usuarioRepositorio.update(usuariodb);
		result.redirectTo(this).login();
	}

	@Post("/auth")
	public void auth(Usuario usuario) {
		try {
			if(usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()
					|| usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
				validator.add(new ValidationMessage(localization.getMessage("autenticacao.credencial.vazio"), localization.getMessage("autenticacao.credencial")));
			}

			validator.onErrorRedirectTo(IndexController.class).index();
			usuario.setSenha(ShaEncrypt.hash(usuario.getSenha(), this.environment.get("encryption.salt")));
			UsuarioInfo credencial = autenticador.autenticar(usuario);
			if (credencial != null) {
				usuarioLogado.setUsuarioInfo(credencial);
				result.redirectTo(IndexController.class).index();
			} else {
				result.include("errors", Arrays.asList(new ValidationMessage(localization.getMessage("autenticacao.credencial.erro"), localization.getMessage("autenticacao.credencial")))).redirectTo(IndexController.class).index();
			}
			
		} catch (ValidationException vex) {
			throw vex;
		} catch (AuthException authex) {
			authex.printStackTrace();
			result.include("errors", Arrays.asList(new ValidationMessage(authex.getMessage(), localization.getMessage("autenticacao.credencial")))).redirectTo(IndexController.class).index();
		} catch (Exception e) {
			e.printStackTrace();
			result.include("errors", Arrays.asList(new ValidationMessage(localization.getMessage("autenticacao.credencial.erro"), localization.getMessage("autenticacao.credencial")))).redirectTo(IndexController.class).index();
		}
	}
	
	@Get("/logout")
    public void logout() {
		this.usuarioLogado.logout();
		result.redirectTo(IndexController.class).index();
    }
	
	
}
