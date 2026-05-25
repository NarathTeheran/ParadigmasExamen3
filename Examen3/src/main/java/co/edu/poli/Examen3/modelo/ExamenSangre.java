package co.edu.poli.Examen3.modelo;

import java.io.Serializable;

public class ExamenSangre extends ExamenMedico implements Serializable{
	private String rh;
	private String tipoSangre;
	
	public ExamenSangre(String id, String nombre, String fechaRealizacion, double costo, String rh, String tipoSangre) {
		super(id, nombre, fechaRealizacion, costo);
		this.rh = rh;
		this.tipoSangre = tipoSangre;
	}

	public String getRh() {
		return rh;
	}

	public void setRh(String rh) {
		this.rh = rh;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	@Override
	public String toString() {
		return "ExamenSangre [rh=" + rh + ", tipoSangre=" + tipoSangre + ", base: " + super.toString() + "]";
	}
	
}
