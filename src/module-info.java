module ProjectoSoftwareII_CAMU {
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	exports Domain;
	exports UI.Controller;
	exports Domain.Modelo;
	exports Domain.Fabrica;
	
	opens application to javafx.graphics, javafx.fxml;
	opens UI.Controller;
	opens Domain.Modelo;
	opens Domain.Fabrica;
	
	requires javax.activation;
	requires javax.ejb;
	requires javax.faces.api;
	requires javax.inject;
	requires mail;
}
