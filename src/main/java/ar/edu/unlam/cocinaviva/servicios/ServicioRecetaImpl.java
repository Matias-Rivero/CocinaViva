package ar.edu.unlam.cocinaviva.servicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.persistence.Transient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.cocinaviva.dao.IngredienteDao;
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
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioIngrediente servicioIngrediente;
	
	@Inject
	private IngredienteDao servicioIngredienteDao;

	@Override
	public void guardarReceta(Receta receta) {
		receta.setUso("RECETARIO");
		servicioRecetaDao.guardarReceta(receta);
	}
	
	@Override
	public void guardarRecetaCocinada(Receta receta) {
		receta.setUso("COCINOUSER");
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

	@Override
	public List<Ingrediente> traerListaDeIngredientesQueNoTiene(Receta receta, List<Ingrediente> ingredientesUs) {
		List<Ingrediente> ingredientesQueNoTiene = new LinkedList<Ingrediente>();

			for (Ingrediente ingredienteRc : receta.getListaIngrediente()) {
				if (ingredienteRc.getFaltante() == null) {
					ingredientesQueNoTiene.add(ingredienteRc);
				}
			}
		
		return ingredientesQueNoTiene;
	}

	@Override
	public List<Ingrediente> traerListaDeIngredientesQueTienePeroLeFalta(Receta receta,
			List<Ingrediente> ingredientesUs) {
		List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();

		for (Ingrediente ingredienteRc : receta.getListaIngrediente()) {
			if (ingredienteRc.getFaltante() != null && ingredienteRc.getFaltante() < 0) {
				ingredientes.add(ingredienteRc);
			}
		}
	
	return ingredientes;
	}

	@Override // RECETARIO DEUSUARIO COCINOUSER
	public void cocinarRecetaPorElUsuario(Receta receta, Usuario usuario) {
		Receta recetaCocina = realizarCopiaDeUnaRecetaDelRecetario(receta);
		guardarRecetaCocinada(recetaCocina);
		List<Receta> recetascocinadasdelusuario  = usuario.getlistaRecetas();		
		recetascocinadasdelusuario.add(recetaCocina);
		usuario.setlistaRecetas(recetascocinadasdelusuario);

				for (Ingrediente iReceta : receta.getListaIngrediente()) {
					for (Ingrediente iUser : usuario.getlistaIngrediente()) {

						if ((!(iUser.getEstado().equals("VENCIDO"))) && (!(iUser.getEstado().equals("AGOTADO")))) {

							if (iReceta.getNombre().equals(iUser.getNombre()) && iReceta.getCantidad() > 0 && iUser.getCantidad() > 0) {
							
							if (iUser.getCantidad() >= iReceta.getCantidad()) {
								iUser.setCantidad(iUser.getCantidad() - iReceta.getCantidad());
								iUser.setGastouser(iUser.getCantidad() - iReceta.getCantidad());
								iReceta.setCantidad(0);
								if(iUser.getCantidad() == 0){
								iUser.setEstado("AGOTADO");
								}
								servicioIngredienteDao.actualizarIngredientesAUsuario(iUser);
							}else{
								iReceta.setCantidad(iReceta.getCantidad() - iUser.getCantidad());
								iUser.setGastouser(iUser.getCantidad());
							    iUser.setCantidad(0);
							    iUser.setEstado("AGOTADO");
							    servicioIngredienteDao.actualizarIngredientesAUsuario(iUser);
							}
						}
				 	 }	

				 }
				 servicioUsuario.actualizarUsuario(usuario);
			  }
				
	}		
	

	@Override
	public Receta realizarCopiaDeUnaRecetaDelRecetario(Receta recetaDelRecetario) {
		
		LocalDateTime fechaActual = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String str = "1986-04-08 12:30";
		fechaActual.parse(str, formatter);		
		String fechaActualString = fechaActual.toString();
		fechaActualString = fechaActualString.replace("-", "/").replace("T", " ");
		fechaActualString = fechaActualString.substring(0, fechaActualString.length()-7); 
		
		Receta receta = new Receta();
		receta.setIdfake(recetaDelRecetario.getId());
		receta.setNombre(recetaDelRecetario.getNombre());
		receta.setImagen(recetaDelRecetario.getImagen());
		receta.setCalorias(recetaDelRecetario.getCalorias());
		receta.setTiempo(recetaDelRecetario.getTiempo());
		receta.setCarpeta(recetaDelRecetario.getCarpeta());
		receta.setFecha(fechaActualString);
		receta.setTipo(recetaDelRecetario.getTipo());
		receta.setDescripcion(recetaDelRecetario.getDescripcion());
		
		return receta;
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
