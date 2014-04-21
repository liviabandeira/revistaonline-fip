package br.com.fip.gati.revistaonline.resources.web;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.UsuarioInfo;

@Component
@SessionScoped
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = -8417478664679012367L;
	
	private UsuarioInfo usuarioInfo;

	public UsuarioInfo getUsuarioInfo() {
		return usuarioInfo;
	}
	
	public void setUsuarioInfo(UsuarioInfo usuario) {
		this.usuarioInfo = usuario;
	}
	
	public Long getID() {
		return usuarioInfo.getID();
	}

	public boolean isLogado() {
		return usuarioInfo != null;
	}
	
	public boolean isAdmin() {
		return isLogado() && usuarioInfo.isAdmin();
	}
	
	public void logout() {
		usuarioInfo = null;
	}
	
}
