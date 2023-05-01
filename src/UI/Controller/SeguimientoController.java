package UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import Domain.Domain;
import Domain.Modelo.Tarea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.*;

public class SeguimientoController implements Initializable {

	@FXML
	private TableColumn<?, ?> colAvance;

	@FXML
	private TableColumn<?, ?> colEstado;

	@FXML
	private TableColumn<?, ?> colFchFin;

	@FXML
	private TableColumn<?, ?> colFchInicio;

	@FXML
	private TableColumn<?, ?> colId;

	@FXML
	private TableColumn<?, ?> colNombre;

	@FXML
	private TextField lbIdProyecto;

	@FXML
	private TextField lbIdResponsable;

	@FXML
	private TextField lbIdTarea;

	@FXML
	private TableView<Tarea> tablaTareas;

	private Domain domain;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colFchInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
		colFchFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
		colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		colAvance.setCellValueFactory(new PropertyValueFactory<>("porcentajeAvance"));
	}

	public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
	}

	@FXML
	void buscarPorId(MouseEvent event) {
		domain.buscarPorId(this);
	}

	@FXML
	void buscarPorProyectos(MouseEvent event) {
		domain.buscarPorProyectos(this);
	}

	@FXML
	void buscarPorResponsable(MouseEvent event) {
		domain.buscarPorResponsable(this);
	}
	
	public void actualizarVista() {
		tablaTareas.refresh();
	}

	public TableColumn<?, ?> getColAvance() {
		return colAvance;
	}

	public TableColumn<?, ?> getColEstado() {
		return colEstado;
	}

	public TableColumn<?, ?> getColFchFin() {
		return colFchFin;
	}

	public TableColumn<?, ?> getColFchInicio() {
		return colFchInicio;
	}

	public TableColumn<?, ?> getColId() {
		return colId;
	}

	public TableColumn<?, ?> getColNombre() {
		return colNombre;
	}

	public TextField getLbIdProyecto() {
		return lbIdProyecto;
	}

	public TextField getLbIdResponsable() {
		return lbIdResponsable;
	}

	public TextField getLbIdTarea() {
		return lbIdTarea;
	}

	public TableView<Tarea> getTablaTareas() {
		return tablaTareas;
	}

	public Domain getDomain() {
		return domain;
	}
	
}
