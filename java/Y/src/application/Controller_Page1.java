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

public class Controller_Page1 extends Controller_Page2 implements Initializable {

	@FXML
	private TextField txtfield;

	@Override
	public void initialize(URL location, ResourceBundle arg1) {
		try {
			Stage pStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Page2.fxml"));
			Scene scene = new Scene(root, 600, 600);
			pStage.setScene(scene);
			pStage.setResizable(false);
			pStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void button_action(ActionEvent event) {
		static_Label.setText(txtfield.getText());
	}

}
