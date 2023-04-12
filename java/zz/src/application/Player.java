package application;
import javafx.scene.paint.Color;

public class Player implements Comparable<Player>{  // ?��?��?��?���? ?��???��?�� ?��?��?��

    int playerID;                 // ?��별자
    int onBoardPieceNumber;       // 보드 ?��?�� ?��?�� �? 개수
    int notOnBoardPieceNumber;    // 보드?�� ?���? ?��?? �? 개수
    int goalInNumber;             // 골인?�� �? 개수
    boolean turn;                 // ?��?�� ?�� ?���?
    Color color;                  // ?��?��?��?���? ?��???��?�� ?��
    boolean finish;               // 게임 종료 ?���?
    int finishOrder;              // 게임 종료 ?��?��
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

    void addPieceOnBoard(){       // 보드 ?��?�� 말을 ?��?�� ?���?
        onBoardPieceNumber++;
        notOnBoardPieceNumber--;
    }

    void deletePieceOnBoard(){    // 보드 ?��?��?�� 말을 ?��?���?
        onBoardPieceNumber--;
        notOnBoardPieceNumber++;
    }

    void addGoalInNumber(){       // 골인?���?
        goalInNumber++;
        onBoardPieceNumber--;
    }

    Color getColor(){             // ?��?��?��?�� ?�� getter
        return color;
    }

    @Override
    public int compareTo(Player p) {    // ?��?��?�� ?��?��?��?�� 객체 ?��?�� 방법
        if(this.goalInNumber < p.goalInNumber) {
            return 1;                               // 골인?�� ?��?�� ???��?��?�� ?��림차?��
        }
        else if(this.goalInNumber == p.goalInNumber) {
            if(this.finishOrder > p.finishOrder) {  // y?�� ???��?��?�� ?��름차?��
                return 1;
            }
        }
        return -1;
    }
}