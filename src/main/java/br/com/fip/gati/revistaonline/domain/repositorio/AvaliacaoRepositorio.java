package br.com.fip.gati.revistaonline.domain.repositorio;

import java.util.List;

import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;



public interface AvaliacaoRepositorio extends Repositorio<AvaliacaoArtigo> {
	
	public AvaliacaoArtigo getAvaliacao(Avaliador avaliador);
	public List<Artigo> getArtigosDeAvaliacoesPendente(Avaliador avaliador);
	public AvaliacaoArtigo getAutor(Artigo artigo);
	public List<Artigo> getArtigosDeAvaliacoesConcluidas(Avaliador avaliador); 
}
