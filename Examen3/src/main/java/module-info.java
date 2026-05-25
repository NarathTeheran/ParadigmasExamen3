module co.edu.poli.Examen3 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

    opens co.edu.poli.Examen3.controlador to javafx.fxml;
    
    exports co.edu.poli.Examen3.vista;
}
