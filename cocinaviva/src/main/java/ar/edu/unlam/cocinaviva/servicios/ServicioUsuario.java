package ar.edu.unlam.cocinaviva.servicios;

import java.util.List;

import ar.edu.unlam.cocinaviva.modelo.Usuario;

public interface ServicioUsuario {

	void guardarUsuario(Usuario usuario);

	List<Usuario> traerTodosLosUsuarios();

	void guardarAdministrador(Usuario admin);

}
