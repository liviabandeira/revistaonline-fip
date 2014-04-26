package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.domain.model.enums.ArtigoStatusEnum;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;


@Component
public class ArtigoDAO extends GenericDAO<Artigo> implements ArtigoRepositorio {
	public ArtigoDAO(Session session) {
		super(Artigo.class, session);
	}

	public Artigo getArtigo(String titulo, String resumo) {
		if (titulo == null || resumo == null) {
			return null;
		}
		
		return (Artigo) getCurrentSession().createCriteria(Artigo.class)
				.add(Restrictions.eq("titulo", titulo))
				.add(Restrictions.eq("resumo", resumo))
				.uniqueResult();
	}

	public List<Artigo> getArtigosPendentesParaAvaliacao(Revista revista) {
		if(revista == null) {
			throw new IllegalArgumentException("revista == null");
		}
		
		return (List<Artigo>) getCurrentSession().createCriteria(Artigo.class)
			.add(Restrictions.eq("status", ArtigoStatusEnum.P))
			.list();
	}
}
