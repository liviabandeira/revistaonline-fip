package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.repositorio.AutorRepositorio;

@Component
public class AutorDAO extends GenericDAO<Autor> implements AutorRepositorio {

	public AutorDAO(Session session) {
		super(Autor.class, session);
	}

	@SuppressWarnings("unchecked")
	public List<Autor> getPorPreNome(String prenome) {
		if(prenome == null || prenome.equals("")) return new ArrayList<Autor>();
		return getCurrentSession().createCriteria(Autor.class)
				.add(Restrictions.like("prenome", prenome, MatchMode.START))
				.setMaxResults(50)
				.list();
	}
	
}
