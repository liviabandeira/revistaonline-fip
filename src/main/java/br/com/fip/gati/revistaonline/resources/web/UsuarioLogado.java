package br.com.fip.gati.revistaonline.resources.web;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.UsuarioInfo;

@Component
@SessionScoped
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = -8417478664679012367L;
	
	private UsuarioInfo user;

	public UsuarioInfo getUsuarioInfo() {
		return user;
	}
	
	public void setUsuarioInfo(UsuarioInfo usuario) {
		this.user = usuario;
	}

	public boolean isLogado() {
		return user != null;
	}
	
	public boolean isAdmin() {
		return isLogado() && user.isAdmin();
	}
	
	public void logout() {
		user = null;
	}
	
}
