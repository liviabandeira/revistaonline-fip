package br.com.fip.gati.revistaonline.application;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.exception.RevistaException;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;
import br.com.fip.gati.revistaonline.domain.service.artigo.AssociacaoAvaliadores;

@Component
public class AvaliacaoArtigoService {

	private ArtigoRepositorio artigos;
	
	public AvaliacaoArtigoService(ArtigoRepositorio artigos) {
		this.artigos = artigos;
	}
	
	public void associarAvaliadores(Artigo artigo, List<Avaliador> avaliadores) throws RevistaException {
		new AssociacaoAvaliadores(artigos).associarAvaliadores(artigo, avaliadores);
	}
	
}
