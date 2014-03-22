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
	public List<Autor> getPorNome(String nome) {
		if(nome == null || nome.equals("")) return new ArrayList<Autor>();
		return getCurrentSession().createCriteria(Autor.class)
				.add(Restrictions.like("nome", nome, MatchMode.START))
				.setMaxResults(50)
				.list();
	}
	
}
