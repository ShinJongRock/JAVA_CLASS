package YootGame;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController extends Controller implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private TextField Nickname;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML public void switchToGame(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("View.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		static_Label.setText(Nickname.getText()); // 닉네임 넘겨줌
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		ClientMain cl = new ClientMain();
		cl.startClient("10.20.28.29", 6789);
	}
	
	
}
	