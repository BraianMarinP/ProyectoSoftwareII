package UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import Domain.Modelo.Proyecto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CRUDProyectoController implements Initializable{

    @FXML
    private TableColumn<Proyecto, String> colDescripcion;

    @FXML
    private TableColumn<Proyecto, String> colFchInicio;

    @FXML
    private TableColumn<Proyecto, String> colFchLimite;

    @FXML
    private TableColumn<Proyecto, String> colId;

    @FXML
    private TableColumn<Proyecto, String> colNombre;

    @FXML
    private TableColumn<Proyecto, String> colPorcentaje;

    @FXML
    private TextField lbFchInicio;

    @FXML
    private TextField lbFchLimite;

    @FXML
    private TextField lbIdEquipo;

    @FXML
    private TextField lbIdProyecto;

    @FXML
    private TextField lbIdSupervisor;

    @FXML
    private TextField lbNombre;

    @FXML
    private TextField lbPorcentaje;

    @FXML
    private TableView<Proyecto> tablaProyectos;
    
    @FXML
    private TextArea txtADescripcion;
    
    private Domain domain;
    
    public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
		//domain.cargarProyectos(this);
	}
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	//Columnas de la tabla proyectos
    	colId.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("id"));
		colNombre.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("nombre"));
		colFchInicio.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("fechaInicio"));
		colFchLimite.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("fechaLimite"));
		colPorcentaje.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("porcentajeAvance"));
		colDescripcion.setCellValueFactory(new PropertyValueFactory<Proyecto, String>("descripcion"));
	}
    
    
    @FXML
    void agregarProyecto(MouseEvent event) {
    	domain.agregarProyecto(this);
    }

    @FXML
    void eliminarProyecto(MouseEvent event) {
    	domain.eliminarProyecto(this);
    }

    @FXML
    void modificarProyecto(MouseEvent event) {
    	domain.modificarProyecto(this);
    }
    
    @FXML
    void mostrarInformacionProyecto(MouseEvent event) {
    	System.out.println("asdasd");
    	domain.mostrarInformacionProyecto(this);
    }
    
    public void actualizarVista() {
    	tablaProyectos.refresh();
    }

	public TableColumn<?, ?> getColDescripcion() {
		return colDescripcion;
	}

	public TableColumn<?, ?> getColFchInicio() {
		return colFchInicio;
	}

	public TableColumn<?, ?> getColFchLimite() {
		return colFchLimite;
	}

	public TableColumn<?, ?> getColId() {
		return colId;
	}

	public TableColumn<?, ?> getColNombre() {
		return colNombre;
	}

	public TableColumn<?, ?> getColPorcentaje() {
		return colPorcentaje;
	}

	public TextField getLbFchInicio() {
		return lbFchInicio;
	}

	public TextField getLbFchLimite() {
		return lbFchLimite;
	}

	public TextField getLbIdEquipo() {
		return lbIdEquipo;
	}

	public TextField getLbIdProyecto() {
		return lbIdProyecto;
	}

	public TextField getLbIdSupervisor() {
		return lbIdSupervisor;
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

	public TextArea getTxtADescripcion() {
		return txtADescripcion;
	}

}

