package ar.edu.unlam.cocinaviva.servicios;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.cocinaviva.dao.IngredienteDao;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;

@Service("servicioIngrediente")
@Transactional
public class ServicioIngredienteImpl implements ServicioIngrediente {

	@Inject
	private IngredienteDao servicioIngredienteDao;

	@Override
	public void guardarIngrediente (Ingrediente ingrediente) {
//		ingrediente.setRol("Usuario");
		 servicioIngredienteDao.guardarIngrediente(ingrediente);
	}

	@Override
	public List<Ingrediente> traerTodosLosIngredientes() {
		return servicioIngredienteDao.traerTodosLosIngredientes();
	}
		
	@Override
	public Ingrediente buscarIngrediente(String ingrediente) {
		return servicioIngredienteDao.buscarIngrediente(ingrediente);

	}

	@Override
	public List<Ingrediente> traerLosIngredientesLacteosDeUnUsuario(List<Ingrediente> listaIngredientesUs) {
		
		List<Ingrediente> ingredientesLacteos = new LinkedList<Ingrediente>();
		for (Ingrediente lacteos : listaIngredientesUs) {
			if (lacteos.getTipo().equals("LACTEOS")) {
				ingredientesLacteos.add(lacteos);
			}
		}
		
	//	List<Ingrediente> ingredientesLacteosNorep = new LinkedList<>(new HashSet<>(ingredientesLacteos));
	//	return ingredientesLacteosNorep;
		return ingredientesLacteos;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesVegetalesDeUnUsuario(List<Ingrediente> listaIngredientesUs) {
		List<Ingrediente> ingredientesVegetales = new LinkedList<Ingrediente>();
		for (Ingrediente vegetales : listaIngredientesUs) {
			if (vegetales.getTipo().equals("VEGETALES")) {
				ingredientesVegetales.add(vegetales);
			}
		}
		return ingredientesVegetales;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesCarnesDeUnUsuario(List<Ingrediente> listaIngredientesUs) {
		List<Ingrediente> ingredientesCarnes = new LinkedList<Ingrediente>();
		for (Ingrediente carnes : listaIngredientesUs) {
			if (carnes.getTipo().equals("CARNES")) {
				ingredientesCarnes.add(carnes);
			}
		}
		return ingredientesCarnes;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesPescadoDeUnUsuario(List<Ingrediente> listaIngredientesUs) {
		List<Ingrediente> ingredientesPescado = new LinkedList<Ingrediente>();
		for (Ingrediente pescado : listaIngredientesUs) {
			if (pescado.getTipo().equals("PESCADO")) {
				ingredientesPescado.add(pescado);
			}
		}
		return ingredientesPescado;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesCondimentoDeUnUsuario(List<Ingrediente> listaIngredientesUs) {
		List<Ingrediente> ingredientesCondimento = new LinkedList<Ingrediente>();
		for (Ingrediente condimento : listaIngredientesUs) {
			if (condimento.getTipo().equals("CONDIMENTOS")) {
				ingredientesCondimento.add(condimento);
			}
		}
		return ingredientesCondimento;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesOfrecidosEnLacteos(
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos) {
		List<Ingrediente> ingredientesLacteos = new LinkedList<Ingrediente>();
		for (Ingrediente lacteos : listaDeTodosLosIngredientesOfrecidos) {
			if (lacteos.getTipo().equals("LACTEOS")) {
				ingredientesLacteos.add(lacteos);
			}
		}
		return ingredientesLacteos;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesOfrecidosEnVegetales(
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos) {
		List<Ingrediente> ingredientesVegetales = new LinkedList<Ingrediente>();
		for (Ingrediente vegetales : listaDeTodosLosIngredientesOfrecidos) {
			if (vegetales.getTipo().equals("VEGETALES")) {
				ingredientesVegetales.add(vegetales);
			}
		}
		return ingredientesVegetales;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesOfrecidosEnCarnes(
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos) {
		List<Ingrediente> ingredientesCarnes = new LinkedList<Ingrediente>();
		for (Ingrediente carnes : listaDeTodosLosIngredientesOfrecidos) {
			if (carnes.getTipo().equals("CARNES")) {
				ingredientesCarnes.add(carnes);
			}
		}
		return ingredientesCarnes;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesOfrecidosEnPescado(
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos) {
		List<Ingrediente> ingredientesPescado = new LinkedList<Ingrediente>();
		for (Ingrediente pescado : listaDeTodosLosIngredientesOfrecidos) {
			if (pescado.getTipo().equals("PESCADO")) {
				ingredientesPescado.add(pescado);
			}
		}
		return ingredientesPescado;
	}

	@Override
	public List<Ingrediente> traerLosIngredientesOfrecidosEnCondimento(
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos) {
		List<Ingrediente> ingredientesCondimento = new LinkedList<Ingrediente>();
		for (Ingrediente condimento : listaDeTodosLosIngredientesOfrecidos) {
			if (condimento.getTipo().equals("CONDIMENTOS")) {
				ingredientesCondimento.add(condimento);
			}
		}
		return ingredientesCondimento;
	}

}
