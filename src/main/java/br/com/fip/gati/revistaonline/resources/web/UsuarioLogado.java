package br.com.fip.gati.revistaonline.resources.web;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.fip.gati.revistaonline.domain.model.Usuario;

@Component
@SessionScoped
public class UsuarioLogado {
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}
	
	public void logout() {
		usuario = null;
	}
	
}
