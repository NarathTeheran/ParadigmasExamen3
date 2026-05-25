package co.edu.poli.Examen3.servicios;

import co.edu.poli.Examen3.modelo.ExamenMedico;

public interface OperacionCRUD {
	String crear(ExamenMedico examen)throws Exception;
	ExamenMedico leerUno(String id);
	ExamenMedico[] leerTodos();
	String modificar(String id, ExamenMedico examen) throws Exception;
	ExamenMedico eliminar(String id) throws Exception;
}
