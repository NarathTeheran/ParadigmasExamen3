package co.edu.poli.Examen3.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.Examen3.modelo.ExamenMedico;

public class ImplementacionOperacion implements OperacionCRUD, OperacionArchivo{
	private ExamenMedico[] arregloExamen;
	
	public ImplementacionOperacion() {
		arregloExamen = new ExamenMedico[2];
    }
	
	public ExamenMedico[] getExamenes() {
        return arregloExamen;
    }

    public void setSensores(ExamenMedico[] examenes) {
        this.arregloExamen = examenes;
    }
    
    @Override
    public String crear(ExamenMedico examen) throws Exception {
        if (examen == null) {
            throw new Exception("El objeto examen es null");
        }

        if (examen.getId() == null || examen.getId().isEmpty()) {
            throw new Exception("El ID del examen no es válido");
        }

        for (ExamenMedico s : arregloExamen) {
            if (s != null && s.getId().equals(examen.getId())) {
                throw new Exception("Ya existe un examen con ese ID");
            }
        }

        for (int i = 0; i < arregloExamen.length; i++) {
            if (arregloExamen[i] == null) {
            	arregloExamen[i] = examen;
                return "examen creado correctamente";
            }
        }

        ExamenMedico[] nuevoArreglo = new ExamenMedico[arregloExamen.length * 2];
        for (int i = 0; i < arregloExamen.length; i++) {
            nuevoArreglo[i] = arregloExamen[i];
        }

        nuevoArreglo[arregloExamen.length] = examen;
        arregloExamen = nuevoArreglo;

        return "examen creado correctamente (arreglo redimensionado)";
    }
    
    @Override
    public ExamenMedico leerUno(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        for (ExamenMedico s : arregloExamen) {
            if (s != null && s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }
    
    @Override
    public ExamenMedico[] leerTodos() {
        int contador = 0;
        for (ExamenMedico s : arregloExamen) {
            if (s != null) {
                contador++;
            }
        }
        ExamenMedico[] resultado = new ExamenMedico[contador];
        int indice = 0;
        for (ExamenMedico s : arregloExamen) {
            if (s != null) {
                resultado[indice++] = s;
            }
        }
        return resultado;
    }

    @Override
    public String modificar(String id, ExamenMedico examen) throws Exception {

        if (id == null || id.isEmpty() || examen == null) {
            throw new Exception("Datos inválidos");
        }

        for (int i = 0; i < arregloExamen.length; i++) {
            if (arregloExamen[i] != null && arregloExamen[i].getId().equals(id)) {
            	arregloExamen[i] = examen;
                return "examen modificado correctamente";
            }
        }

        throw new Exception("examen no encontrado");
    }
    
    @Override
    public ExamenMedico eliminar(String id) throws Exception {

        if (id == null || id.isEmpty()) {
            throw new Exception("ID inválido");
        }

        for (int i = 0; i < arregloExamen.length; i++) {
            if (arregloExamen[i] != null && arregloExamen[i].getId().equals(id)) {
            	ExamenMedico eliminado = arregloExamen[i];
                arregloExamen[i] = null;
                return eliminado;
            }
        }

        throw new Exception("examen no encontrado");
    }
    
    @Override
	public String serializar(ExamenMedico[] examenes, String path, String name) throws Exception{
		FileOutputStream fos = new FileOutputStream(path + name);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(examenes);
		oos.close();
		fos.close();
		return "Archivo create!!";
	}
    
    @Override
	public ExamenMedico[] deserializar(String path, String name) throws Exception {
    	ExamenMedico[] a = null;
		FileInputStream fis = new FileInputStream(path + name);
		ObjectInputStream ois = new ObjectInputStream(fis);

		a = (ExamenMedico[]) ois.readObject();

		ois.close();
		fis.close();

		return a;
	}
}
