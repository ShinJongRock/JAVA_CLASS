package application;
import javafx.scene.paint.Color;

public class Player implements Comparable<Player>{  // ?? ?΄?΄λ₯? ????΄? ?΄??€

    int playerID;                 // ?λ³μ
    int onBoardPieceNumber;       // λ³΄λ ?? ?? λ§? κ°μ
    int notOnBoardPieceNumber;    // λ³΄λ? ?μ§? ??? λ§? κ°μ
    int goalInNumber;             // κ³¨μΈ? λ§? κ°μ
    boolean turn;                 // ??¬ ?΄ ?¬λΆ?
    Color color;                  // ?? ?΄?΄λ₯? ????΄? ?
    boolean finish;               // κ²μ μ’λ£ ?¬λΆ?
    int finishOrder;              // κ²μ μ’λ£ ??
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

    void addPieceOnBoard(){       // λ³΄λ ?? λ§μ ?? ?κΈ?
        onBoardPieceNumber++;
        notOnBoardPieceNumber--;
    }

    void deletePieceOnBoard(){    // λ³΄λ ??? λ§μ ?? κΈ?
        onBoardPieceNumber--;
        notOnBoardPieceNumber++;
    }

    void addGoalInNumber(){       // κ³¨μΈ?κΈ?
        goalInNumber++;
        onBoardPieceNumber--;
    }

    Color getColor(){             // ?? ?΄?΄ ? getter
        return color;
    }

    @Override
    public int compareTo(Player p) {    // ??? ?? ?΄?΄ κ°μ²΄ ? ? ¬ λ°©λ²
        if(this.goalInNumber < p.goalInNumber) {
            return 1;                               // κ³¨μΈ? ?? ???΄?? ?΄λ¦Όμ°¨?
        }
        else if(this.goalInNumber == p.goalInNumber) {
            if(this.finishOrder > p.finishOrder) {  // y? ???΄?? ?€λ¦μ°¨?
                return 1;
            }
        }
        return -1;
    }
}