package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;

import br.com.fip.gati.revistaonline.domain.model.Artigo;
import br.com.fip.gati.revistaonline.domain.repositorio.ArtigoRepositorio;

public class ArtigoDAO extends GenericDAO<Artigo> implements ArtigoRepositorio {

	public ArtigoDAO(Session session) {
		super(Artigo.class, session);
	}

}
