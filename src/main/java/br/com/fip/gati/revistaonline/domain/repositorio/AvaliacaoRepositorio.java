package br.com.fip.gati.revistaonline.domain.repositorio;

import java.util.List;

import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;



public interface AvaliacaoRepositorio extends Repositorio<AvaliacaoArtigo> {
	
	public AvaliacaoArtigo getAvaliacao(Avaliador avaliador);
	public List<AvaliacaoArtigo> getAvaliacoes(Avaliador avaliador);
	public List<AvaliacaoArtigo> getAvaliacoesPendentes(Avaliador avaliador);
	public List<AvaliacaoArtigo> getAvaliacoesConcluidas(Avaliador avaliador);
}
