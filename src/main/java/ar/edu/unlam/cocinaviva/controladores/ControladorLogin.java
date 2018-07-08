package ar.edu.unlam.cocinaviva.controladores;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Receta;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import ar.edu.unlam.cocinaviva.servicios.ServicioIngrediente;
import ar.edu.unlam.cocinaviva.servicios.ServicioLogin;
import ar.edu.unlam.cocinaviva.servicios.ServicioReceta;
import ar.edu.unlam.cocinaviva.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioReceta servicioReceta;
	
	@Inject
	private ServicioIngrediente servicioIngrediente;

	@RequestMapping("/home")
	public ModelAndView irAHome(HttpServletRequest request) throws ParseException {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") != null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
			
			Usuario usuario = servicioUsuario.traerUnUsuarioPorSuId(usuariologueado.getId());
			
			modelo.put("tieneingredienteselusuario",usuario.getlistaIngrediente());

			servicioIngrediente.verificarEstadoDelIngrediente(usuario);

			if(usuario.getlistaIngrediente().isEmpty()){
				return new ModelAndView("redirect:/ingredientes");
			}
						
			modelo.put("ingredienteslacteosdelusuario",
					servicioIngrediente.traerLosIngredientesLacteosDeUnUsuario(usuario.getlistaIngrediente()));			
			modelo.put("ingredientesvegetalesdelusuario", servicioIngrediente
					.traerLosIngredientesVegetalesDeUnUsuario(usuario.getlistaIngrediente()));		
			modelo.put("ingredientescarnesdelusuario",
					servicioIngrediente.traerLosIngredientesCarnesDeUnUsuario(usuario.getlistaIngrediente()));
			modelo.put("ingredientespescadodelusuario",
					servicioIngrediente.traerLosIngredientesPescadoDeUnUsuario(usuario.getlistaIngrediente()));
			modelo.put("ingredientescondimentodelusuario", servicioIngrediente
					.traerLosIngredientesCondimentoDeUnUsuario(usuario.getlistaIngrediente()));
			
			Ingrediente checkingredientes = new Ingrediente();
			modelo.put("checkingredientes", checkingredientes);
			
		} else {
			Usuario usuario = new Usuario();
			modelo.put("usuario", usuario);
		}

		return new ModelAndView("home", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuariologueado, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuariologueado);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("usuariologueado", usuarioBuscado);

			model.put("usuariologueado", usuarioBuscado);

			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("home", model);
	}

	@RequestMapping("/registro")
	public ModelAndView registro(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") != null) {

			return new ModelAndView("redirect:/home");

		} else {
			Usuario usuario = new Usuario();
			modelo.put("usuario", usuario);
			return new ModelAndView("registro", modelo);
		}

	}

	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarCorreoUsuario(usuario);
		if (usuarioBuscado != null) {
			modelo.put("errors", "El email ya existe en la base de datos");
			return new ModelAndView("registro", modelo);
		} else {

			servicioUsuario.guardarUsuario(usuario);
			request.getSession().setAttribute("usuariologueado", usuario);
			return new ModelAndView("redirect:/home");
		}
	}

	@RequestMapping("/cerrarSesion")
	protected ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().removeAttribute("usuariologueado");
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/perfilcliente")
	public ModelAndView irAPerfilCliente(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") == null) {

			return new ModelAndView("redirect:/home");

		} else {

			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");

			modelo.put("usuariologueado", usuariologueado);

			return new ModelAndView("perfilcliente", modelo);
		}
	}
	
	@RequestMapping(path = "/recetas", method = RequestMethod.POST)
	public ModelAndView buscarRecetas(@ModelAttribute("checkingredientes") Ingrediente checkingredientes,
			HttpServletRequest request) {				
		
		if (request.getSession().getAttribute("usuariologueado") != null && (!(checkingredientes.getSeleccionados().equals(null)))) {
		ModelMap modelo = new ModelMap();
		
		Receta receta = new Receta();
		modelo.put("receta", receta);
		Ingrediente ingrediente = new Ingrediente();
		modelo.put("lingrediente", ingrediente);	
		List<Ingrediente> Ingredientes = servicioIngrediente.traerIngredientesSeleccionados(checkingredientes.getSeleccionados());
		List<Receta> recetas = servicioReceta.traerRecetasAPartirDeIngredientesDelUsuario(Ingredientes);
		List<Receta> recetasConFaltantes = servicioReceta.traerRecetasConFaltantesDeIngredientes(recetas,Ingredientes); // IngredelUS
		
		modelo.put("listaRecetas", recetasConFaltantes);
		modelo.put("listaRecetasLargo", recetas.size());
		modelo.put("ingredinetesseleccionados", Ingredientes);
		
		return new ModelAndView("recetas", modelo);
		}
	return new ModelAndView("redirect:/home");	
	}
	
	@RequestMapping(path = "/drecetas", method = RequestMethod.POST)
	public ModelAndView recetasDes(@ModelAttribute("lingrediente") Ingrediente ingrediente, HttpServletRequest request) {		
		
	if (request.getSession().getAttribute("usuariologueado") != null && (!(ingrediente.getSeleccionados().length == 1))) {
			ModelMap modelo = new ModelMap();	
		
			Receta receta = new Receta();
			modelo.put("receta", receta);	
			Ingrediente ingre = new Ingrediente();
			modelo.put("lingrediente", ingre);	
			
			List<Ingrediente> Ingredientes = servicioIngrediente.traerListaQuitandoIngrediente(ingrediente);
			List<Receta> recetas = servicioReceta.traerRecetasAPartirDeIngredientesDelUsuario(Ingredientes);
			List<Receta> recetasConFaltantes = servicioReceta.traerRecetasConFaltantesDeIngredientes(recetas,Ingredientes); // IngredelUS
			
			modelo.put("listaRecetas", recetasConFaltantes);
			modelo.put("listaRecetasLargo", recetas.size());
			modelo.put("ingredinetesseleccionados", Ingredientes);

			return new ModelAndView("recetas", modelo);
	}
	return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping("/ingredientes")
	public ModelAndView ingredientes(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") != null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
			
			Usuario usuario = servicioUsuario.traerUnUsuarioPorSuId(usuariologueado.getId());
			
			modelo.put("tieneingredienteselusuario",usuario.getlistaIngrediente());	
				
				List<Ingrediente> listaDeTodosLosIngredientesOfrecidos = servicioIngrediente.traerTodosLosIngredientes();
				modelo.put("iflacteos",
						servicioIngrediente.traerLosIngredientesOfrecidosEnLacteos(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ifvegetales",
						servicioIngrediente.traerLosIngredientesOfrecidosEnVegetales(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ifcarnes",
						servicioIngrediente.traerLosIngredientesOfrecidosEnCarnes(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ifpescado",
						servicioIngrediente.traerLosIngredientesOfrecidosEnPescado(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ifcondimento", servicioIngrediente
						.traerLosIngredientesOfrecidosEnCondimento(listaDeTodosLosIngredientesOfrecidos));
				
				Ingrediente checkingrediente = new Ingrediente();
				modelo.put("checkingredientes", checkingrediente);
				modelo.put("paso", "#1");
		}else{
			return new ModelAndView("redirect:/home");
		}
		return new ModelAndView("agregaringredientes", modelo);
	}

	@RequestMapping(path = "/agregarIngredientes", method = RequestMethod.POST)
	public ModelAndView agregarIngredientes(@ModelAttribute("checkingredientes") Ingrediente checkingredientes,
			HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		if (request.getSession().getAttribute("usuariologueado") != null || checkingredientes == null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");
			
			Usuario usuario = servicioUsuario.traerUnUsuarioPorSuId(usuariologueado.getId());
			
			modelo.put("tieneingredienteselusuario",usuario.getlistaIngrediente());	
					
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos = servicioIngrediente.traerTodosLosIngredientes();
			modelo.put("iflacteos",
					servicioIngrediente.traerLosIngredientesOfrecidosEnLacteos(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ifvegetales",
					servicioIngrediente.traerLosIngredientesOfrecidosEnVegetales(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ifcarnes",
					servicioIngrediente.traerLosIngredientesOfrecidosEnCarnes(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ifpescado",
					servicioIngrediente.traerLosIngredientesOfrecidosEnPescado(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ifcondimento", servicioIngrediente
					.traerLosIngredientesOfrecidosEnCondimento(listaDeTodosLosIngredientesOfrecidos));
		
		List<Ingrediente> ingredientesSelec = servicioIngrediente.traerIngredientesSeleccionados(checkingredientes.getSeleccionados());
		Ingrediente ingredientes = servicioIngrediente.generarListaDeIngredientes(ingredientesSelec);
		

		modelo.put("paso", "#2");
		modelo.put("listagramos", servicioIngrediente.traerListaDeGramos());
		modelo.put("ingrediente", ingredientes);
		
		
		}else{
			return new ModelAndView("redirect:/home");
		}
		return new ModelAndView("agregaringredientes", modelo);
	}
	
	@RequestMapping(path = "/eliminar-ingrediente")
	public ModelAndView eliminarIngrediente(@RequestParam("id") Long id, HttpServletRequest request) {
		
		if (request.getSession().getAttribute("usuariologueado") != null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
					
			servicioIngrediente.eliminarIngredienteAUsuario(usuariologueado.getId(),id);
					
		return new ModelAndView("redirect:/home");
	}
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path = "/altaIngredientes", method = RequestMethod.POST)
	public ModelAndView altaIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, HttpServletRequest request) {
		

	if (request.getSession().getAttribute("usuariologueado") != null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
			List<Ingrediente> listaIngredientes = ingrediente.getlistaIngredientes();
			servicioIngrediente.guardarIngredientesAUsuario(usuariologueado.getId(),listaIngredientes);	
			return new ModelAndView("redirect:/home");
	}return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path = "/modificar", method = RequestMethod.GET)
	  public ModelAndView modificar(HttpServletRequest request) {
	    
	    ModelMap modelo = new ModelMap();
	    
	    if (request.getSession().getAttribute("usuariologueado") != null) {
	      
	      Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");
	      
	      Usuario usuario = servicioUsuario.traerUnUsuarioPorSuId(usuariologueado.getId());

	      if(usuario.getlistaIngrediente().isEmpty()){
	        return new ModelAndView("redirect:/ingredientes");
	      }
	      
	      List<Ingrediente> ingredientesSelec = usuario.getlistaIngrediente();
		 Ingrediente ingredientes = servicioIngrediente.generarListaDeIngredientes(ingredientesSelec);
	      
	      modelo.put("tieneingredienteselusuario",usuario.getlistaIngrediente()); 
	      modelo.put("listagramos", servicioIngrediente.traerListaDeGramos());
	      modelo.put("ingrediente", ingredientes); 
	         
	    
	    }else{
	      return new ModelAndView("redirect:/home");
	    }
	    return new ModelAndView("modificar", modelo);
	  }

	@RequestMapping(path = "/modificar", method = RequestMethod.POST)
	public ModelAndView modificarIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente, HttpServletRequest request) {
		

	if (request.getSession().getAttribute("usuariologueado") != null) {
			ModelMap modelo = new ModelMap();
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
			List<Ingrediente> listaIngredientes = ingrediente.getlistaIngredientes();
			servicioIngrediente.modificarIngredientesDeUsuario(usuariologueado.getId(),listaIngredientes);	
			modelo.put("exitomodificar", "Excelente, exito al modificar");
			return new ModelAndView("redirect:/home");
	}return new ModelAndView("redirect:/home");
	}
	
	
// Si quieren acceder por GET	
	@RequestMapping("/validar-login")
	protected ModelAndView validarLogin() {
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/validar-registro")
	protected ModelAndView validarRegistro() {
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/recetas")
	protected ModelAndView recetas() {
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/drecetas")
	protected ModelAndView dRecetas() {
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/agregarIngredientes")
	protected ModelAndView agregarIngredientes() {
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/altaIngredientes")
	protected ModelAndView altaIngredientes() {
		return new ModelAndView("redirect:/home");
	}
	@RequestMapping("/modificar")
	protected ModelAndView modificarIngrediente() {
		return new ModelAndView("redirect:/home");
	}
}
