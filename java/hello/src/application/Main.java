package application;
	
import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			//stage > scene > contatiner > node
			
		//	Pane pane = new Pane();
			
			Label text = new Label();
			text.setText("hello");
			text.setStyle("-fx-fount-size: 30; -fx-text-fill: read;");
			
			StackPane pane  =new StackPane();
			pane.getChildren().add(text);
		
			Scene sc = new Scene(pane,800,500);
			
			stage.setScene(sc);
			
			stage.show();
			stage.setTitle("¿∑≥Ó¿Ã ∞‘¿”");
			stage.setResizable(false);  // ≈©±‚¡∂¡§ x
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
