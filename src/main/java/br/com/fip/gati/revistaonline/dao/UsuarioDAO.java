package br.com.fip.gati.revistaonline.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.fip.gati.revistaonline.domain.model.Usuario;
import br.com.fip.gati.revistaonline.repositorio.UsuarioRepositorio;

@Component
public class UsuarioDAO extends GenericDAO<Usuario> implements UsuarioRepositorio {
	public UsuarioDAO(Session session) {
		super(Usuario.class, session);
	}
	
	public Usuario getUsuario(String login, String senha) {
		if (login == null || senha == null) {
			return null;
		}
		return (Usuario) getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login))
				.add(Restrictions.eq("senha", senha))
				.uniqueResult();
	}

	public Usuario getUsuario(String login) {
		if (login == null) {
			return null;
		}
		return (Usuario) getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login))
				.uniqueResult();
	}

	public long getTotalUsuariosAdministradores() {
		return ((Number) getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("admin", Boolean.TRUE))
				.setProjection(Projections.rowCount())
				.uniqueResult()).longValue();
	}
}
