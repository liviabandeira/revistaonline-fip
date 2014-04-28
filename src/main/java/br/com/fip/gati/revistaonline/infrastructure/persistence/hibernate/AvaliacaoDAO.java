package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.AvaliacaoArtigo;
import br.com.fip.gati.revistaonline.domain.repositorio.AvaliacaoRepositorio;

@Component
public class AvaliacaoDAO extends GenericDAO<AvaliacaoArtigo> implements AvaliacaoRepositorio{
	
	public AvaliacaoDAO (Session session) {
		super(AvaliacaoArtigo.class,session); 
	}
	
}
