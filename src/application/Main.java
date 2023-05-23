package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.Scene;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        /*Correo correo = new Correo();
        correo.crearEnviarCorreo("camuproyecto@gmail.com", 
        		"Primer correo", 
        		"Este es un correo de prueba de la aplicación de camu. Ignorar");*/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
