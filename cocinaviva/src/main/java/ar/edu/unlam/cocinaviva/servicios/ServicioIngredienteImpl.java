package ar.edu.unlam.cocinaviva.servicios;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.cocinaviva.dao.IngredienteDao;
import ar.edu.unlam.cocinaviva.dao.UsuarioDao;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Receta;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

@Service("servicioIngrediente")
@Transactional
public class ServicioIngredienteImpl implements ServicioIngrediente {

	@Inject
	private IngredienteDao servicioIngredienteDao;
	
	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Override
	public void guardarIngredienteEnInventario(Ingrediente ingrediente) {
		ingrediente.setUso("INVENTARIO");
		ingrediente.setCantidad(0);	
		ingrediente.setMedida("");
		ingrediente.setFvencimiento("");
		ingrediente.setEstado("NOVENCIDO"); // VENCIDO // ADVERTENCIA
		if(ingrediente.getTipo() == "CARNES"){
			ingrediente.setUnidad("Grs");	
		}
		if(ingrediente.getTipo() == "PESCADO"){
			ingrediente.setUnidad("Grs");	
		}
		 servicioIngredienteDao.guardarIngredienteEnInventario(ingrediente);
	}
	
	@Override
	public void guardarIngredienteEnUsuario(Ingrediente ingrediente) {
		ingrediente.setUso("USUARIO");
		 servicioIngredienteDao.guardarIngredienteEnUsuario(ingrediente);
	}

