package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Avaliador;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliadorRepositorio;

@Component
public class AvaliadorDAO extends GenericDAO<Avaliador> implements AvaliadorRepositorio {

	public AvaliadorDAO(Session session) {
		super(Avaliador.class, session);
	}
	
}
