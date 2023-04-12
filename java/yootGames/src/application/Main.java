package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage)throws Exception {
		try {
			   
	        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
	        primaryStage.setTitle("¿∑≥Ó¿Ã");
	        primaryStage.setScene(new Scene(root, 932, 647));
	        primaryStage.show();
	    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
