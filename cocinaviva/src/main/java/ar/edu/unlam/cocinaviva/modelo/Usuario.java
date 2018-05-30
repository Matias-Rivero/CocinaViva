package ar.edu.unlam.cocinaviva.modelo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;	


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Usuario")
	private Long id;
	private String nombre;
	private String apellido;
	private String alias;
	private String email;
	private String password;
	private String repassword;
	private String rol;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_ingredientes", joinColumns = { @JoinColumn(name = "id_Usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_Ingrediente") })
	private List<Ingrediente> listaIngrediente = new LinkedList<Ingrediente>();
	
	public List<Ingrediente> getListaIngrediente() {
		return listaIngrediente;
	}

	public void setListaIngrediente(List<Ingrediente> listaIngrediente) {
		this.listaIngrediente = listaIngrediente;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
