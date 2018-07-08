package ar.edu.unlam.cocinaviva.dao;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;

public interface NotificacionDao {

	void NuevaNotificacionVencimiento(Usuario usuario, Ingrediente ingrediente);

	void NuevaNotificacionSinStock(Usuario usuario, Ingrediente ingrediente);

	void UpdateNotificacion(Notificacion notificacion);

	void NuevaNotificacionIngredientePasado(Usuario usuario, Ingrediente ingrediente);

	String MensajeParaIngredienteVencido(Usuario usuario, Ingrediente ingrediente);

	String MensajeParaIngredienteProximoAVencer(Usuario usuario, Ingrediente ingrediente);

	String MensajeParaIngredientePasado(Usuario usuario);


}
