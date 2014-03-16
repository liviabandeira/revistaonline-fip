package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.repositorio.RevistaRepositorio;

@Component
public class RevistaDAO extends GenericDAO<Revista> implements RevistaRepositorio {

	public RevistaDAO(Session session) {
		super(Revista.class, session);
	}

}
