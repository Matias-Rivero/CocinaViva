package ar.edu.unlam.cocinaviva.dao;

import java.util.List;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Pasos;
import ar.edu.unlam.cocinaviva.modelo.Receta;

public interface RecetaDao {

	void guardarReceta(Receta receta);

	List<Receta> traerTodasLasRecetas();

	Receta traerUnaRecetaPorSuId(Long id);

	List<Receta> buscarRecetasPorNombre(String nombre);

	void guardarPasoEnReceta(Pasos paso);

}
