package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1_Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	@FXML
	TextField nameTextField;
	
	@FXML
	private Button loginbutton;

	@FXML
	void login(ActionEvent event)throws IOException {
		String username = nameTextField.getText();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
		root = loader.load();
		
		Scene2_Controller scene2_Controller = loader.getController();
		scene2_Controller.displayName(username);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
