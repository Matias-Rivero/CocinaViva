package ar.edu.unlam.cocinaviva.dao;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository("notificacionDao")
public class NotificacionDaoImpl implements NotificacionDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<Notificacion> NotificacionesSinLeerParaUnUsuario(Usuario usuario, Ingrediente ingrediente) {

		Long idUsuario = usuario.getId();
		Long idIngrediente = ingrediente.getId();
		String className = "notificacion";

		return (List<Notificacion>) (sessionFactory.getCurrentSession().createCriteria(Notificacion.class)
				.add(Restrictions.eq("idUsuario", idUsuario))
				.add(Restrictions.eq("idIngrediente", idIngrediente))
				.add(Restrictions.eq("estado","SIN_LEER"))
				.list());
	}


}
