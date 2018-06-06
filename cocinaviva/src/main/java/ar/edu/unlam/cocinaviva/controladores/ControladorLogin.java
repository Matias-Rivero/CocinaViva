package ar.edu.unlam.cocinaviva.controladores;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import ar.edu.unlam.cocinaviva.servicios.ServicioIngrediente;
import ar.edu.unlam.cocinaviva.servicios.ServicioLogin;
import ar.edu.unlam.cocinaviva.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;

	@Inject
	private ServicioUsuario servicioUsuario;

	@Inject
	private ServicioIngrediente servicioIngrediente;

	@RequestMapping("/home")
	public ModelAndView irAHome(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") != null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
			
			modelo.put("tieneingredienteselusuario",usuariologueado.getlistaIngrediente());	
	
			if(usuariologueado.getlistaIngrediente().isEmpty()){
				return new ModelAndView("redirect:/ingredientes");
			}
						
			modelo.put("ingredienteslacteosdelusuario",
					servicioIngrediente.traerLosIngredientesLacteosDeUnUsuario(usuariologueado.getlistaIngrediente()));			
			modelo.put("ingredientesvegetalesdelusuario", servicioIngrediente
					.traerLosIngredientesVegetalesDeUnUsuario(usuariologueado.getlistaIngrediente()));		
			modelo.put("ingredientescarnesdelusuario",
					servicioIngrediente.traerLosIngredientesCarnesDeUnUsuario(usuariologueado.getlistaIngrediente()));
			modelo.put("ingredientespescadodelusuario",
					servicioIngrediente.traerLosIngredientesPescadoDeUnUsuario(usuariologueado.getlistaIngrediente()));
			modelo.put("ingredientescondimentodelusuario", servicioIngrediente
					.traerLosIngredientesCondimentoDeUnUsuario(usuariologueado.getlistaIngrediente()));
			
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

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
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
			
		List<Ingrediente> Ingredientes = servicioIngrediente.traerIngredientesSeleccionados(checkingredientes.getSeleccionados());
		
		ModelMap modelo = new ModelMap();	
		
		modelo.put("ingredinetesseleccionados", Ingredientes);
		
		return new ModelAndView("recetas", modelo);
	}
	
	@RequestMapping("/ingredientes")
	public ModelAndView ingredientes(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") != null) {
			
			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");	
			
			modelo.put("tieneingredienteselusuario",usuariologueado.getlistaIngrediente());	
				
				List<Ingrediente> listaDeTodosLosIngredientesOfrecidos = servicioIngrediente.traerTodosLosIngredientes();
				modelo.put("ingredientesofrecidosenlacteos",
						servicioIngrediente.traerLosIngredientesOfrecidosEnLacteos(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ingredientesofrecidosenvegetales",
						servicioIngrediente.traerLosIngredientesOfrecidosEnVegetales(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ingredientesofrecidosencarnes",
						servicioIngrediente.traerLosIngredientesOfrecidosEnCarnes(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ingredientesofrecidosenpescado",
						servicioIngrediente.traerLosIngredientesOfrecidosEnPescado(listaDeTodosLosIngredientesOfrecidos));
				modelo.put("ingredientesofrecidosencondimento", servicioIngrediente
						.traerLosIngredientesOfrecidosEnCondimento(listaDeTodosLosIngredientesOfrecidos));
				
				Ingrediente checkingrediente = new Ingrediente();
				modelo.put("checkingredientes", checkingrediente);
			
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
			
			modelo.put("tieneingredienteselusuario",usuariologueado.getlistaIngrediente());	
			

			
			List<Ingrediente> listaDeTodosLosIngredientesOfrecidos = servicioIngrediente.traerTodosLosIngredientes();
			modelo.put("ingredientesofrecidosenlacteos",
					servicioIngrediente.traerLosIngredientesOfrecidosEnLacteos(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ingredientesofrecidosenvegetales",
					servicioIngrediente.traerLosIngredientesOfrecidosEnVegetales(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ingredientesofrecidosencarnes",
					servicioIngrediente.traerLosIngredientesOfrecidosEnCarnes(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ingredientesofrecidosenpescado",
					servicioIngrediente.traerLosIngredientesOfrecidosEnPescado(listaDeTodosLosIngredientesOfrecidos));
			modelo.put("ingredientesofrecidosencondimento", servicioIngrediente
					.traerLosIngredientesOfrecidosEnCondimento(listaDeTodosLosIngredientesOfrecidos));
			
			
			
		
		
		
		List<Ingrediente> Ingredientes = servicioIngrediente.traerIngredientesSeleccionados(checkingredientes.getSeleccionados());
			
		// Estos ingredientes deben persistirse
		modelo.put("ingredinetesseleccionados", Ingredientes);
		
		
		}else{
			return new ModelAndView("redirect:/home");
		}
		return new ModelAndView("agregaringredientes", modelo);
	}
}
