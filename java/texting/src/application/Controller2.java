package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller2  implements Initializable{

	
	@FXML
	private Label label;


	public static Label static_label;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		static_label = label;
	}

}
