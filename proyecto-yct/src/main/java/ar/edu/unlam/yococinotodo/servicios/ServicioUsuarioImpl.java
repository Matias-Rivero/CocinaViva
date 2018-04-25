package ar.edu.unlam.yococinotodo.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.yococinotodo.dao.UsuarioDao;
import ar.edu.unlam.yococinotodo.modelo.Usuario;

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
		
}
