package application;
import java.util.Random;

public class Yut {  // ?·? ????΄? ?΄??€

    int status;	    // 0 ?? 1λ‘? ?λ©?, ?·λ©? κ΅¬λΆ

    public int rollYut(){
        Random random = new Random();
        status = random.nextInt(2);
        return status;
    }
}