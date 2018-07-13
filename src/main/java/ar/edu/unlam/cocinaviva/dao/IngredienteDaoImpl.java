package ar.edu.unlam.cocinaviva.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

import java.util.List;

import javax.inject.Inject;

@Repository("ingredienteDao")
public class IngredienteDaoImpl implements IngredienteDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarIngredienteEnUsuario(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ingrediente);
	}
	
	@Override
	public void guardarIngredienteEnReceta(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(ingrediente);
	}
	
	@Override
	public void guardarIngredienteEnInventario(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(ingrediente);
	}
	
	@Override
	public void eliminarIngrediente(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(ingrediente);
	}

	@Override
	public List<Ingrediente> traerTodosLosIngredientes() {
		return (sessionFactory.getCurrentSession().createCriteria(Ingrediente.class)
				.add(Restrictions.eq("uso", "INVENTARIO"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
	}

	@Override
	public Ingrediente buscarIngrediente(String ingrediente) {
		return (Ingrediente) (sessionFactory.getCurrentSession().createCriteria(Ingrediente.class)
				.add(Restrictions.eq("nombre", ingrediente)).uniqueResult());

	}

	@Override
	public Ingrediente traerUnIngredientePorSuId(Long id) {
		return (Ingrediente) (sessionFactory.getCurrentSession().createCriteria(Ingrediente.class).add(Restrictions.eq("id", id))
				.uniqueResult());
	}

	@Override
	public Ingrediente traerIngredienteDelInventarioAPartirDeIngredienteDelUsuario(Ingrediente ingredienteDelUs) {
		return (Ingrediente) (sessionFactory.getCurrentSession().createCriteria(Ingrediente.class)
				.add(Restrictions.eq("uso", "INVENTARIO"))
				.add(Restrictions.eq("nombre", ingredienteDelUs.getNombre()))
				.uniqueResult());	
	}

	@Override
	public List<Ingrediente> traerIngredienteDeRecetasAPartirDeIngredienteDelUsuario(Ingrediente ingredienteDelUs) {
		return (List<Ingrediente>) (sessionFactory.getCurrentSession().createCriteria(Ingrediente.class)
				.add(Restrictions.eq("uso", "RECETA"))
				.add(Restrictions.eq("nombre", ingredienteDelUs.getNombre()))
				.list());	
	}

	@Override
	public void actualizarIngredientesAUsuario(Ingrediente ingredienteUs) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(ingredienteUs);
	}

}
