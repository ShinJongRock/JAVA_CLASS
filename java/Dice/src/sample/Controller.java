package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Random;

public class Controller {

    Random random = new Random();

    @FXML
    private ImageView diceImage;

    @FXML
    private Button rollButton;

    @FXML
    void roll(ActionEvent event) {

        rollButton.setDisable(true);

        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                try {
                    for (int i = 0; i < 20; i++) {   												//주사위 또로로로롤 15번
                        File file = new File("src/sample/dice/dice" + (random.nextInt(6)+1)+".png");  //이미지 파일 불러오기
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);														 //시간 0.05초
                    }
                    rollButton.setDisable(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }
}