	@Override
	public void guardarIngredienteEnReceta(Ingrediente ingrediente) {
		ingrediente.setUso("RECETA");
		 servicioIngredienteDao.guardarIngredienteEnReceta(ingrediente);
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

	@Override
	public Ingrediente traerUnIngredientePorSuId(Long id) {
		return servicioIngredienteDao.traerUnIngredientePorSuId(id);
	}

	@Override
	public List<Ingrediente> traerIngredientesSeleccionados(Integer[] seleccionados) {
			Ingrediente i;
			List<Ingrediente> ingredientesSeleccionados = new LinkedList<Ingrediente>();
			for (Integer id : seleccionados) {
				i = traerUnIngredientePorSuId((long) id);
				ingredientesSeleccionados.add(i);
			}
			return ingredientesSeleccionados;
	}

	@Override
	public void eliminarIngredienteAUsuario(Long idu, Long id) {
	
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(idu);
		Ingrediente ingrediente = traerUnIngredientePorSuId(id);
			
		List<Ingrediente> ingredientesquetiene = usuario.getlistaIngrediente();
		
		ingredientesquetiene.remove(ingrediente);
		
		usuario.setlistaIngrediente(ingredientesquetiene);
				
		servicioUsuarioDao.actualizarUsuario(usuario);	
		
		eliminarIngrediente(ingrediente);
	}

	@Override
	public void eliminarIngrediente(Ingrediente ingrediente) {
		 servicioIngredienteDao.eliminarIngrediente(ingrediente);
	}

	@Override
	public Ingrediente generarListaDeIngredientes(List<Ingrediente> ingredientesSelec) {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setlistaIngredientes(ingredientesSelec);
		return ingrediente;
	}

	@Override
	public void guardarIngredientesAUsuario(Long id, List<Ingrediente> listaIngredientes) {
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(id);
		
		List<Ingrediente> ingredientesdelusuario  = usuario.getlistaIngrediente();
		for (Ingrediente ingredienteagregar : listaIngredientes) {
//			if (ingredientesuser.getNombre().equals("CONDIMENTOS")) {
//				ingredientesCondimento.add(condimento);
//			}
			ingredientesdelusuario.add(ingredienteagregar);
			guardarIngredienteEnUsuario(ingredienteagregar);			
		}		
		servicioUsuarioDao.actualizarUsuario(usuario);		
	}

	@Override
	public Ingrediente traerIngredienteDelInventarioAPartirDeIngredienteDelUsuario(Ingrediente ingredienteDelUs) {
		Ingrediente ingrediente = servicioIngredienteDao.traerIngredienteDelInventarioAPartirDeIngredienteDelUsuario(ingredienteDelUs);
		return ingrediente;
	}

	@Override
	public List<Ingrediente> traerIngredienteDeRecetasAPartirDeIngredienteDelUsuario(Ingrediente ingredienteDelUs) {
		List<Ingrediente> ingrediente = servicioIngredienteDao.traerIngredienteDeRecetasAPartirDeIngredienteDelUsuario(ingredienteDelUs);
		return ingrediente;
	}

	@Override
	public List<Ingrediente> traerListaQuitandoIngrediente(Ingrediente ingrediente) {
			
			Integer[] seleccionados = ingrediente.getSeleccionados();
			Ingrediente i;
			Long idver;
			List<Ingrediente> ingredientesSeleccionados = new LinkedList<Ingrediente>();
			for (Integer id : seleccionados) {
				idver = (long) id;
				if(!(idver.equals(ingrediente.getId()))){
				i = traerUnIngredientePorSuId(idver);
				ingredientesSeleccionados.add(i);
				}
			}
			return ingredientesSeleccionados;
	}

	@Override
	public ArrayList<String> traerListaDeGramos() {
		
		ArrayList<String>  listagramos = new ArrayList<String>();
		listagramos.add("50g");
		listagramos.add("100g");
		listagramos.add("150g");
		listagramos.add("200g");
		listagramos.add("250g");
		listagramos.add("300g");
		listagramos.add("350g");
		listagramos.add("400g");
		listagramos.add("450g");
		listagramos.add("500g");
		listagramos.add("550g");
		listagramos.add("600g");
		listagramos.add("650g");
		listagramos.add("700g");
		listagramos.add("750g");
		listagramos.add("800g");
		listagramos.add("850g");
		listagramos.add("900g");
		listagramos.add("950g");
		listagramos.add("1kg");
		listagramos.add("1k 50g");
		listagramos.add("1k 100g");
		listagramos.add("1k 150g");
		listagramos.add("1k 200g");
		listagramos.add("1k 250g");
		listagramos.add("1k 300g");
		listagramos.add("1k 350g");
		listagramos.add("1k 400g");
		listagramos.add("1k 450g");
		listagramos.add("1k 500g");
		listagramos.add("1k 550g");
		listagramos.add("1k 600g");
		listagramos.add("1k 650g");
		listagramos.add("1k 700g");
		listagramos.add("1k 750g");
		listagramos.add("1k 800g");
		listagramos.add("1k 850g");
		listagramos.add("1k 900g");
		listagramos.add("1k 950g");
		listagramos.add("2kg");
		listagramos.add("2k 50g");
		listagramos.add("2k 100g");
		listagramos.add("2k 150g");
		listagramos.add("2k 200g");
		listagramos.add("2k 250g");
		listagramos.add("2k 300g");
		listagramos.add("2k 350g");
		listagramos.add("2k 400g");
		listagramos.add("2k 450g");
		listagramos.add("2k 500g");
		listagramos.add("2k 550g");
		listagramos.add("2k 600g");
		listagramos.add("2k 650g");
		listagramos.add("2k 700g");
		listagramos.add("2k 750g");
		listagramos.add("2k 800g");
		listagramos.add("2k 850g");
		listagramos.add("2k 900g");
		listagramos.add("2k 950g");
		listagramos.add("3kg");
		listagramos.add("3k 50g");
		listagramos.add("3k 100g");
		listagramos.add("3k 150g");
		listagramos.add("3k 200g");
		listagramos.add("3k 250g");
		listagramos.add("3k 300g");
		listagramos.add("3k 350g");
		listagramos.add("3k 400g");
		listagramos.add("3k 450g");
		listagramos.add("3k 500g");
		listagramos.add("3k 550g");
		listagramos.add("3k 600g");
		listagramos.add("3k 650g");
		listagramos.add("3k 700g");
		listagramos.add("3k 750g");
		listagramos.add("3k 800g");
		listagramos.add("3k 850g");
		listagramos.add("3k 900g");
		listagramos.add("3k 950g");	
		
		return listagramos;
	}
	
	@Override
	public void modificarIngredientesDeUsuario(Long id, List<Ingrediente> listaIngredientes) {
		String modifique = "Modifique los datos";
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(id);
		 List<Ingrediente> ingredientesUs  = usuario.getlistaIngrediente();  
		    List<Ingrediente> ingredientesMd  = listaIngredientes;
		    
		     for (Ingrediente ingredienteUs : ingredientesUs) {
		       for (Ingrediente ingredienteMd : ingredientesMd) {           
		               if (ingredienteUs.getId().equals(ingredienteMd.getId())) {
		                 if (!(ingredienteUs.getFvencimiento().equals(ingredienteMd.getFvencimiento()))) {
		                   ingredienteUs.setFvencimiento(ingredienteMd.getFvencimiento());
		                   actualizarIngredientesAUsuario(ingredienteUs);
		                   modifique = "Modificacion Exitosa";
		                 }
		                 if (!(ingredienteUs.getCantidad().equals(ingredienteMd.getCantidad()))) {
		                   ingredienteUs.setCantidad(ingredienteMd.getCantidad());
		                   actualizarIngredientesAUsuario(ingredienteUs);
		                   modifique = "Modificacion Exitosa";
		                 }
		                     
		               }
		      
		      }
		    }
		     if(modifique != "Modifique los datos") {
		    servicioUsuarioDao.actualizarUsuario(usuario); 
		     }
		  }
	
	private void actualizarIngredientesAUsuario(Ingrediente ingredienteUs) {
		servicioIngredienteDao.actualizarIngredientesAUsuario(ingredienteUs);
	}

}
