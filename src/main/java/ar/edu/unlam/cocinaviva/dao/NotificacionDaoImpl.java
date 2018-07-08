package ar.edu.unlam.cocinaviva.dao;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository("notificacionDao")
public class NotificacionDaoImpl implements NotificacionDao {

	@Inject
    private SessionFactory sessionFactory;


	@Override
	public void NuevaNotificacion(Notificacion notificacion, Usuario usuario){
		notificacion.setEstado("SIN_LEER");

		notificacion.setMensaje("por ahora nada");

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);



	}

	@Override
	public void UpdateNotificacion(Notificacion notificacion, Usuario usuario) {

	}


	@Override
	public String MensajeParaIngredienteVencido(Usuario usuario){
		List<Ingrediente> ingredientesCarnes = usuario.getlistaIngrediente();
		return "Mensaje";

	}


	@Override
	public String MensajeParaIngredienteProximoAVencer(Usuario usuario){
		List<Ingrediente> ingredientesCarnes = usuario.getlistaIngrediente();
	return "Mensaje";
	}



	@Override
	public String MensajeParaIngredientePasado(Usuario usuario){
		List<Ingrediente> ingredientesCarnes = usuario.getlistaIngrediente();
		return "Mensaje";

	}






}
