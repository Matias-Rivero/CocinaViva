package ar.edu.unlam.cocinaviva.dao;

import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import org.hibernate.Session;
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
	public void NuevaNotificacionVencimiento(Usuario usuario, Ingrediente ingrediente){

		Notificacion notificacion = new Notificacion();
		notificacion.setEstado("SIN_LEER");

		String estado = ingrediente.getEstado();

		switch (estado){
			case "VENCIDO":
				notificacion.setMensaje(MensajeParaIngredienteVencido(usuario,ingrediente));
				break;
			case "AVENCER":
				notificacion.setMensaje(MensajeParaIngredienteProximoAVencer(usuario,ingrediente));
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);


		final Session session = sessionFactory.getCurrentSession();
		session.save(notificacion);


	}

	@Override
	public void NuevaNotificacionSinStock(Usuario usuario, Ingrediente ingrediente){

		Notificacion notificacion = new Notificacion();
		notificacion.setEstado("SIN_LEER");
		String nombreIngrediente = ingrediente.getNombre();

		String mensaje = "Te quedaste sin " +nombreIngrediente+ " no te olvides de comprar mas." ;
		notificacion.setMensaje(mensaje);


		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);


		final Session session = sessionFactory.getCurrentSession();
		session.save(notificacion);


	}

	@Override
	public void NuevaNotificacionIngredientePasado(Usuario usuario, Ingrediente ingrediente){

		Notificacion notificacion = new Notificacion();
		notificacion.setEstado("SIN_LEER");
		String nombreIngrediente = ingrediente.getNombre();
		String fechaCompra = "08/07/2018";
		//TODO COMPARAR LA FECHA DE COMPRA CON EL DIA DE LA FECHA, PARA SABER CUANDO PASARON CINCO DIAS.
		String mensaje = "Usted compro este ingrediente el dia " +fechaCompra + "lleva en la heladera mas de 5 dias.";


		notificacion.setMensaje(mensaje);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);


		final Session session = sessionFactory.getCurrentSession();
		session.save(notificacion);


	}


	@Override
	public void UpdateNotificacion(Notificacion notificacion) {
		notificacion.setMensaje("LEIDA");
		final Session session = sessionFactory.getCurrentSession();
		session.save(notificacion);
	}


	@Override
	public String MensajeParaIngredienteVencido(Usuario usuario, Ingrediente ingrediente){

		String nombreIngrediente = ingrediente.getNombre();
		String fechaVencimiento = ingrediente.getFvencimiento();
		String mensaje = "El ingrediente " +nombreIngrediente+"se encuentra vencido desde el dia " +fechaVencimiento ;
		return mensaje;

	}


	@Override
	public String MensajeParaIngredienteProximoAVencer(Usuario usuario, Ingrediente ingrediente){
		String nombreIngrediente = ingrediente.getNombre();
		String fechaVencimiento = ingrediente.getFvencimiento();
		String mensaje = "El ingrediente " +nombreIngrediente+"esta proximo a vencerse, utilicelo antes de la fecha: " +fechaVencimiento ;
		return mensaje;
	}



	@Override
	public String MensajeParaIngredientePasado(Usuario usuario){
		List<Ingrediente> ingredientesCarnes = usuario.getlistaIngrediente();
		return "Mensaje";

	}






}
