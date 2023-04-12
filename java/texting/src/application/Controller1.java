package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class Controller1 extends Controller2 implements Initializable {
	@FXML
    private TextField txtfield;

	

	@Override
	public void initialize(URL location, ResourceBundle arg1) {
		try {
			Stage prStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Page2.fxml"));
			Scene scene = new Scene(root,600,600);
			prStage.setScene(scene);
			prStage.setResizable(false);
			prStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	@FXML
	void button_action(ActionEvent event) {
		static_label.setText(txtfield.getText());
	}

}
