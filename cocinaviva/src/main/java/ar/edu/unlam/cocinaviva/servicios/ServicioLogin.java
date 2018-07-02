package ar.edu.unlam.cocinaviva.servicios;

import ar.edu.unlam.cocinaviva.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
	
	Usuario consultarCorreoUsuario(Usuario usuario);
}
