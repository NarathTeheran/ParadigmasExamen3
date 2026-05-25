package co.edu.poli.Examen3.modelo;

import java.io.Serializable;

public class ExamenMedico implements Serializable {
	private String id;
	private String nombre;
	private String fechaRealizacion;
	private double costo;
	
	public ExamenMedico(String id, String nombre, String fechaRealizacion, double costo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaRealizacion = fechaRealizacion;
		this.costo = costo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(String fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "ExamenMedico [id=" + id + ", nombre=" + nombre + ", fechaRealizacion=" + fechaRealizacion + ", costo="
				+ costo + "]";
	}
	
	
}
