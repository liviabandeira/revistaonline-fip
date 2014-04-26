package br.com.fip.gati.revistaonline.artigo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.fip.gati.revistaonline.domain.exception.RevistaException;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.enums.ArtigoStatusEnum;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;
import br.com.fip.gati.revistaonline.domain.service.artigo.AssociacaoAvaliadores;
import static org.mockito.Mockito.*;

public class AssociacaoAvaliadoresTest {
	private ArtigoRepositorio artigos = mock(ArtigoRepositorio.class);
	private AssociacaoAvaliadores aa;
	private Avaliador avaliador1, avaliador2;
	
	
	@Before
	public void setup() {
		aa = new AssociacaoAvaliadores(artigos);
		
		this.avaliador1 = new Avaliador();
		avaliador1.setId(1L);
		
		this.avaliador2 = new Avaliador();
		avaliador2.setId(2L);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExceptionSeParametrosNulos() throws RevistaException {
		aa.associarAvaliadores(null, null);
	}
	
	@Test(expected=RevistaException.class)
	public void deveLancarErroSeForMenosDe2Avaliadores() throws RevistaException {
		List<Avaliador> avalidores = new ArrayList<Avaliador>();
		avalidores.add(new Avaliador());
		
		aa.associarAvaliadores(new Artigo(), avalidores);
	}
	
	@Test(expected=RevistaException.class)
	public void deveLancarErroSeForMaiorQue2Avaliadores() throws RevistaException {
		List<Avaliador> avalidores = new ArrayList<Avaliador>();
		avalidores.add(new Avaliador());
		avalidores.add(new Avaliador());
		avalidores.add(new Avaliador());
		
		aa.associarAvaliadores(mock(Artigo.class), avalidores);
	}
	
	@Test(expected=RevistaException.class)
	public void deveLancarErroSeOsAvaliadoresForemIguais() throws RevistaException {
		Avaliador avaliador = new Avaliador();
		avaliador.setId(1L);
		
		List<Avaliador> avalidores = new ArrayList<Avaliador>();
		avalidores.add(avaliador);
		avalidores.add(avaliador);
		
		aa.associarAvaliadores(new Artigo(), avalidores);
	}
	
	@Test(expected=RevistaException.class)
	public void deveLancarErroSeArtigoNaoEstaPendenteDeAvaliacao() throws RevistaException {
		Avaliador avaliador1 = new Avaliador();
		avaliador1.setId(1L);
		
		Avaliador avaliador2 = new Avaliador();
		avaliador2.setId(2L);
		
		List<Avaliador> avalidores = new ArrayList<Avaliador>();
		avalidores.add(avaliador1);
		avalidores.add(avaliador2);
		
		Artigo artigoJaEmAvaliacao = new Artigo();
		artigoJaEmAvaliacao.setId(1L);
		
		Artigo artigodb = new Artigo();
		artigodb.setId(1L);
		artigodb.setStatus(ArtigoStatusEnum.E);
		when(artigos.load(1L)).thenReturn(artigodb);
		
		aa.associarAvaliadores(artigoJaEmAvaliacao, avalidores);
	}
	
	@Test
	public void deveTerStatusEmAvaliacaoQuandoAssociado() throws RevistaException {
		List<Avaliador> avalidores = new ArrayList<Avaliador>();
		avalidores.add(avaliador1);
		avalidores.add(avaliador2);
		
		Artigo artigodb = new Artigo();
		artigodb.setId(1L);
		artigodb.setStatus(ArtigoStatusEnum.P);
		when(artigos.load(1L)).thenReturn(artigodb);

		aa.associarAvaliadores(artigodb, avalidores);

		verify(artigos).update(any(Artigo.class));
		assertTrue(artigodb.isEmAvaliacao());
	}
	
	@Test
	public void devePossuirOsAvaliadoresQuandoAssociado() throws RevistaException {
		List<Avaliador> avalidores = new ArrayList<Avaliador>();
		avalidores.add(avaliador1);
		avalidores.add(avaliador2);
		
		Artigo artigodb = new Artigo();
		artigodb.setId(1L);
		artigodb.setStatus(ArtigoStatusEnum.P);
		artigodb.setAvaliacoes(new ArrayList<AvaliacaoArtigo>());
		when(artigos.load(1L)).thenReturn(artigodb);

		aa.associarAvaliadores(artigodb, avalidores);
		
		assertEquals(2, artigodb.getAvaliacoes().size());
		
		assertTrue(artigodb.getAvaliacoes().get(0).isPendente());
		assertEquals(avaliador1, artigodb.getAvaliacoes().get(0).getAvaliador());

		assertTrue(artigodb.getAvaliacoes().get(1).isPendente());
		assertEquals(avaliador2, artigodb.getAvaliacoes().get(1).getAvaliador());
	}
	
	//TODO lancar erro se algum avaliador não for da revista do artigo?
}
