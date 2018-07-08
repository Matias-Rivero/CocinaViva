package ar.edu.unlam.cocinaviva.servicios;

import ar.edu.unlam.cocinaviva.dao.IngredienteDao;
import ar.edu.unlam.cocinaviva.dao.NotificacionDao;
import ar.edu.unlam.cocinaviva.dao.UsuarioDao;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service("servicioNotificacion")
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {

	@Inject
	private NotificacionDao servicioNotificacionDao;
	
	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Override
	public void NuevaNotificacion(Notificacion notificacion){}

	@Override
	public void UpdateNotificacion(Notificacion notificacion){}


}
