package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_page1 extends Controller_page2 implements Initializable {

	@FXML
	private TextField texrfield;

	@FXML
	void button_action(ActionEvent event) {
		Static_lable.setText(texrfield.getText());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Page2.fxml"));
			Scene first = new Scene(root);
			stage.setScene(first);
			stage.setResizable(false);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
