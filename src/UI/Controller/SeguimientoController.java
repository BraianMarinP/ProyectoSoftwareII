package UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Domain.Domain;
import javafx.fxml.Initializable;

public class SeguimientoController implements Initializable{

	private Domain domain;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void recibirBaseDatos(Domain domain) {
		this.domain = domain;
	}
    

}

