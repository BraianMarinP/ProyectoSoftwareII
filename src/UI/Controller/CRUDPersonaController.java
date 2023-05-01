package UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import Domain.Modelo.Persona;
import Domain.Modelo.Rol;
import application.Persistencia;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CRUDPersonaController implements Initializable {

	@FXML
	private TableColumn<?, ?> colAutoridad;

	@FXML
	private TableColumn<?, ?> colDescripcion;

	@FXML
	private TableColumn<?, ?> colEmail;

	@FXML
	private TableColumn<?, ?> colIdPersona;

	@FXML
	private TableColumn<?, ?> colIdRol;

	@FXML
	private TableColumn<?, ?> colNombrePersona;

	@FXML
	private TableColumn<?, ?> colNombreRol;

	@FXML
	private TableColumn<?, ?> colTelefono;

	@FXML
	private TextField lbDireccion;

	@FXML
	private TextField lbEdad;

	@FXML
	private TextField lbEmail;

	@FXML
	private TextField lbEstadoCivil;

	@FXML
	private TextField lbFechaNacimiento;

	@FXML
	private TextField lbGenero;

	@FXML
	private TextField lbIdPersona;

	@FXML
	private TextField lbIdRol;

	@FXML
	private TextField lbNivelAutoridad;

	@FXML
	private TextField lbNombrePersona;

	@FXML
	private TextField lbNombreRol;

	@FXML
	private TextField lbTelefono;

	@FXML
	private TableView<Rol> tablaRoles;

	@FXML
	private TableView<Persona> tablaPersonas;

	@FXML
	private TextArea txtADescripcion;

	private Domain domain;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Columnas tabla de personas
		colIdPersona.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombrePersona.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		//Columnas tabla de roles
		colIdRol.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombreRol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		colAutoridad.setCellValueFactory(new PropertyValueFactory<>("nivelAutodidad"));
	}
	
	public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
		cargarPersonas();
		cargarRoles();
	}
	
	public void cargarPersonas() {
		domain.cargarPersonas(this);
	}
	
	public void cargarRoles() {
		domain.cargarRoles(this);
	}
	
	@FXML
	public void agregarPersona(ActionEvent event) {
		domain.agregarPersona(this);
		salvarDomain();
	}
	
	@FXML
	public void eliminarPersona(ActionEvent event) {
		domain.eliminarPersona(this);
		salvarDomain();
	}
	
	
	@FXML
	public void modificarPersona(ActionEvent event) {
		domain.modificarPersona(this);
		salvarDomain();
	}
	
	@FXML
	public void agregarRol(ActionEvent event) {
		domain.agregarRol(this);
		salvarDomain();
	}

	@FXML
	public void modificarRol(ActionEvent event) {
		domain.modificarRol(this);
		salvarDomain();
	}

	@FXML
	public void eliminarRol(ActionEvent event) {
		domain.eliminarRol(this);
		salvarDomain();
	}
	
	public void actualizarVista() {
		tablaPersonas.refresh();
		tablaRoles.refresh();
	}
	
	private void salvarDomain() {
		try {
			Persistencia.serializarObjectoXML("src/datos/datos.xml", domain);
		} catch (IOException e) {
			System.out.println("Error al guardar los datos en el archivo XML");
		}
	}
	

	public TextField getLbDireccion() {
		return lbDireccion;
	}

	public void setLbDireccion(TextField lbDireccion) {
		this.lbDireccion = lbDireccion;
	}

	public TextField getLbEdad() {
		return lbEdad;
	}

	public void setLbEdad(TextField lbEdad) {
		this.lbEdad = lbEdad;
	}

	public TextField getLbEmail() {
		return lbEmail;
	}

	public void setLbEmail(TextField lbEmail) {
		this.lbEmail = lbEmail;
	}

	public TextField getLbEstadoCivil() {
		return lbEstadoCivil;
	}

	public void setLbEstadoCivil(TextField lbEstadoCivil) {
		this.lbEstadoCivil = lbEstadoCivil;
	}

	public TextField getLbFechaNacimiento() {
		return lbFechaNacimiento;
	}

	public void setLbFechaNacimiento(TextField lbFechaNacimiento) {
		this.lbFechaNacimiento = lbFechaNacimiento;
	}

	public TextField getLbGenero() {
		return lbGenero;
	}

	public void setLbGenero(TextField lbGenero) {
		this.lbGenero = lbGenero;
	}

	public TextField getLbIdPersona() {
		return lbIdPersona;
	}

	public void setLbIdPersona(TextField lbIdPersona) {
		this.lbIdPersona = lbIdPersona;
	}

	public TextField getLbIdRol() {
		return lbIdRol;
	}

	public void setLbIdRol(TextField lbIdRol) {
		this.lbIdRol = lbIdRol;
	}

	public TextField getLbNivelAutoridad() {
		return lbNivelAutoridad;
	}

	public void setLbNivelAutoridad(TextField lbNivelAutoridad) {
		this.lbNivelAutoridad = lbNivelAutoridad;
	}

	public TextField getLbNombrePersona() {
		return lbNombrePersona;
	}

	public void setLbNombrePersona(TextField lbNombrePersona) {
		this.lbNombrePersona = lbNombrePersona;
	}

	public TextField getLbNombreRol() {
		return lbNombreRol;
	}

	public void setLbNombreRol(TextField lbNombreRol) {
		this.lbNombreRol = lbNombreRol;
	}

	public TextField getLbTelefono() {
		return lbTelefono;
	}

	public void setLbTelefono(TextField lbTelefono) {
		this.lbTelefono = lbTelefono;
	}

	public TableView<Rol> getTablaRoles() {
		return tablaRoles;
	}

	public void setTablaRoles(TableView<Rol> tablaRoles) {
		this.tablaRoles = tablaRoles;
	}

	public TableView<Persona> getTablaPersonas() {
		return tablaPersonas;
	}

	public void setTablaPersonas(TableView<Persona> tablaPersonas) {
		this.tablaPersonas = tablaPersonas;
	}

	public TextArea getTxtADescripcion() {
		return txtADescripcion;
	}

	public void setTxtADescripcion(TextArea txtADescripcion) {
		this.txtADescripcion = txtADescripcion;
	}
	
	public void limpiarCampos() {
		lbDireccion.setText("");
		lbEdad.setText("");
		lbEmail.setText("");
		lbEstadoCivil.setText("");
		lbFechaNacimiento.setText("");
		lbGenero.setText("");
		lbIdPersona.setText("");
		lbIdRol.setText("");
		lbNivelAutoridad.setText("");
		lbNombrePersona.setText("");
		lbNombreRol.setText("");
		lbTelefono.setText("");
	}

}
