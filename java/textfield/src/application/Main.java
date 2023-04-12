package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
    @Override
    public void start(Stage stage) {
       try {
           Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));
           Scene first = new Scene(root);
           stage.setTitle("¿∑≥Ó¿Ã");
           stage.setScene(first);
           stage.show();
       } catch(Exception e) {
          e.printStackTrace();
       }
    }
	public static void main(String[] args) {
		launch(args);
	}
}
