package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class Controller_Page2 implements Initializable{
	 @FXML
	 private Label Label;
	 
	 public static Label static_Label;

	@Override
	public void initialize(URL location, ResourceBundle arg1) {
		
		static_Label = Label;
	}

}
