package ar.edu.unlam.cocinaviva.servicios;

import java.util.List;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;

public interface ServicioIngrediente {

	void guardarIngredienteEnInventario(Ingrediente ingrediente);
	
	void guardarIngredienteEnUsuario(Ingrediente ingrediente);

	List<Ingrediente> traerTodosLosIngredientes();
	
	Ingrediente buscarIngrediente(String ingrediente);

	List<Ingrediente> traerLosIngredientesLacteosDeUnUsuario(List<Ingrediente> listaIngredientesUs);

	List<Ingrediente> traerLosIngredientesVegetalesDeUnUsuario(List<Ingrediente> listaIngredientesUs);

	List<Ingrediente> traerLosIngredientesCarnesDeUnUsuario(List<Ingrediente> listaIngredientesUs);

	List<Ingrediente> traerLosIngredientesPescadoDeUnUsuario(List<Ingrediente> listaIngredientesUs);

	List<Ingrediente> traerLosIngredientesCondimentoDeUnUsuario(List<Ingrediente> listaIngredientesUs);

	List<Ingrediente> traerLosIngredientesOfrecidosEnLacteos(List<Ingrediente> listaDeTodosLosIngredientesOfrecidos);

	List<Ingrediente> traerLosIngredientesOfrecidosEnVegetales(List<Ingrediente> listaDeTodosLosIngredientesOfrecidos);

	List<Ingrediente> traerLosIngredientesOfrecidosEnCarnes(List<Ingrediente> listaDeTodosLosIngredientesOfrecidos);

	List<Ingrediente> traerLosIngredientesOfrecidosEnPescado(List<Ingrediente> listaDeTodosLosIngredientesOfrecidos);

	List<Ingrediente> traerLosIngredientesOfrecidosEnCondimento(List<Ingrediente> listaDeTodosLosIngredientesOfrecidos);

	Ingrediente traerUnIngredientePorSuId(Long id);

	List<Ingrediente> traerIngredientesSeleccionados(Integer[] seleccionados);

	void eliminarIngredienteAUsuario(Long idu, Long id);
	
	void eliminarIngrediente(Ingrediente ingrediente);

	Ingrediente generarListaDeIngredientes(List<Ingrediente> ingredientesSelec);

	void guardarIngredientesAUsuario(Long id, List<Ingrediente> listaIngredientes);
}
