package application;



import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Conttoller {

    @FXML
    private AnchorPane mybutton;

    @FXML
    private ImageView image;

    @FXML
    void show(MouseEvent event) {
    	image.setVisible(true);
    }

}
