package application;

public class Piece{       // λ§μ ????΄? ?΄??€
    int player;                   // ?΄?€ ?? ?΄?΄κ°? ?? ?κ³? ??μ§?
    boolean almostGoal;           // ?λ°ν?? ?κ³? ?? μΉΈμ ??΄ ?€?? ??μ§μΌ? λ¬΄μ‘°κ±? κ³¨μΈ?? ?? ? λ¬?

    Piece(int player) {
        this.player = player;
        this.almostGoal = false;
    }

    Piece(int player, boolean almostGoal){
        this.player = player;
        this.almostGoal = almostGoal;
    }
}