package application;
import java.io.IOException;

import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SceneController extends Controller implements Initializable{
	
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private TextField Nickname;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));
			Scene first = new Scene(root);
			stage.setScene(first);
			stage.setResizable(false);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void switchToGame(ActionEvent event) throws IOException {
		
//		root = FXMLLoader.load(getClass().getResource("View.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		
		static_Label.setText(Nickname.getText()); // 닉네임 넘겨줌
		
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
}

	

