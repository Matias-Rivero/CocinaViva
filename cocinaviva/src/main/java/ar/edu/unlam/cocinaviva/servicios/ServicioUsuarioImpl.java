package ar.edu.unlam.cocinaviva.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.cocinaviva.dao.UsuarioDao;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Override
	public void guardarUsuario (Usuario usuario) {
		usuario.setRol("Usuario");
		 servicioUsuarioDao.guardarUsuario(usuario);
	}

	@Override
	public List<Usuario> traerTodosLosUsuarios() {
		return servicioUsuarioDao.traerTodosLosUsuarios();
	}

	@Override
	public void guardarAdministrador(Usuario admin) {
		admin.setRol("Administrador");
		 servicioUsuarioDao.guardarAdministrador(admin);		
	}

	@Override
	public Usuario traerUnUsuarioPorSuId(Long id) {
		return servicioUsuarioDao.traerUnUsuarioPorSuId(id);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		servicioUsuarioDao.actualizarUsuario(usuario);		
	}
		
}
