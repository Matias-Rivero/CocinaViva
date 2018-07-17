package ar.edu.unlam.cocinaviva.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Pasos;
import ar.edu.unlam.cocinaviva.modelo.Receta;

import java.util.List;

import javax.inject.Inject;

@Repository("recetaDao")
public class RecetaDaoImpl implements RecetaDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarReceta(Receta receta) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(receta);
	}
	
	@Override
	public List<Receta> traerTodasLasRecetas() {
		return (sessionFactory.getCurrentSession().createCriteria(Receta.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
	}
	
	@Override
	public Receta traerUnaRecetaPorSuId(Long id) {
		return (Receta) (sessionFactory.getCurrentSession().createCriteria(Receta.class).add(Restrictions.eq("id", id))
				.uniqueResult());
	}

	@Override
	  public List<Receta> buscarRecetasPorNombre(String nombre) {
	    return (sessionFactory.getCurrentSession().createCriteria(Receta.class)
	        .add(Restrictions.eq("uso", "RECETARIO"))
	        .add(Restrictions.like("nombre", "%"+nombre+"%"))
	        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
	  }

	@Override
	public void guardarPasoEnReceta(Pasos paso) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(paso);
	}
	
}
