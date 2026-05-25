package co.edu.poli.Examen3.controlador;

import co.edu.poli.Examen3.modelo.ExamenMedico;
import co.edu.poli.Examen3.modelo.ExamenOrina;
import co.edu.poli.Examen3.servicios.ImplementacionOperacion;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {
    private ImplementacionOperacion servicio = new ImplementacionOperacion();

	@FXML
	private TextField txtCodigoExamen;
	@FXML
	private TextField txtNombrePaciente;
	@FXML
	private TextField txtCosto;
	@FXML
	private ComboBox<String> cmbNivelGlucosa;
	@FXML
	private TextField txtPh;
	@FXML
	private TextArea txtAreaMensajes;

	@FXML
	public void initialize() {

	}

	@FXML
	private void handleGuardar() {
		try {
			String id = txtCodigoExamen.getText();
            String nombre = txtNombrePaciente.getText();
            double costo = Double.parseDouble(txtCosto.getText());
            String glucosa = cmbNivelGlucosa.getValue();
            int nivelPh = Integer.parseInt(txtPh.getText());
            String fechaRealizacion = "25/05/2026";

            ExamenOrina examen = new ExamenOrina(id, nombre, fechaRealizacion, costo, glucosa, nivelPh);

            servicio.crear(examen);
            handleListar();
            mostrarMensaje("examen guardado correctamente");
            handleLimpiar();
            
        } catch (NumberFormatException e) {
        	txtAreaMensajes.setText("Error: Verifique que costo y ph tengan formatos numéricos válidos.");
        } catch (Exception e) {
        	txtAreaMensajes.setText("Error al guardar: " + e.getMessage());
        }
	}

	@FXML
	private void handleLimpiar() {
		txtCodigoExamen.clear();
		txtNombrePaciente.clear();
		txtCosto.clear();
		txtPh.clear();
		cmbNivelGlucosa.setValue(null);
	}

	@FXML
	private void handleSerializar() {
		try {
            servicio.serializar(
                    servicio.getExamenes(),
                    "",
                    "examenes.bin"
            );

            mostrarMensaje("Datos serializados correctamente");
            
        } catch (Exception e) {
        	mostrarMensaje("Error al guardar: " + e.getMessage());
        }
	}

	@FXML
	private void handleDeserializar() {
		try {
            ExamenMedico[] cargados = servicio.deserializar(
                    "",
                    "examenes.bin"
            );

            servicio.setSensores(cargados);
            mostrarMensaje("Datos deserializados correctamente");
            handleListar();

        } catch (Exception e) {
        	mostrarMensaje("Error al cargar: " + e.getMessage());
        }
	}

	@FXML
	private void handleListar() {
		try {
			txtAreaMensajes.clear();
			ExamenMedico[] examenes = servicio.leerTodos();

            for (ExamenMedico s : examenes) {
                if (s != null) {
                	txtAreaMensajes.appendText("Id: " + s.getId() + "\n");
                	txtAreaMensajes.appendText("Nombre paciente: " + s.getNombre() + "\n");
                	txtAreaMensajes.appendText("Costo: " + s.getCosto() + "\n");
                }
            }
		}catch (Exception e) {
        	mostrarMensaje("Error: " + e.getMessage());
        }
	}

	private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sistema de examenes");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
