package ar.edu.unlam.cocinaviva.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.cocinaviva.modelo.Usuario;

import java.util.List;

import javax.inject.Inject;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}
	
	@Override
	public Usuario consultarCorreoUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}

	@Override
	public List<Usuario> traerTodosLosUsuarios() {
		return (sessionFactory.getCurrentSession().createCriteria(Usuario.class).list());
	}

	@Override
	public void guardarAdministrador(Usuario admin) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(admin);		
	}

	@Override
	public Usuario traerUnUsuarioPorSuId(Long id) {
		return (Usuario) (sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("id", id))
				.uniqueResult());
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(usuario);
	}

}
