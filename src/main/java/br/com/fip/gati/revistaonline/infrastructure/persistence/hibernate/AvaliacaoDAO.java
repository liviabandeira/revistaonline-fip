package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.enums.ArtigoStatusEnum;
import br.com.fip.gati.revistaonline.domain.model.enums.AvaliacaoStatusEnum;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliacaoRepositorio;

@Component
public class AvaliacaoDAO extends GenericDAO<AvaliacaoArtigo> implements AvaliacaoRepositorio{
	
	public AvaliacaoDAO (Session session) {
		super(AvaliacaoArtigo.class,session); 
	}

	public AvaliacaoArtigo getAvaliacao(Avaliador avaliador) {
		return (AvaliacaoArtigo) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
				.add(Restrictions.eq("avaliador_id", avaliador.getId()))
				.uniqueResult();
	}
	
	public List<AvaliacaoArtigo> getAvaliacoes(Avaliador avaliador) {
		if(avaliador == null) {
			throw new IllegalArgumentException("avaliador == null");
		}
		
		return (List<AvaliacaoArtigo>) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
			.add(Restrictions.eq("avaliador_id", avaliador.getId()))
			.list();
	}
	
	
	public List<AvaliacaoArtigo> getAvaliacoesPendentes(Avaliador avaliador) {
		if(avaliador == null) {
			throw new IllegalArgumentException("avaliador == null");
		}
		
		return (List<AvaliacaoArtigo>) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
			.add(Restrictions.eq("avaliador_id", avaliador.getId())).add(Restrictions.eq("status", AvaliacaoStatusEnum.P))
			.list();
	}
	
	public List<AvaliacaoArtigo> getAvaliacoesConcluidas(Avaliador avaliador) {
		if(avaliador == null) {
			throw new IllegalArgumentException("avaliador == null");
		}
		
		return (List<AvaliacaoArtigo>) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
			.add(Restrictions.eq("avaliador_id", avaliador.getId())).add(Restrictions.eq("status", AvaliacaoStatusEnum.A))
			.list();
	}
	
	
}
