package ar.edu.unlam.cocinaviva.servicios;

import ar.edu.unlam.cocinaviva.dao.NotificacionDao;
import ar.edu.unlam.cocinaviva.dao.NotificacionDaoImpl;
import ar.edu.unlam.cocinaviva.modelo.Ingrediente;
import ar.edu.unlam.cocinaviva.modelo.Notificacion;
import ar.edu.unlam.cocinaviva.modelo.Usuario;
import ar.edu.unlam.cocinaviva.servicios.ServicioNotificacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service("servicioNotificacion")
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {

	@Inject
	private SessionFactory sessionFactory;

	@Inject
	private NotificacionDao notificacionDao;


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
				break;
			default:
				notificacion.setMensaje("Mensaje para el ingrediente " + ingrediente.getNombre());
				break;
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);
		notificacion.setIdUsuario(usuario.getId());
		notificacion.setIdIngrediente(ingrediente.getId());


		if(estado.contains("VENCIDO")){

			notificacion.setTipoNotificacion("VENCIMIENTO");

		} else {

			notificacion.setTipoNotificacion("AVENCER");
		}


		if(validarNotificacion(usuario,ingrediente,"VENCIMIENTO")){
			final Session session = sessionFactory.getCurrentSession();
			session.save(notificacion);
		}

	}

	@Override
	public void NuevaNotificacionSinStock(Usuario usuario, Ingrediente ingrediente){

		List<Notificacion> notificaciones = notificacionDao.NotificacionesSinLeerParaUnUsuario(usuario,ingrediente);

		Notificacion notificacion = new Notificacion();
		notificacion.setEstado("SIN_LEER");
		String nombreIngrediente = ingrediente.getNombre();

		String mensaje = "Te quedaste sin " +nombreIngrediente+ " no te olvides de comprar mas." ;
		notificacion.setMensaje(mensaje);


		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);
		notificacion.setIdUsuario(usuario.getId());
		notificacion.setIdIngrediente(ingrediente.getId());
		notificacion.setTipoNotificacion("SIN_STOCK");



		if(validarNotificacion(usuario,ingrediente,"SIN_STOCK")){
			final Session session = sessionFactory.getCurrentSession();
			session.save(notificacion);
		}


	}

	@Override
	public void NuevaNotificacionIngredientePasado(Usuario usuario, Ingrediente ingrediente){

		Notificacion notificacion = new Notificacion();
		notificacion.setEstado("SIN_LEER");
		String nombreIngrediente = ingrediente.getNombre();
		String fechaCompra = ingrediente.getFcompra();
		//TODO COMPARAR LA FECHA DE COMPRA CON EL DIA DE LA FECHA, PARA SABER CUANDO PASARON CINCO DIAS.
		String mensaje = "Usted compro este ingrediente: "+ nombreIngrediente +" , el dia " +fechaCompra + " lleva en la heladera cinco dias o mas.";


		notificacion.setMensaje(mensaje);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String fecha = dateFormat.format(date);
		notificacion.setFechaNotificacion(fecha);
		notificacion.setIdUsuario(usuario.getId());
		notificacion.setIdIngrediente(ingrediente.getId());
		notificacion.setTipoNotificacion("PASADO");


		if(validarNotificacion(usuario,ingrediente,"PASADO")){
			final Session session = sessionFactory.getCurrentSession();
			session.save(notificacion);
		}


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
		String mensaje = "El ingrediente " +nombreIngrediente+" se encuentra vencido desde el dia " +fechaVencimiento ;
		return mensaje;

	}


	@Override
	public String MensajeParaIngredienteProximoAVencer(Usuario usuario, Ingrediente ingrediente){
		String nombreIngrediente = ingrediente.getNombre();
		String fechaVencimiento = ingrediente.getFvencimiento();
		String mensaje = "El ingrediente " +nombreIngrediente+" esta proximo a vencerse, utilicelo antes de la fecha: " +fechaVencimiento ;
		return mensaje;
	}



	@Override
	public String MensajeParaIngredientePasado(Usuario usuario){
		List<Ingrediente> ingredientesCarnes = usuario.getlistaIngrediente();
		return "Mensaje";

	}

	@Override
	public List<Notificacion> getNotificacionesParaUnUsuario(Usuario usuario){
	List<Notificacion> notificacionesUsuario = notificacionDao.GetNotificacionesParaUnUsuario(usuario);
	return notificacionesUsuario;

	}



	public boolean validarNotificacion(Usuario usuario, Ingrediente ingrediente, String tipoNotificacion){


		List<Notificacion> notificaciones = notificacionDao.NotificacionesSinLeerParaUnUsuario(usuario,ingrediente);

		for(Notificacion notificacionesUsu : notificaciones){

			if(!notificacionesUsu.getIdIngrediente().equals(ingrediente.getId() )){

			return true;

			} else {
				if(!notificacionesUsu.getTipoNotificacion().contains(tipoNotificacion)){

				return true;

				}
			}
			return false;
		}
		return true;
	}



}
