package application;
import javafx.scene.paint.Color;

public class Player implements Comparable<Player>{  // ?”Œ? ˆ?´?–´ë¥? ?‚˜???‚´?Š” ?´?˜?Š¤

    int playerID;                 // ?‹ë³„ì
    int onBoardPieceNumber;       // ë³´ë“œ ?œ„?— ?ˆ?Š” ë§? ê°œìˆ˜
    int notOnBoardPieceNumber;    // ë³´ë“œ?— ?ˆì§? ?•Š?? ë§? ê°œìˆ˜
    int goalInNumber;             // ê³¨ì¸?•œ ë§? ê°œìˆ˜
    boolean turn;                 // ?˜„?¬ ?„´ ?—¬ë¶?
    Color color;                  // ?”Œ? ˆ?´?–´ë¥? ?‚˜???‚´?Š” ?ƒ‰
    boolean finish;               // ê²Œì„ ì¢…ë£Œ ?—¬ë¶?
    int finishOrder;              // ê²Œì„ ì¢…ë£Œ ?ˆœ?„œ
    boolean eatAndRollAgain;

    Player(int pieceNumber, int player){
        playerID = player;
        onBoardPieceNumber = 0;
        notOnBoardPieceNumber = pieceNumber;
        goalInNumber = 0;
        turn = false;
        finish = false;
        eatAndRollAgain = false;
        switch (player){
            case 0: color = Color.ORANGE;
                break;
            case 1: color = Color.GREEN;
                break;
            case 2: color = Color.PURPLE;
                break;
            case 3: color = Color.PINK;
                break;
        }
    }

    void addPieceOnBoard(){       // ë³´ë“œ ?œ„?— ë§ì„ ?•˜?‚˜ ?†“ê¸?
        onBoardPieceNumber++;
        notOnBoardPieceNumber--;
    }

    void deletePieceOnBoard(){    // ë³´ë“œ ?œ„?—?„œ ë§ì„ ?—†?• ê¸?
        onBoardPieceNumber--;
        notOnBoardPieceNumber++;
    }

    void addGoalInNumber(){       // ê³¨ì¸?•˜ê¸?
        goalInNumber++;
        onBoardPieceNumber--;
    }

    Color getColor(){             // ?”Œ? ˆ?´?–´ ?ƒ‰ getter
        return color;
    }

    @Override
    public int compareTo(Player p) {    // ?„?˜?˜ ?”Œ? ˆ?´?–´ ê°ì²´ ? •? ¬ ë°©ë²•
        if(this.goalInNumber < p.goalInNumber) {
            return 1;                               // ê³¨ì¸?•œ ?ˆ˜?— ???•´?„œ?Š” ?‚´ë¦¼ì°¨?ˆœ
        }
        else if(this.goalInNumber == p.goalInNumber) {
            if(this.finishOrder > p.finishOrder) {  // y?— ???•´?„œ?Š” ?˜¤ë¦„ì°¨?ˆœ
                return 1;
            }
        }
        return -1;
    }
}