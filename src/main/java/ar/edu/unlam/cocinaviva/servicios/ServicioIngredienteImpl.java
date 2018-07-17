package ar.edu.unlam.cocinaviva.servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.time.temporal.ChronoUnit;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.joda.time.format.DateTimeFormat;

import ar.edu.unlam.cocinaviva.dao.IngredienteDao;
import ar.edu.unlam.cocinaviva.dao.UsuarioDao;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

@Service("servicioIngrediente")
@Transactional
public class ServicioIngredienteImpl implements ServicioIngrediente {

	@Inject
	private IngredienteDao servicioIngredienteDao;
	
	@Inject
	private UsuarioDao servicioUsuarioDao;
	
	@Inject
	private ServicioNotificacion servicioNotificacion;

	@Override
	public void guardarIngredienteEnInventario(Ingrediente ingrediente) {
		ingrediente.setUso("INVENTARIO");
		ingrediente.setCantidad(0);	
		ingrediente.setFvencimiento("");
		ingrediente.setFcompra(""); // VENCIDO // NOVENCIDO // AVENCER // AVISO // SINAVISO
		if(ingrediente.getPerece() == "SEPUDRE"){
			ingrediente.setEstado("SINAVISO");	
		}
		if(ingrediente.getPerece() == "SEVENCE"){	// PARA EL PESCADO
			ingrediente.setEstado("NOVENCIDO");	
		}
		// SEPUDRE // SEVENCE
		if(ingrediente.getTipo() == "CARNES"){
			ingrediente.setUnidad("Grs");
			ingrediente.setPerece("SEPUDRE");
			ingrediente.setEstado("SINAVISO");
		}
		if(ingrediente.getTipo() == "CONDIMENTOS" && ingrediente.getPerece() != "SEPUDRE" && ingrediente.getPerece() != "SEVENCE"){
			ingrediente.setPerece("SEVENCE");	
			ingrediente.setEstado("NOVENCIDO");
		}
		if(ingrediente.getTipo() == "LACTEOS" && ingrediente.getPerece() != "SEPUDRE" && ingrediente.getPerece() != "SEVENCE"){
			ingrediente.setPerece("SEVENCE");
			ingrediente.setEstado("NOVENCIDO");
		}
		if(ingrediente.getTipo() == "VEGETALES" && ingrediente.getPerece() != "SEPUDRE" && ingrediente.getPerece() != "SEVENCE"){
			ingrediente.setPerece("SEPUDRE");
			ingrediente.setEstado("SINAVISO");
		}	
		if(ingrediente.getTipo() == "PESCADO" && ingrediente.getUnidad() != "Unids"){
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
	public Ingrediente traerUnIngredienteDelInventarioPorSuNombre(String nombre) {
		return servicioIngredienteDao.traerUnIngredienteDelInventarioPorSuNombre(nombre);
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
		String DATE_FORMAT = "dd/MM/yyyy";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		LocalDate fechaActual = LocalDate.now();
		String fechaActualString;
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(id);		
		List<Ingrediente> ingredientesdelusuario  = usuario.getlistaIngrediente();		
		fechaActualString = dateFormat.format(java.sql.Date.valueOf(fechaActual));
		
		for (Ingrediente ingredienteagregar : listaIngredientes) {		//Agregue que meta fecha de compra la fecha actual al cargar ing
			if (ingredienteagregar.getPerece().equals("SEVENCE")) {		//En los que tienen fecha de vencimiento
				ingredienteagregar.setFcompra(fechaActualString);
			}
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
		String modifique = "Sin modificacion";
		Usuario usuario = servicioUsuarioDao.traerUnUsuarioPorSuId(id);
		 List<Ingrediente> ingredientesUs  = usuario.getlistaIngrediente();  
		    List<Ingrediente> ingredientesMd  = listaIngredientes;
		    
		     for (Ingrediente ingredienteUs : ingredientesUs) {
		       for (Ingrediente ingredienteMd : ingredientesMd) {           
		               if (ingredienteUs.getId().equals(ingredienteMd.getId())) {
		            	   
		            	if (ingredienteUs.getFvencimiento() != null) {   
		                 if (!(ingredienteUs.getFvencimiento().equals(ingredienteMd.getFvencimiento()))) {
		                   ingredienteUs.setFvencimiento(ingredienteMd.getFvencimiento());
		                   actualizarIngredientesAUsuario(ingredienteUs);
		                   modifique = "Modificacion Exitosa";
		                 }}
		                if (ingredienteUs.getFcompra() != null) {   
			                 if (!(ingredienteUs.getFcompra().equals(ingredienteMd.getFcompra()))) {
				                   ingredienteUs.setFcompra(ingredienteMd.getFcompra());
				                   actualizarIngredientesAUsuario(ingredienteUs);
				                   modifique = "Modificacion Exitosa";
				         }}		                
		                 if (!(ingredienteUs.getCantidad().equals(ingredienteMd.getCantidad()))) {
		                   ingredienteUs.setCantidad(ingredienteMd.getCantidad());
		                   actualizarIngredientesAUsuario(ingredienteUs);
		                   modifique = "Modificacion Exitosa";
		                 }
		            	  
		               }
		      
		      }
		    }
		     if(modifique != "Sin modificacion") {
		    servicioUsuarioDao.actualizarUsuario(usuario); 
		     }
		  }
	
	private void actualizarIngredientesAUsuario(Ingrediente ingredienteUs) {
		servicioIngredienteDao.actualizarIngredientesAUsuario(ingredienteUs);
	}

	@Override
	public void verificarEstadoDelIngrediente(Usuario usuario) throws ParseException {
		List<Ingrediente> ingredientesUs  = usuario.getlistaIngrediente();
		
		LocalDate fechaActual = LocalDate.now();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dfp = new SimpleDateFormat("dd/MM/yyyy");
		
		Long difDiasVence;
		Long difDiasAvisoSePudre;
		
		Date fechaIngVence;
		Date fechaIngSePudre;
		
		LocalDate fechaIngVenceEnLocalD;
		LocalDate fechaIngSePudreEnLocalD;
	
		 for (Ingrediente ingredienteUs : ingredientesUs) {
			 
			  if(ingredienteUs.getPerece().equals("SEVENCE")){
				  fechaIngVence =  df.parse(ingredienteUs.getFvencimiento());
				  
				  fechaIngVenceEnLocalD = fechaIngVence.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				  difDiasVence = ChronoUnit.DAYS.between(fechaActual, fechaIngVenceEnLocalD);
				  
				if(ingredienteUs.getDias() == null || (!ingredienteUs.getDias().equals(difDiasVence))){  
					ingredienteUs.setDias(difDiasVence);
					
				  if(difDiasVence <= 0){
					  ingredienteUs.setEstado("VENCIDO");
					  actualizarIngredientesAUsuario(ingredienteUs);					  
					  servicioNotificacion.NuevaNotificacionVencimiento(usuario,ingredienteUs);
					  servicioUsuarioDao.actualizarUsuario(usuario);
				  }else if(ingredienteUs.getEstado().equals("VENCIDO")){
					  ingredienteUs.setEstado("NOVENCIDO");
				  }
				  if(difDiasVence > 0 && difDiasVence <= 5){
					  ingredienteUs.setEstado("AVENCER"); 
					  actualizarIngredientesAUsuario(ingredienteUs);					  
					  servicioNotificacion.NuevaNotificacionVencimiento(usuario,ingredienteUs);
					  servicioUsuarioDao.actualizarUsuario(usuario);
				  }else if(ingredienteUs.getEstado().equals("AVENCER")){
					  ingredienteUs.setEstado("NOVENCIDO");
				  }	
				  
				} 
				
			  }	  
			  
			  if(ingredienteUs.getPerece().equals("SEPUDRE")){
				  		  
				  fechaIngSePudre = dfp.parse(ingredienteUs.getFcompra());
				  		 
				  fechaIngSePudreEnLocalD = fechaIngSePudre.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				  			 		  		  
				  difDiasAvisoSePudre = ChronoUnit.DAYS.between(fechaActual, fechaIngSePudreEnLocalD);
				  
				  if(ingredienteUs.getDias() == null || (!ingredienteUs.getDias().equals(difDiasAvisoSePudre)) ){  
					  ingredienteUs.setDias(difDiasAvisoSePudre);
				  
				  if(difDiasAvisoSePudre < 0 && difDiasAvisoSePudre <= -5){
					  ingredienteUs.setEstado("AVISO");  // Aviso que hace 5 dias que lo compraste fijate porque se pudre
					  actualizarIngredientesAUsuario(ingredienteUs);
					  servicioNotificacion.NuevaNotificacionVencimiento(usuario,ingredienteUs);
					  servicioUsuarioDao.actualizarUsuario(usuario);	  
				  }else if(ingredienteUs.getEstado().equals("AVISO")){
					  ingredienteUs.setEstado("SINAVISO");
				  }	
				  
				  }
			  
			  }  
			  
		 }
	}

	@Override
	public List<Ingrediente> traerListaDeIngredientesNoVencidosYNoAgotadosDeUnUsuario(Usuario usuario) {
		List<Ingrediente> ingUsuario  = usuario.getlistaIngrediente();
		List<Ingrediente> ingUsuarioSinVencidos  = new LinkedList<Ingrediente>();
		for (Ingrediente i : ingUsuario) {
			if ((!(i.getEstado().equals("VENCIDO"))) && (!(i.getEstado().equals("AGOTADO")))) {
				ingUsuarioSinVencidos.add(i);
			}
		}
		return ingUsuarioSinVencidos;		
	}

	@Override
	public void actualizarFVDeIngQuePerecen(Usuario usuario) throws ParseException {
		List<Ingrediente> ingUsuario  = usuario.getlistaIngrediente();

		LocalDate calculoVencimiento;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Date fechaIngSePudre;
		LocalDate fechaIngSePudreEnLocalD;
		
		String DATE_FORMAT = "dd/MM/yyyy";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		
		String resultado;
		
		for (Ingrediente ingredienteUs : ingUsuario) {
		 if(ingredienteUs.getPerece().equals("SEPUDRE")){
	  		  
			  fechaIngSePudre = df.parse(ingredienteUs.getFcompra());
			  		 
			  fechaIngSePudreEnLocalD = fechaIngSePudre.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			  calculoVencimiento = fechaIngSePudreEnLocalD.plusDays(7);			  
			  resultado = dateFormat.format(java.sql.Date.valueOf(calculoVencimiento));
			  if(ingredienteUs.getFvencimiento() != resultado){
			  ingredienteUs.setFvencimiento(resultado);
			  actualizarIngredientesAUsuario(ingredienteUs);
			  servicioUsuarioDao.actualizarUsuario(usuario);
			  }
//			  System.out.println("=======Nombre Ingrediente: " +ingredienteUs.getNombre()+", fecha ant: "+fechaIngSePudreEnLocalD+"");
//			  System.out.println("=======Nombre Ingrediente: " +ingredienteUs.getNombre()+", fecha desp 7: "+calculoVencimiento+"");
//			  System.out.println("=======Nombre Ingrediente: " +ingredienteUs.getNombre()+", fecha: "+resultado+"");		  
		  }  
		}		
		
	}

	@Override
	public Ingrediente traerCopiaDeUnIngredienteDelInventario(Ingrediente ingredienteDelInventario) {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNombre(ingredienteDelInventario.getNombre());		
		ingrediente.setUnidad(ingredienteDelInventario.getUnidad());
		ingrediente.setTipo(ingredienteDelInventario.getTipo());
		ingrediente.setPerece(ingredienteDelInventario.getPerece());
		ingrediente.setEstado(ingredienteDelInventario.getEstado());
		return ingrediente;
	}
	
}
