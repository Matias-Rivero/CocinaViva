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
		session.save(ingrediente);
	}
	
	@Override
	public void guardarIngredienteEnInventario(Ingrediente ingrediente) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(ingrediente);
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

}
