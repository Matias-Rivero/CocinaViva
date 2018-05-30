package ar.edu.unlam.cocinaviva.dao;

import java.util.List;

import ar.edu.unlam.cocinaviva.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);

	void guardarUsuario(Usuario usuario);

	List<Usuario> traerTodosLosUsuarios();

	void guardarAdministrador(Usuario admin);
}
