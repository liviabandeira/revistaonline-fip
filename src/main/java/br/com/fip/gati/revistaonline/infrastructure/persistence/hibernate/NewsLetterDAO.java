package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Newsletter;
import br.com.fip.gati.revistaonline.domain.repositorio.NewsLetterRepositorio;

@Component
public class NewsLetterDAO  extends GenericDAO<Newsletter> implements NewsLetterRepositorio{

	private Session session;
	
	public NewsLetterDAO (Session session) {
		super(Newsletter.class, session);
		this.session = session;
	}
	
	/*public List<Newsletter> retornaListas(Long idRevista){
		List<Long> ids = new ArrayList<Long>();
		Query q = this.session.createQuery("from newsletter_assinantes where revista_id = " + idRevista);
		ids = q.list();
		System.out.println("Total de assinantes localizades pela revista: " + ids.size());
		return null;
	}*/
}
