package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Autor;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;

@Component
public class AvaliadorDAO extends GenericDAO<Avaliador> implements AvaliadorRepositorio {

	public AvaliadorDAO(Session session) {
		super(Avaliador.class, session);
	}

	public Avaliador getAvaliador(Autor autor) {
		return (Avaliador) getCurrentSession().createCriteria(Avaliador.class)
			.add(Restrictions.eq("autor_id", autor.getId()))
			.uniqueResult();
	}
	
}
