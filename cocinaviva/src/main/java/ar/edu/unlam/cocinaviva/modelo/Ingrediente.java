package ar.edu.unlam.cocinaviva.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Ingrediente")
	private Long id;
	private String nombre;
	private Integer [] seleccionados;
	private Integer cantidad;
	private Integer gramos;
	private String tipo;
	private Integer fvencimiento;
	private Integer fcompra;
	private String uso;
	private String estado;
	
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getGramos() {
		return gramos;
	}
	public void setGramos(Integer gramos) {
		this.gramos = gramos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer [] getSeleccionados() {
		return seleccionados;
	}
	public void setSeleccionados(Integer [] seleccionados) {
		this.seleccionados = seleccionados;
	}
	public Integer getFvencimiento() {
		return fvencimiento;
	}
	public void setFvencimiento(Integer fvencimiento) {
		this.fvencimiento = fvencimiento;
	}
	public Integer getFcompra() {
		return fcompra;
	}
	public void setFcompra(Integer fcompra) {
		this.fcompra = fcompra;
	}
	public String getUso() {
		return uso;
	}
	public void setUso(String uso) {
		this.uso = uso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
