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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Receta")
	private Long id;
	private String nombre;
	private String imagen;
	private Integer calorias;
	private Integer tiempo;
	private String carpeta;
	private String uso;
	private String tipo;
	private String descripcion;
	@Transient
	private List<String> pasosDeLaDescripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "recetas_ingredientes", joinColumns = { @JoinColumn(name = "id_Receta") }, inverseJoinColumns = {
			@JoinColumn(name = "id_Ingrediente") })
	private List<Ingrediente> listaIngrediente = new LinkedList<Ingrediente>();
	
	public List<Ingrediente> getListaIngrediente() {
		return listaIngrediente;
	}

	public void setListaIngrediente(List<Ingrediente> listaIngrediente) {
		this.listaIngrediente = listaIngrediente;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="recetas_pasos", joinColumns = @JoinColumn( name="id_Receta"), inverseJoinColumns = @JoinColumn( name="id_Pasos"))
	
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pasos> listaPasos = new LinkedList<Pasos>();	

	public void setlistaPasos(List<Pasos> listaPasos) {
		this.listaPasos = listaPasos;
	}
	
	public List<Pasos> getlistaPasos() {
	        return listaPasos;
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

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}
	
	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<String> getPasosDeLaDescripcion() {
		return pasosDeLaDescripcion;
	}

	public void setPasosDeLaDescripcion(List<String> pasosDeLaDescripcion) {
		this.pasosDeLaDescripcion = pasosDeLaDescripcion;
	}

}
