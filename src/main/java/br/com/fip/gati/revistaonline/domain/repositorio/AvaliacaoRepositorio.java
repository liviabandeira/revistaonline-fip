package br.com.fip.gati.revistaonline.domain.repositorio;

import java.util.List;

import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;



public interface AvaliacaoRepositorio extends Repositorio<AvaliacaoArtigo> {
	
	public AvaliacaoArtigo getAvaliacao(Avaliador avaliador);
	public List<AvaliacaoArtigo> getAvaliacoesPendente(Avaliador avaliador);
	public AvaliacaoArtigo getAvaliacaoPorAutor(Artigo artigo);
	public List<AvaliacaoArtigo> getAvaliacoesConcluidas(Avaliador avaliador); 
}
