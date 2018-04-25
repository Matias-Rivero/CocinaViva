package ar.edu.unlam.yococinotodo.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.yococinotodo.modelo.Usuario;
import ar.edu.unlam.yococinotodo.servicios.ServicioLogin;
import ar.edu.unlam.yococinotodo.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/home")
	public ModelAndView irAHome(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();

		if (request.getSession().getAttribute("usuariologueado") != null) {

			Usuario usuariologueado = (Usuario) request.getSession().getAttribute("usuariologueado");

			modelo.put("usuariologueado", usuariologueado);
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
	
	/* Consulta para insertar un usuario
	 * INSERT INTO `usuario` (`id`, `apellido`, `email`, `nombre`, `password`, `repassword`, `rol`) VALUES (NULL, 'Rivero', 'matias@gmail.com', 'Matias', 'matias', 'matias', 'Usuario');
	 * 
	 * 
	 */
}
