package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Edicao;
import br.com.fip.gati.revistaonline.domain.repositorio.EdicaoRepositorio;

@Component
public class EdicaoDAO extends GenericDAO<Edicao> implements EdicaoRepositorio {

	public EdicaoDAO(Session session) {
		super(Edicao.class, session);
	}

}
