package ar.edu.unlam.cocinaviva.servicios;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.cocinaviva.dao.RecetaDao;
import ar.edu.unlam.cocinaviva.dao.UsuarioDao;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Pasos;
import ar.edu.unlam.cocinaviva.modelo.Receta;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

@Service("servicioReceta")
@Transactional
public class ServicioRecetaImpl implements ServicioReceta {

	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Inject
	private RecetaDao servicioRecetaDao;

	@Inject
	private ServicioIngrediente servicioIngrediente;

	@Override
	public void guardarReceta(Receta receta) {
		receta.setUso("GENERAL");
		servicioRecetaDao.guardarReceta(receta);
	}

	@Override
	public void guardarRecetaAUsuario(Long id, List<Receta> listaRecetas) {
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(id);

		// List<Receta> recetasdelusuario = usuario.getlistaRecetas();
		for (Receta recetasaagregar : listaRecetas) {
			// recetasdelusuario.add(recetasaagregar);
			guardarReceta(recetasaagregar);
		}
		servicioUsuarioDao.actualizarUsuario(usuario);
	}

	@Override
	public List<Receta> traerTodasLasRecetas() {
		return servicioRecetaDao.traerTodasLasRecetas();
	}

	@Override
	public Receta traerUnaRecetaPorSuId(Long id) {
		return servicioRecetaDao.traerUnaRecetaPorSuId(id);
	}

	@Override
	public List<Receta> traerRecetasAPartirDeIngredientesDelUsuario(List<Ingrediente> listaIngredientesUs) {

		List<Receta> todasLasRecetas = traerTodasLasRecetas();

		List<Ingrediente> listaIngredientesEnInventario = new LinkedList<Ingrediente>();
		
		for (Ingrediente ingredienteDelUs : listaIngredientesUs) {
			List<Ingrediente> IngredienteDeRecetas = servicioIngrediente.traerIngredienteDeRecetasAPartirDeIngredienteDelUsuario(ingredienteDelUs);
			for (Ingrediente idr : IngredienteDeRecetas) {
			listaIngredientesEnInventario.add(idr);
			}
		}
//		servicioIngrediente.traerIngredienteDelInventarioAPartirDeIngredienteDelUsuario(ingredienteDelUs));
		List<Receta> recetasConIDelUsuario = new LinkedList<Receta>();
		for (Receta receta : todasLasRecetas) {
			for (Ingrediente ingrediente : listaIngredientesEnInventario) {
				if (receta.getListaIngrediente().contains(ingrediente) && !recetasConIDelUsuario.contains(receta)) {
					recetasConIDelUsuario.add(receta);
				}
			}

		}
		return recetasConIDelUsuario;
	}

	@Override
	public List<Receta> traerLasRecetasCarnesDeUnUsuario(List<Receta> listaRecetasUs) {

		List<Receta> recetasCarnes = new LinkedList<Receta>();
		for (Receta carnes : listaRecetasUs) {
			if (carnes.getTipo().equals("CARNES")) {
				recetasCarnes.add(carnes);
			}
		}

		return recetasCarnes;
	}

	@Override
	public List<Receta> traerRecetasConFaltantesDeIngredientes(List<Receta> recetas, List<Ingrediente> ingredientesUs) {
		for (Receta receta : recetas) {
			for (Ingrediente ingredienteUs : ingredientesUs) {
				for (Ingrediente ingredienteRc : receta.getListaIngrediente()) {
					if (ingredienteRc.getNombre().equals(ingredienteUs.getNombre())) {
						if(ingredienteRc.getFaltante() != null){
							Integer faltanteRc = ingredienteRc.getFaltante();
							Integer sobranteUs = ingredienteUs.getCantidad();
							Integer resultado = faltanteRc + sobranteUs; // Si hay otro ingrediente igual
							ingredienteRc.setFaltante(resultado);
						}else{
							Integer resultado = (ingredienteUs.getCantidad() - ingredienteRc.getCantidad());
							ingredienteRc.setFaltante(resultado);	
						}
					}
				}
			}
		}
		return recetas;	
	}

	@Override
	public List<Receta> buscarRecetasPorNombre(String nombre) {
		return servicioRecetaDao.buscarRecetasPorNombre(nombre);
	}

	@Override
	public Receta traerRecetaConFaltantesDeIngredientes(Receta receta, List<Ingrediente> ingredientesUs) {
		for (Ingrediente ingredienteUs : ingredientesUs) {
			for (Ingrediente ingredienteRc : receta.getListaIngrediente()) {
				if (ingredienteRc.getNombre().equals(ingredienteUs.getNombre())) {
					if(ingredienteRc.getFaltante() != null){
						Integer faltanteRc = ingredienteRc.getFaltante();
						Integer sobranteUs = ingredienteUs.getCantidad();
						Integer resultado = faltanteRc + sobranteUs; // Si hay otro ingrediente igual
						ingredienteRc.setFaltante(resultado);
					}else{
						Integer resultado = (ingredienteUs.getCantidad() - ingredienteRc.getCantidad());
						ingredienteRc.setFaltante(resultado);	
					}
				}
			}
		}
	
	return receta;	
	}

	@Override
	public void guardarPasoEnReceta(Pasos paso) {
		servicioRecetaDao.guardarPasoEnReceta(paso);
	}

}
// Tipos de recetas
// Ensaladas
// Dieteticas
// Postres
// Diabeticos
// Carnes
// Pasta
// Tradicional
// Rapidas
// ComidaChina
// Mariscos
// Celiacos
