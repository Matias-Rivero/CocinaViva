package ar.edu.unlam.cocinaviva.servicios;

import java.util.List;

import org.hibernate.mapping.Map;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Pasos;
import ar.edu.unlam.cocinaviva.modelo.Receta;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

public interface ServicioReceta {
	
	void guardarReceta(Receta receta);
	
	void guardarRecetaAUsuario(Long id, List<Receta> listaRecetas);

	List<Receta> traerTodasLasRecetas();

	Receta traerUnaRecetaPorSuId(Long id);

	List<Receta> traerRecetasAPartirDeIngredientesDelUsuario(List<Ingrediente> listaIngredientes);

	List<Receta> traerLasRecetasCarnesDeUnUsuario(List<Receta> listaRecetasUs);

	List<Receta> traerRecetasConFaltantesDeIngredientes(List<Receta> recetas, List<Ingrediente> ingredientesUs);

	List<Receta> buscarRecetasPorNombre(String nombre);

	Receta traerRecetaConFaltantesDeIngredientes(Receta receta, List<Ingrediente> ingredientesUs);

	void guardarPasoEnReceta(Pasos paso);

	List<Ingrediente> traerListaDeIngredientesQueNoTiene(Receta recetaConFaltantes, List<Ingrediente> ingredientesUs);

	List<Ingrediente> traerListaDeIngredientesQueTienePeroLeFalta(Receta receta, List<Ingrediente> ingredientesUs);

	void cocinarRecetaPorElUsuario(Receta receta, Usuario usuario);

	Receta realizarCopiaDeUnaRecetaDelRecetario(Receta recetaDelRecetario);

	void guardarRecetaCocinada(Receta receta);

	java.util.Map<List<Receta>, Integer> traerRecetasConFaltantesDeIngredientesDeASeisElementos(List<Receta> recetas, Integer posicion);
	
}
