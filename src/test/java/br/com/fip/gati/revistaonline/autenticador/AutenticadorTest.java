package br.com.fip.gati.revistaonline.autenticador;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.Autenticador;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.AuthException;
import br.com.fip.gati.revistaonline.domain.service.autenticacao.UsuarioInfo;
import br.com.fip.gati.revistaonline.domain.repositorio.UsuarioRepositorio;

public class AutenticadorTest {
	private Autenticador autenticador;
	private UsuarioRepositorio repositorio;
	private Usuario usuarioArmazenado;
	
	@Before
	public void init() {
		this.repositorio = mock(UsuarioRepositorio.class);
		this.autenticador = new Autenticador(this.repositorio);
		
		usuarioArmazenado = new Usuario();
		usuarioArmazenado.setAdmin(true);
		usuarioArmazenado.setEmail("admin@admin.com");
		usuarioArmazenado.setLogin("admin");
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
		when(repositorio.getUsuario("admin", "admin")).thenReturn(this.usuarioArmazenado);

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		
		UsuarioInfo credencial = this.autenticador.autenticar(usuario);
		assertNotNull(credencial);
		assertEquals("admin", credencial.getLogin());
		assertEquals("admin@admin.com", credencial.getEmail());
		assertTrue(credencial.isAdmin());
	}
	
	@Test
	public void deveRejeitarSeCredenciaisIncorretas() throws AuthException {
		when(repositorio.getUsuario("admin", "admin")).thenReturn(new Usuario());

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("1234");
		assertNull(this.autenticador.autenticar(usuario));
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("admin");
		usuario2.setSenha("ADMIN");
		assertNull(this.autenticador.autenticar(usuario));
		
		Usuario usuario3 = new Usuario();
		usuario3.setLogin("ADMIN");
		usuario3.setSenha("admin");
		assertNull(this.autenticador.autenticar(usuario));
	}
	
	@Test
	public void deveRejeitarSeUsuarioAusenteNoBanco() throws AuthException {
		when(repositorio.getUsuario(anyString(), anyString())).thenReturn(null);

		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		assertNull(this.autenticador.autenticar(usuario));
	}
	
}
