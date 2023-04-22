package UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	private final Domain domain = new Domain();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	public FXMLLoader cargarVentana(String rutaFXML) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		loader.getController();
		stage.setScene(scene);
		stage.show();
		return loader;
	}

	@FXML
    void cargarCRUDEquiposTrabajo(ActionEvent event) throws IOException {
		FXMLLoader loader = cargarVentana("/UI/CRUDEQuipoTrabajo.fxml");
		CRUDEquipoTrabajoController controlador = loader.getController();
		controlador.recibirBaseDatos(domain);
    }

	@FXML
	void cargarCRUDPersonas(ActionEvent event) throws IOException {
		FXMLLoader loader = cargarVentana("/UI/CRUDPersona.fxml");
		CRUDPersonaController controlador = loader.getController();
		controlador.recibirBaseDatos(domain);
	}

    @FXML
    void cargarCRUDProyectos(ActionEvent event) throws IOException {
    	FXMLLoader loader = cargarVentana("/UI/CRUDProyecto.fxml");
		CRUDProyectoController controlador = loader.getController();
		controlador.recibirBaseDatos(domain);
    }

    @FXML
    void cargarCRUDTareas(ActionEvent event) throws IOException {
    	FXMLLoader loader = cargarVentana("/UI/CRUDTarea.fxml");
		CRUDTareaController controlador = loader.getController();
		controlador.recibirBaseDatos(domain);
    }
    
    @FXML
    void cargarSeguimiento(ActionEvent event) throws IOException {
    	FXMLLoader loader = cargarVentana("/UI/Seguimiento.fxml");
		SeguimientoController controlador = loader.getController();
		controlador.recibirBaseDatos(domain);
    }
}
