package ar.edu.unlam.cocinaviva.dao;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

import java.util.List;

public interface NotificacionDao {

	List<Notificacion> NotificacionesSinLeerParaUnUsuario(Usuario usuario, Ingrediente ingrediente);


}
