package co.edu.poli.Examen3.servicios;

import co.edu.poli.Examen3.modelo.ExamenMedico;

public interface OperacionArchivo {
	public String serializar(ExamenMedico[] examenes, String path, String name) throws Exception;
	public ExamenMedico[] deserializar(String path, String name) throws Exception;
}
