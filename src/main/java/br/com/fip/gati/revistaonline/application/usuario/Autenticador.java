package br.com.fip.gati.revistaonline.application.usuario;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;

@Component
public class Autenticador {
	private UsuarioRepositorio usuarios;
	
	public Autenticador(UsuarioRepositorio usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean autenticar(Usuario usuario) throws AuthException {
		if(usuario == null) {
			throw new NullPointerException("Usuario null");
		}
		
		if(usuario.getLogin() == null || usuario.getSenha() == null) {
			throw new IllegalArgumentException("Login ou senha nulos");
		}
		
		return usuarios.getUsuario(usuario.getLogin(), usuario.getSenha()) != null;
	}
	
}
