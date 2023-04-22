package UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Tarea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CRUDTareaController implements Initializable {

	@FXML
	private TableColumn<?, ?> colDescripcionProyecto;

	@FXML
	private TableColumn<?, ?> colDescripcionTarea;

	@FXML
	private TableColumn<?, ?> colFchFin;

	@FXML
	private TableColumn<?, ?> colFchInicio;

	@FXML
	private TableColumn<?, ?> colIdCreador;

	@FXML
	private TableColumn<?, ?> colIdEstado;

	@FXML
	private TableColumn<?, ?> colIdProyecto;

	@FXML
	private TableColumn<?, ?> colIdTarea;

	@FXML
	private TableColumn<?, ?> colNombreProyecto;

	@FXML
	private TableColumn<?, ?> colNombreTarea;

	@FXML
	private TableColumn<?, ?> colPorcentajeTarea;

	@FXML
	private TextField lbFechaFin;

	@FXML
	private TextField lbFechaInicio;

	@FXML
	private TextField lbIdEstado;

	@FXML
	private TextField lbIdResponsable;

	@FXML
	private TextField lbIdTarea;

	@FXML
	private TextField lbNombre;

	@FXML
	private TextField lbPorcentaje;

	@FXML
	private TableView<EquipoTrabajo> tablaProyectos;

	@FXML
	private TableView<Tarea> tablaTareas;

	@FXML
	private TextArea txtADescripcion;

	private Domain domain;

	public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// Columnas tabla tareas sin asignar
		colIdTarea.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		colNombreTarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colFchInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
		colFchFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
		colIdEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		colPorcentajeTarea.setCellValueFactory(new PropertyValueFactory<>("porcentajeAvance"));
		colDescripcionTarea.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		// Columnas tabla de proyectos
		colIdProyecto.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombreProyecto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colDescripcionProyecto.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

	}

	@FXML
	void agregarTarea(MouseEvent event) {
		domain.agregarTarea(this);
	}

	@FXML
	void eliminarTarea(MouseEvent event) {
		domain.eliminarTarea(this);
	}

	@FXML
	void modificarTarea(MouseEvent event) {
		domain.modificarTarea(this);
	}

	public void actualizarVista() {
		tablaProyectos.refresh();
		tablaTareas.refresh();
	}

	public TableColumn<?, ?> getColDescripcionProyecto() {
		return colDescripcionProyecto;
	}

	public TableColumn<?, ?> getColDescripcionTarea() {
		return colDescripcionTarea;
	}

	public TableColumn<?, ?> getColFchFin() {
		return colFchFin;
	}

	public TableColumn<?, ?> getColFchInicio() {
		return colFchInicio;
	}

	public TableColumn<?, ?> getColIdCreador() {
		return colIdCreador;
	}

	public TableColumn<?, ?> getColIdEstado() {
		return colIdEstado;
	}

	public TableColumn<?, ?> getColIdProyecto() {
		return colIdProyecto;
	}

	public TableColumn<?, ?> getColIdTarea() {
		return colIdTarea;
	}

	public TableColumn<?, ?> getColNombreProyecto() {
		return colNombreProyecto;
	}

	public TableColumn<?, ?> getColNombreTarea() {
		return colNombreTarea;
	}

	public TableColumn<?, ?> getColPorcentajeTarea() {
		return colPorcentajeTarea;
	}

	public TextField getLbFechaFin() {
		return lbFechaFin;
	}

	public TextField getLbFechaInicio() {
		return lbFechaInicio;
	}

	public TextField getLbIdEstado() {
		return lbIdEstado;
	}

	public TextField getLbIdResponsable() {
		return lbIdResponsable;
	}

	public TextField getLbIdTarea() {
		return lbIdTarea;
	}

	public TextField getLbNombre() {
		return lbNombre;
	}

	public TextField getLbPorcentaje() {
		return lbPorcentaje;
	}

	public TableView<EquipoTrabajo> getTablaProyectos() {
		return tablaProyectos;
	}

	public TableView<Tarea> getTablaTareas() {
		return tablaTareas;
	}

	public TextArea getTxtADescripcion() {
		return txtADescripcion;
	}

}
