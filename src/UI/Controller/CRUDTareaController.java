package UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Proyecto;
import Domain.Modelo.Tarea;
import application.Persistencia;
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
    private TableColumn<?, ?> colEstado;

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
    private TextField lbEstado;

    @FXML
    private TextField lbIdResponsable;

    @FXML
    private TextField lbIdTarea;

    @FXML
    private TextField lbNombre;

    @FXML
    private TextField lbPorcentaje;

    @FXML
    private TableView<Proyecto> tablaProyectos;

    @FXML
    private TableView<Tarea> tablaTareas;

    @FXML
    private TextArea txtADescripcion;

	private Domain domain;

	public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
		cargarProyectoAsignacionTareas();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// Columnas tabla tareas sin asignar
		colIdTarea.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombreTarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colFchInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
		colFchFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));
		colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		colPorcentajeTarea.setCellValueFactory(new PropertyValueFactory<>("porcentajeAvance"));
		colDescripcionTarea.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		// Columnas tabla de proyectos
		colIdProyecto.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNombreProyecto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colDescripcionProyecto.setCellValueFactory(new PropertyValueFactory<>("descripcion"));

	}
	
	/**
	 * Este método carga los proyectos
	 * en el CRUD de tareas para poder
	 * asignar tareas a dicho proyecto.
	 */
	public void cargarProyectoAsignacionTareas() {
		domain.cargarProyectoAsignacionTareas(this);
	}
	
	@FXML
	void cargarTareasPoryecto(MouseEvent event) {
		domain.cargarTareasPoryecto(this);
	}

	@FXML
	void agregarTarea(MouseEvent event) {
		domain.agregarTarea(this);
		cargarProyectoAsignacionTareas();
		salvarDomain();
	}

	@FXML
	void eliminarTarea(MouseEvent event) {
		domain.eliminarTarea(this);
		cargarProyectoAsignacionTareas();
		salvarDomain();
	}

	@FXML
	void modificarTarea(MouseEvent event) {
		domain.modificarTarea(this);
		cargarProyectoAsignacionTareas();
		salvarDomain();
	}

	public void actualizarVista() {
		tablaProyectos.refresh();
		tablaTareas.refresh();
	}
	
	private void salvarDomain() {
		try {
			Persistencia.serializarObjectoXML("src/datos/datos.xml", domain);
		} catch (IOException e) {
			System.out.println("Error al guardar los datos en el archivo XML");
		}
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

	public TextField getLbEstado() {
		return lbEstado;
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

	public TableView<Proyecto> getTablaProyectos() {
		return tablaProyectos;
	}

	public TableView<Tarea> getTablaTareas() {
		return tablaTareas;
	}

	public TextArea getTxtADescripcion() {
		return txtADescripcion;
	}

}
