package br.com.fip.gati.revistaonline.autenticador;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import br.com.fip.gati.revistaonline.application.usuario.Autenticador;
import br.com.fip.gati.revistaonline.application.usuario.AuthException;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.repositorio.UsuarioRepositorio;

public class AutenticadorTest {
	private Autenticador autenticador;
	private UsuarioRepositorio repositorio;
	
	@Before
	public void init() {
		this.repositorio = mock(UsuarioRepositorio.class);
		this.autenticador = new Autenticador(this.repositorio);
	}
	
	
	@Test(expected=NullPointerException.class)
	public void deveLancarExceptionSeUsuarioNulo() throws AuthException {
		this.autenticador.autenticar(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExceptionSeCredenciaisNulas() throws AuthException {
		Usuario usuario = new Usuario();
		usuario.setLogin(null);
		usuario.setSenha(null);
		this.autenticador.autenticar(usuario);
	}
	
	@Test
	public void deveAutenticarSeCredenciaisCorretas() throws AuthException {
		when(repositorio.getUsuario("admin", "admin")).thenReturn(new Usuario());

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		assertTrue(this.autenticador.autenticar(usuario));
	}
	
	@Test
	public void deveRejeitarSeCredenciaisIncorretas() throws AuthException {
		when(repositorio.getUsuario("admin", "admin")).thenReturn(new Usuario());

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("1234");
		assertFalse(this.autenticador.autenticar(usuario));
	}
	
	@Test
	public void deveRejeitarSeUsuarioAusenteNoBanco() throws AuthException {
		when(repositorio.getUsuario(anyString(), anyString())).thenReturn(null);

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		assertFalse(this.autenticador.autenticar(usuario));
	}
	
}
