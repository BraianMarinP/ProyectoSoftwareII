package UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import Domain.Fabrica.FactoryPersona;
import application.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	private Domain domain = new Domain();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			//domain = new Domain();
			//domain.setFactoryPersona(new FactoryPersona());
			//Persistencia.serializarObjectoXML("src/datos/datos.xml", domain);
			domain = (Domain) Persistencia.deserializadorObjetoXML("src/datos/datos.xml");
		} catch (IOException e) {
			System.out.println("Error al cargar el domain del archivo XML");
		}
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
