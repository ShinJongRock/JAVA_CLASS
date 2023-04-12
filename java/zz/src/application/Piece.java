package application;

public class Piece{       // ë§ì„ ?‚˜???‚´?Š” ?´?˜?Š¤
    int player;                   // ?–´?–¤ ?”Œ? ˆ?´?–´ê°? ?†Œ?œ ?•˜ê³? ?ˆ?Š”ì§?
    boolean almostGoal;           // ?•œë°”í?? ?Œê³? ?‹œ?‘ ì¹¸ì— ?ˆ?–´ ?‹¤?Œ?— ??ì§ì¼?•Œ ë¬´ì¡°ê±? ê³¨ì¸?•˜?Š” ?ƒ?ƒœ ?œ ë¬?

    Piece(int player) {
        this.player = player;
        this.almostGoal = false;
    }

    Piece(int player, boolean almostGoal){
        this.player = player;
        this.almostGoal = almostGoal;
    }
}