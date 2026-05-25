package co.edu.poli.Examen3.modelo;

import java.io.Serializable;

public class ExamenRayoX extends ExamenMedico implements Serializable{
	private String zonaAnalizada;
	private double nivelRadiacion;
	public ExamenRayoX(String id, String nombre, String fechaRealizacion, double costo, String zonaAnalizada, double nivelRadiacion) {
		super(id, nombre, fechaRealizacion, costo);
		this.zonaAnalizada = zonaAnalizada;
		this.nivelRadiacion = nivelRadiacion;
	}
	public String getZonaAnalizada() {
		return zonaAnalizada;
	}
	public void setZonaAnalizada(String zonaAnalizada) {
		this.zonaAnalizada = zonaAnalizada;
	}
	public double getNivelRadiacion() {
		return nivelRadiacion;
	}
	public void setNivelRadiacion(double nivelRadiacion) {
		this.nivelRadiacion = nivelRadiacion;
	}
	@Override
	public String toString() {
		return "ExamenRayoX [zonaAnalizada=" + zonaAnalizada + ", nivelRadiacion=" + nivelRadiacion + ", base: " + super.toString() + "]";
	}
}
