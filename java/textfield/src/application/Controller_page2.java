package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller_page2 implements Initializable {
	@FXML
    private Label lable;

	
	public static Label Static_lable;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Static_lable = lable;
	}

}
