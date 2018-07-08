package ar.edu.unlam.cocinaviva.servicios;

import ar.edu.unlam.cocinaviva.modelo.Notificacion;

import java.util.ArrayList;
import java.util.List;

public interface ServicioNotificacion {

	void NuevaNotificacion(Notificacion notificacion);

	void UpdateNotificacion(Notificacion notificacion);

}
