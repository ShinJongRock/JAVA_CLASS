package application;

public class Piece{       // 말을 ?��???��?�� ?��?��?��
    int player;                   // ?��?�� ?��?��?��?���? ?��?��?���? ?��?���?
    boolean almostGoal;           // ?��바�?? ?���? ?��?�� 칸에 ?��?�� ?��?��?�� ??직일?�� 무조�? 골인?��?�� ?��?�� ?���?

    Piece(int player) {
        this.player = player;
        this.almostGoal = false;
    }

    Piece(int player, boolean almostGoal){
        this.player = player;
        this.almostGoal = almostGoal;
    }
}