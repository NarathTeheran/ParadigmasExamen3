package co.edu.poli.Examen3.modelo;

import java.io.Serializable;

public class ExamenOrina extends ExamenMedico implements Serializable{
	private String glucosa;
	private int nivelPH;
	public ExamenOrina(String id, String nombre, String fechaRealizacion, double costo, String glucosa, int nivelPH) {
		super(id, nombre, fechaRealizacion, costo);
		this.glucosa = glucosa;
		this.nivelPH = nivelPH;
	}
	public String getGlucosa() {
		return glucosa;
	}
	public void setGlucosa(String glucosa) {
		this.glucosa = glucosa;
	}
	public int getNivelPH() {
		return nivelPH;
	}
	public void setNivelPH(int nivelPH) {
		this.nivelPH = nivelPH;
	}
	@Override
	public String toString() {
		return "ExamenOrina [glucosa=" + glucosa + ", nivelPH=" + nivelPH + ", base: " + super.toString() + "]";
	}
}
