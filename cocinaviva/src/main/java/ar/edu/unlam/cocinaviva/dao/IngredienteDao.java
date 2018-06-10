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

}
