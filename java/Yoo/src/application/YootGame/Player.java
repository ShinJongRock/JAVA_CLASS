package application.YootGame;
import javafx.scene.paint.Color;

// 플레이어를 나타내는 클래스
public class Player implements Comparable<Player> {

    int playerID;               // 식별자
    int onBoardPieceNumber;     // 보드 위에 있는 말 개수     
    int notOnBoardPieceNumber;  // 보드에 있지 않은 말 개수
    int goalInNumber;           // 골인한 말 개수
    boolean turn;               // 현재 턴 여부
    Color color;                // 플레이어를 나타내는 색
    boolean finish;             // 게임 종료 여부
    int finishOrder;            // 게임 종료 순서
    boolean eatAndRollAgain;
    int count;               	// 윷 던진 횟수

    Player(int pieceNumber, int player){
        playerID = player;
        onBoardPieceNumber = 0;
        notOnBoardPieceNumber = pieceNumber;
        goalInNumber = 0;
        turn = false;
        finish = false;
        eatAndRollAgain = false;
        count = 0;
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
    
    // 보드 위에 말을 하나 놓기
    void addPieceOnBoard() {
        onBoardPieceNumber++;
        notOnBoardPieceNumber--;
    }
    
    // 보드 위에서 말을 없애기
    void deletePieceOnBoard() {
        onBoardPieceNumber--;
        notOnBoardPieceNumber++;
    }
    
    // 골인
    void addGoalInNumber() {
        goalInNumber++;
        onBoardPieceNumber--;
    }
    
    // 플레이어 색 getter
    Color getColor() {
        return color;
    }
    
    // 임의의 플레이어 객체 정렬
    @Override
    public int compareTo(Player p) {    
        if(this.goalInNumber < p.goalInNumber) {
        	// 골인한 수에 대해서는 내림차순
            return 1;
        }
        else if(this.goalInNumber == p.goalInNumber) {
            if(this.finishOrder > p.finishOrder) {
            	// 끝나는 순서에 대해서는 오름차순
            	// 수정 필요
                return 1;
            }
        }
        return -1;
    }
}