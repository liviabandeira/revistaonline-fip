package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
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
	
	public List<Artigo> getArtigosDeAvaliacoesPendente(Avaliador avaliador) {
		if(avaliador == null) {
			throw new IllegalArgumentException("avaliador == null");
		}
		
		return (List<Artigo>) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
			.add(Restrictions.eq("avaliador.id", avaliador.getId())).add(Restrictions.eq("status", AvaliacaoStatusEnum.P))
			.list();
	}
	
	public AvaliacaoArtigo getAutor(Artigo artigo) {
		if (artigo == null) {
			return null;
		}
		return (AvaliacaoArtigo) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
				.add(Restrictions.eq("artigo.id", artigo.getId()))
				.uniqueResult();
	}
	
	public List<Artigo> getArtigosDeAvaliacoesConcluidas(Avaliador avaliador) {
		if(avaliador == null) {
			throw new IllegalArgumentException("avaliador == null");
		}
		
		return (List<Artigo>) getCurrentSession().createCriteria(AvaliacaoArtigo.class)
			.add(Restrictions.eq("avaliador.id", avaliador.getId())).add(Restrictions.eq("status", AvaliacaoStatusEnum.A))
			.list();
	}
}
