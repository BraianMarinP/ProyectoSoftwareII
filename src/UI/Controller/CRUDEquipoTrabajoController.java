package UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;

public class CRUDEquipoTrabajoController implements Initializable {

	@FXML
	private TableColumn<?, ?> colCargoEquipo;

	@FXML
	private TableColumn<?, ?> colDescripcion;

	@FXML
	private TableColumn<?, ?> colEmailIntegrante;

	@FXML
	private TableColumn<?, ?> colEmailPersonal;

	@FXML
	private TableColumn<?, ?> colIdEquipo;

	@FXML
	private TableColumn<?, ?> colIdIntegrante;

	@FXML
	private TableColumn<?, ?> colIdPersonal;

	@FXML
	private TableColumn<?, ?> colNombreIntegrante;

	@FXML
	private TableColumn<?, ?> colNombrePersonal;

	@FXML
	private TableColumn<?, ?> colTelefonoIntegrante;

	@FXML
	private TableColumn<?, ?> colTelefonoPersonal;

	@FXML
	private TextField lbCargo;

	@FXML
	private TextArea lbDescripcion;

	@FXML
	private TextField lbIdGrupo;

	@FXML
	private TableView<EquipoTrabajo> tablaEquipos;

	@FXML
	private TableView<Persona> tablaIntegrantes;

	@FXML
	private TableView<Persona> tablaPersonalDisponible;

	private Domain domain;

	public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
		domain.cargarEquipos(this);
		domain.cargarPersonalDisponible(this);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Columnas tabla equipo
		colIdEquipo.setCellValueFactory(new PropertyValueFactory<>("id"));
		colCargoEquipo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		// Columnas tabla de integrantes
		colIdIntegrante.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombreIntegrante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colTelefonoIntegrante.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		colEmailIntegrante.setCellValueFactory(new PropertyValueFactory<>("email"));
		// Columnas tabla de integrantes
		colIdPersonal.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombrePersonal.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colTelefonoPersonal.setCellValueFactory(new PropertyValueFactory<>("telefono"));
		colEmailPersonal.setCellValueFactory(new PropertyValueFactory<>("email"));
	}

	@FXML
	void cargarIntegrantes(MouseEvent event) {
		domain.cargarIntegrantes(this);
	}

    @FXML
    void cargarPersonalDisponible(MouseEvent event) {
    	domain.cargarPersonalDisponible(this);
    }

	@FXML
	void agregarEquipo(ActionEvent event) {
		domain.agregarEquipo(this);
	}

	@FXML
	void agregarIntegrante(ActionEvent event) {
		domain.agregarIntegrante(this);
		domain.cargarIntegrantes(this);
		domain.cargarPersonalDisponible(this);
	}

	@FXML
	void modificarEquipo(ActionEvent event) {
		domain.modificarEquipo(this);
	}

	@FXML
	void eliminarEquipo(ActionEvent event) {
		domain.eliminarEquipo(this);
		domain.cargarPersonalDisponible(this);
	}

	@FXML
	void eliminarIntegrante(ActionEvent event) {
		domain.eliminarIntegrante(this);
		domain.cargarIntegrantes(this);
		domain.cargarPersonalDisponible(this);
	}

	public void actualizarVista() {
		tablaEquipos.refresh();
		tablaIntegrantes.refresh();
		tablaPersonalDisponible.refresh();
	}

	public TextField getLbCargo() {
		return lbCargo;
	}

	public void setLbCargo(TextField lbCargo) {
		this.lbCargo = lbCargo;
	}

	public TextArea getLbDescripcion() {
		return lbDescripcion;
	}

	public void setLbDescripcion(TextArea lbDescripcion) {
		this.lbDescripcion = lbDescripcion;
	}

	public TextField getLbIdGrupo() {
		return lbIdGrupo;
	}

	public void setLbIdGrupo(TextField lbIdGrupo) {
		this.lbIdGrupo = lbIdGrupo;
	}

	public TableView<EquipoTrabajo> getTablaEquipos() {
		return tablaEquipos;
	}

	public void setTablaEquipos(TableView<EquipoTrabajo> tablaEquipos) {
		this.tablaEquipos = tablaEquipos;
	}

	public TableView<Persona> getTablaIntegrantes() {
		return tablaIntegrantes;
	}

	public void setTablaIntegrantes(TableView<Persona> tablaIntegrantes) {
		this.tablaIntegrantes = tablaIntegrantes;
	}

	public TableView<Persona> getTablaPersonalDisponible() {
		return tablaPersonalDisponible;
	}

	public void setTablaPersonalDisponible(TableView<Persona> tablaPersonalDisponible) {
		this.tablaPersonalDisponible = tablaPersonalDisponible;
	}

}
