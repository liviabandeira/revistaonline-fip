package br.com.fip.gati.revistaonline.resources.web.interceptors;

import java.util.Arrays;
import java.util.Collection;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.Auth;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.Permissao;
import br.com.fip.gati.revistaonline.resources.web.UsuarioLogado;
import br.com.fip.gati.revistaonline.resources.web.controllers.IndexController;
import br.com.fip.gati.revistaonline.resources.web.controllers.LoginController;

@Intercepts
@RequestScoped
public class AuthInterceptor implements Interceptor {
	private UsuarioLogado usuarioLogado;
	private Result result;
	
	public AuthInterceptor(UsuarioLogado user, Result result) {
		this.usuarioLogado = user;
		this.result = result;
	}

	public boolean accepts(ResourceMethod method) {
		//return (!usuarioLogado.isLogado() && !method.getMethod().getDeclaringClass().equals(LoginController.class));
		
		if(method.getMethod().isAnnotationPresent(Auth.class) || method.getResource().getType().isAnnotationPresent(Auth.class)) {
			return true;
		}
		return false;
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object obj) throws InterceptionException {
		if(!usuarioLogado.isLogado()) {
			result.redirectTo(LoginController.class).login();			
		} else {
			stack.next(method, obj);			
		}
	}
	
	/**
	 * Verifica se a anotacão presente no metodo possui permissao especifica para alguma Role.
	 * @param autorizacao
	 * @return
	 */
	private boolean hasAccess(Auth autorizacao) {
		//se a anotacao não possuir roles dentro, só valida o usuario logado
		if (autorizacao == null) {
			return true;
		}
		//caso contrário verificará se o usuário logado tem a permissao contida dentro do @Auth(ROLE)

		//Possui as roles contidas dentro da anotacao passadas no metodo
		Collection<Permissao> rolesList = Arrays.asList(autorizacao.value());

		return false;
	}
	
}
