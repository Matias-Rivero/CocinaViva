package ar.edu.unlam.cocinaviva.dao;

import java.util.List;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;

public interface IngredienteDao {

	void guardarIngredienteEnUsuario(Ingrediente ingrediente);
	
	void guardarIngredienteEnInventario(Ingrediente ingrediente);

	List<Ingrediente> traerTodosLosIngredientes();
	
	Ingrediente buscarIngrediente(String ingrediente);

	Ingrediente traerUnIngredientePorSuId(Long id);

	void eliminarIngrediente(Ingrediente ingrediente);

	Ingrediente traerIngredienteDelInventarioAPartirDeIngredienteDelUsuario(Ingrediente ingredienteDelUs);

	void guardarIngredienteEnReceta(Ingrediente ingrediente);

	List<Ingrediente> traerIngredienteDeRecetasAPartirDeIngredienteDelUsuario(Ingrediente ingredienteDelUs);

	void actualizarIngredientesAUsuario(Ingrediente ingredienteUs);

}
