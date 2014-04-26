package br.com.fip.gati.revistaonline.domain.service.artigo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.fip.gati.revistaonline.domain.exception.RevistaException;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.enums.ArtigoStatusEnum;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;

public class AssociacaoAvaliadores {
	private ArtigoRepositorio artigos;
	
	public AssociacaoAvaliadores(ArtigoRepositorio artigos) {
		this.artigos = artigos;
	}
	
	public void associarAvaliadores(Artigo artigo, List<Avaliador> avaliadores) throws RevistaException {
		if(artigo == null || avaliadores == null) throw new IllegalArgumentException();
		if(avaliadores.size() != 2) throw new RevistaException("A associação deve possuir 02 (dois) avaliadores");
		checarSeAvaliadoresSaoIguais(avaliadores);
		
		Artigo artigodb = artigos.load(artigo.getId());
		if(artigodb == null) {
			throw new IllegalArgumentException("artigo não encontrado");
		}
		
		if(!artigodb.isPendenteDeAvaliacao()) {
			throw new RevistaException("O artigo não está pendente de avaliação");
		}
		
		for(Avaliador av : avaliadores) {
			artigodb.associarAvaliador(av);
		}
		artigodb.setStatus(ArtigoStatusEnum.E);
		artigos.update(artigodb);
	}

	private void checarSeAvaliadoresSaoIguais(List<Avaliador> avaliadores) throws RevistaException {
		Set<Avaliador> avs = new HashSet<Avaliador>();
		for(Avaliador av : avaliadores) {
			if(avs.contains(av)) {
				throw new RevistaException("Os avaliadores não podem ser iguais");
			}
			avs.add(av);
		}
	}
	
}
