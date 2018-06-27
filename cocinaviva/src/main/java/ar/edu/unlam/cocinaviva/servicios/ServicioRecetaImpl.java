package ar.edu.unlam.cocinaviva.servicios;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.cocinaviva.dao.RecetaDao;
import ar.edu.unlam.cocinaviva.dao.UsuarioDao;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Receta;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

@Service("servicioReceta")
@Transactional
public class ServicioRecetaImpl implements ServicioReceta {
	
	@Inject
	private UsuarioDao servicioUsuarioDao;
	
	@Inject
	private RecetaDao servicioRecetaDao;
	
	@Override
	public void guardarReceta(Receta receta) {
		 servicioRecetaDao.guardarReceta(receta);
	}
	
	@Override
	public void guardarRecetaAUsuario(Long id, List<Receta> listaRecetas) {
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(id);
		
//		List<Receta> recetasdelusuario  = usuario.getlistaRecetas();
		for (Receta recetasaagregar : listaRecetas) {
//			recetasdelusuario.add(recetasaagregar);
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
		List<Receta> recetasConIDelUsuario = new LinkedList<Receta>();
		for (int i = 0; i < todasLasRecetas.size(); i ++) {
		    if (!(listaIngredientesUs.contains(todasLasRecetas.get(i).getListaIngrediente()))) {
		    	recetasConIDelUsuario.add(todasLasRecetas.get(i));
		    }
		}
		return recetasConIDelUsuario;
		
//		for (Receta receta : todasLasRecetas) {
//		}
//				
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
//Tipos de recetas
	
//Ensaladas
//Dieteticas
//Postres
//Diabeticos
//Carnes
//Pasta
//Tradicional
//Rapidas
//ComidaChina		
//Mariscos
//Celiacos

}
