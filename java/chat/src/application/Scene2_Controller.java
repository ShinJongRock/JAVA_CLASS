package application;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2_Controller {

    @FXML
    private Label namelabel;
    
    public void displayName(String username) {
    	namelabel.setText(username);
    }
}
