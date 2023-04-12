package application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{  // fxml 실행하기 위한 클래스

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("혈압윷놀이");
        primaryStage.setScene(new Scene(root, 932, 647));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
