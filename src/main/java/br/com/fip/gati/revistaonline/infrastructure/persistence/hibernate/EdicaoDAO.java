package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Edicao;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.EdicaoRepositorio;

@Component
public class EdicaoDAO extends GenericDAO<Edicao> implements EdicaoRepositorio {

	public EdicaoDAO(Session session) {
		super(Edicao.class, session);
	}
	
	public List<Edicao> listByRevista(Revista revista){
		List<Edicao> edicoes = getCurrentSession().createCriteria(Edicao.class).add(Restrictions.eq("revista.id", revista.getId())).list();
		return edicoes;
	}

}
