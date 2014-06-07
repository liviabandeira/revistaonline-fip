package br.com.fip.gati.revistaonline.infrastructure.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Newsletter;
import br.com.fip.gati.revistaonline.domain.model.Revista;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
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
	
	public boolean verificaNewsletterExistente(Revista revista, String email) {
		for (int i = 0; i < revista.getNewsletters().size(); i++) {
			Newsletter n = revista.getNewsletters().get(i);
			if (n.getEmail().equals(email)) {
				return true; 
			}
		}
		return false;
	}
	
	public Newsletter getNewsletter(String email) {
		if (email == null) {
			return null;
		}
		return (Newsletter) getCurrentSession().createCriteria(Newsletter.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}
}
