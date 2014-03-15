package br.com.fip.gati.revistaonline.domain.service.roles;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.repositorio.UsuarioRepositorio;

@Component
public class RoleManager {
	private UsuarioRepositorio usuarios;
	
	public RoleManager(UsuarioRepositorio usuarios) {
		this.usuarios = usuarios;
	}
	
	public void tornarAdmin(Usuario usuario) {
		usuario = this.usuarios.load(usuario.getId());
		usuario.setAdmin(true);
		this.usuarios.update(usuario);
	}
	
	public void removerAdmin(Usuario usuario) throws ZeroAdministradoresException {
		usuario = this.usuarios.load(usuario.getId());
		boolean somenteUmAdmin = this.usuarios.getTotalUsuariosAdministradores() <= 1;
		if(somenteUmAdmin) {
			throw new ZeroAdministradoresException("Sistema não pode ficar sem admin");
		}
		usuario.setAdmin(false);
		this.usuarios.update(usuario);
	}
}
