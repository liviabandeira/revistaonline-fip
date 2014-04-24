package br.com.fip.gati.revistaonline.resources.web.controllers;

import java.util.Arrays;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.environment.Environment;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.Autenticador;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.AuthException;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.UsuarioInfo;
import br.com.fip.gati.revistaonline.domain.util.ShaEncrypt;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;


@Resource
public class LoginController {
	private Autenticador autenticador;
	private UsuarioLogado usuarioLogado;
	private Validator validator;
	private Localization localization;
	private Result result;
	private Environment environment;
	
	public LoginController(Autenticador autenticador,Environment environment, UsuarioLogado usuarioLogado, Validator validator, Localization localization, Result result) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.autenticador = autenticador;
		this.validator = validator;
		this.localization = localization;
		this.environment = environment;
	}
	
	@Get("/login")
	public void login() {
		
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
