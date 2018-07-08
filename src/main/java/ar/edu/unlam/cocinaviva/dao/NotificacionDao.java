package ar.edu.unlam.cocinaviva.dao;

import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

public interface NotificacionDao {

	void NuevaNotificacion(Notificacion notificacion, Usuario usuario);

	void UpdateNotificacion(Notificacion notificacion, Usuario usuario);

	String MensajeParaIngredienteVencido(Usuario usuario);

	String MensajeParaIngredienteProximoAVencer(Usuario usuario);

	String MensajeParaIngredientePasado(Usuario usuario);


}
