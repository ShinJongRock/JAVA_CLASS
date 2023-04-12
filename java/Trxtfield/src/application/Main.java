package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	 @Override
	  public void start(Stage primaryStage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
	        primaryStage.setTitle("Application");
	        primaryStage.setScene(new Scene(root, 400, 400));
	        primaryStage.show();
	
	}
}
