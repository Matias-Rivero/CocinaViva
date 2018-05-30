package ar.edu.unlam.cocinaviva.dao;

import java.util.List;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;

public interface IngredienteDao {

	void guardarIngrediente(Ingrediente ingrediente);

	List<Ingrediente> traerTodosLosIngredientes();
	
	Ingrediente buscarIngrediente(String ingrediente);

}
