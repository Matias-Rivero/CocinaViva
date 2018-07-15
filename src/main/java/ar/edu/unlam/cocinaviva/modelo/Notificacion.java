package ar.edu.unlam.cocinaviva.modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notificacion")
	private Long id;
	private String estado;
	private String mensaje;

	private String fechaNotificacion;

	private Long idUsuario;

	private Long idIngrediente;

	private String tipoNotificacion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_notificaciones", joinColumns = { @JoinColumn(name = "id_Usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_Notificacion") })



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFechaNotificacion() {
		return fechaNotificacion;
	}

	public void setFechaNotificacion(String fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}

	public Long getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Long idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

}
