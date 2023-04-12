package application;
import java.util.Random;

public class Yut {  // ?œ·?„ ?‚˜???‚´?Š” ?´?˜?Š¤

    int status;	    // 0 ?˜?Š” 1ë¡? ?œ—ë©?, ?’·ë©? êµ¬ë¶„

    public int rollYut(){
        Random random = new Random();
        status = random.nextInt(2);
        return status;
    }
}