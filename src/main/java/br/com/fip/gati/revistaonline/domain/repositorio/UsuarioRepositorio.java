package br.com.fip.gati.revistaonline.domain.repositorio;

import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Usuario;

public interface UsuarioRepositorio extends Repositorio<Usuario> {

	public Usuario getUsuario(String login);
	public Usuario getUsuario(String login, String senha);
	public Usuario getUsuarioPorEmail(String email);

	public Usuario getUsuarioPorToken(String token);
	public long getTotalUsuariosAdministradores();
}
