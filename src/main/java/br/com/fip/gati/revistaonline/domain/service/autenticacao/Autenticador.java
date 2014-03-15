package br.com.fip.gati.revistaonline.domain.service.autenticacao;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.repositorio.UsuarioRepositorio;

@Component
public class Autenticador {
	private UsuarioRepositorio usuarios;
	
	public Autenticador(UsuarioRepositorio usuarios) {
		this.usuarios = usuarios;
	}
	
	public UsuarioInfo autenticar(Usuario usuario) throws AuthException {
		if(usuario == null) {
			throw new NullPointerException("Usuario null");
		}
		
		if(usuario.getLogin() == null || usuario.getSenha() == null) {
			throw new IllegalArgumentException("Login ou senha nulos");
		}
		
		Usuario usuarioBD = usuarios.getUsuario(usuario.getLogin(), usuario.getSenha());
		if(usuarioBD != null) {
			return usuarioBD.getUsuarioInfo();
		}
		return null;
	}
	
}
