package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application { // fxml 실행하기 위한 클래스

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));
			primaryStage.setTitle("윷놀이");
			primaryStage.setScene(new Scene(root, 600, 600));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
