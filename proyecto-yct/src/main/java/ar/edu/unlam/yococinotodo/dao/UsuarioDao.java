package ar.edu.unlam.yococinotodo.dao;

import ar.edu.unlam.yococinotodo.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);

	void guardarUsuario(Usuario usuario);
}
