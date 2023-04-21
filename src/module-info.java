module ProjectoSoftwareII_CAMU {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	exports UI.Controller;
	
	opens application to javafx.graphics, javafx.fxml;
	opens UI.Controller;
	opens Domain.Modelo;
	opens Domain.Fabrica;
}
