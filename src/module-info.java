module ProjectoSoftwareII_CAMU {
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	exports Domain;
	exports UI.Controller;
	exports Domain.Modelo;
	
	opens application to javafx.graphics, javafx.fxml;
	opens UI.Controller;
	opens Domain.Modelo;
	opens Domain.Fabrica;
}
