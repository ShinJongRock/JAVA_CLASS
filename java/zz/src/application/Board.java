package application;

import java.util.ArrayList;

public class Board {    // 보드?��?�� ?��???��?�� ?��?��?��

    Square[] squares;             // 각각?�� �?(블록)?��?�� 배열
    ArrayList<Player> players;    // ?��?��?��?��?��?�� 리스?��
    int finishCount;              // ?��?��?��?��?��?�� 게임?�� 종료?�� ?��?��
    int defeatCount;              // ?��?��?��?��?��?�� 게임?�� ?��배한 ?��?��(골인?�� 못하�? 말만 먹힌 교착 ?��?��)

    Board(ArrayList<Player> players){
        finishCount = 0;
        defeatCount = 100;
        this.players = players;
        squares = new Square[30];
        for(int i = 1; i <= 29; i++){
            squares[i] = new Square();
        }
    }

    // 보드?�� ?��?�� 블록?��?�� 말을 ?��?�� ?��?��
    void addPiece(int currentSquare, Piece piece){
        squares[currentSquare].pieces.add(piece);
    }

    // 보드?�� ?��?�� 볼록?�� 모든 말들?�� ?��?��?��?�� ?��?��
    void deletePieces(int currentSquare){
        squares[currentSquare].pieces.clear();
    }

    // 말을 ?��?��?��?�� ?��?��
    int movePiece(int currentSquare, int moveDistance, int turn) {

        boolean goalIn = false;
        boolean almostGoal = false;
        boolean eatAndRollAgain = false;
        int nextSquare = -1;

        // 빽도 ?��?��?�� ?��?�� 블록 계산
        if(moveDistance != -1){
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){ // ?��?�� ?��?��?��?�� 진행 ?��?��
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 21) { // ?��?��?��?�� ?�� 멈췄?��?��
                    nextSquare = 1;
                    almostGoal = true;
                }
                else if(nextSquare > 21) { // 골인
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
                else if(currentSquare == 1 && squares[currentSquare].pieces.get(0).almostGoal) { // ?��?��?��?�� ?��?��?�� ?��바�?? ?���? ?��?��?��?�� 골인. 백도?��경우?�� ?��?��.
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(currentSquare == 6){   // ?��른쪽 ?��?�� 칸에?�� ?��?��?��?��
                nextSquare = 21;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
            }
            else if(currentSquare == 11){  // ?���? ?��?�� 칸에?�� ?��?��?��?��
                nextSquare = 26;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                if(nextSquare == 28){ // 만약 목표 칸이 ?��중앙?���? ?��중앙 ?��?��?���? �??��
                    nextSquare = 23;
                }
                else if(29 <= nextSquare && nextSquare <= 30) { // 만약 목표 칸이 ?��?�� �?분일 경우. 골인 ?��?��
                    nextSquare--;
                }
            }
            else if(currentSquare == 23){  // ?��중앙 칸에?�� ?��?��?��?��
                nextSquare = 28;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                if(nextSquare == 30) {     // ?��?��?��?�� 멈췄?��?��
                    nextSquare = 1;
                    almostGoal = true;
                }
                else if(nextSquare > 30) { // 골인
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(21 <= currentSquare && currentSquare <= 25 && currentSquare != 23){ // ?��른쪽 ?��?��?�� ?���? ?��?���? ?��?���??�� ??각선?��?�� ?��?��?��. ?��중앙?? ?��?��
                nextSquare = currentSquare + moveDistance;
                if(nextSquare > 25){ // 만약 �? ??각선?�� ?��출하�? ?���? ?��?�� 칸으�? �??��?�� ?�� ?��?�� 진행
                    moveDistance = nextSquare - 25;
                    moveDistance--;
                    nextSquare = 16;
                    nextSquare = nextSquare + moveDistance;
                }
            }
            else if(26 <= currentSquare && currentSquare <= 27){ // ?���? ?��?��?�� ?��른쪽 ?��?���? ?��?���??�� ??각선?���? ?�� �?분에 ?��?��?��. ?��중앙?? ?��?��
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 27){ // ?��같이 ?���?분에 ?��?��?��?�� 경우
                }
                else if(nextSquare == 28){ // 만약 목표 칸이 ?��중앙?���? ?��중앙 ?��?��?���? �??��
                    nextSquare = 23;
                }
                else if(29 <= nextSquare && nextSquare <= 30) { // 만약 목표 칸이 ?��?�� �?분일 경우. 골인 ?��?��
                    nextSquare--;
                }
                else if(nextSquare == 31){ // ?��?�� 칸에?�� ?�� 멈출 경우
                    nextSquare = 1;
                    almostGoal = true;
                }
                else{ // 골인
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(28 <= currentSquare && currentSquare <= 29){ // ?���? ?��?��?�� ?��른쪽 ?��?���? ?��?���??�� ??각선?���? ?��?�� �?분에 ?��?��?��. ?��중앙?? ?��?��
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 29) { // ?��같이 ?��?�� �?분에 ?��?��?��?�� 경우

                }
                else if(nextSquare == 30){ // ?��?�� 칸에?�� ?�� 멈출 경우
                    nextSquare = 1;
                    almostGoal = true;
                }
                else{ // 골인
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
        }

        // 빽도 ?��?�� ?��?�� 블록 계산
        else {                  // 빽도 ?��?��
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){ // ?��?�� ?��?��?��?�� 진행 ?��?��
                if(currentSquare == 1){                                             // 첫번�? 칸에 ?��?��?��
                    if(squares[currentSquare].pieces.get(0).almostGoal == true){    // ?��바�?? ?���? ?��?��?��?��
                        nextSquare = 20;
                    }
                    else{                                                           // ?��?�� 처음 ?��?��?��?��?��
                        nextSquare = currentSquare;
                    }
                }
                else{                                                               // 첫번�? 칸이 ?��?�� ?��머�? 칸들
                    nextSquare = currentSquare + moveDistance;
                }
            }
            else if(currentSquare == 23) {  // ?��중앙 칸에?�� ?��?��?��?��
                nextSquare = 27;
            }
            else if(currentSquare == 21) {  // ?��른쪽 ?�� �?�? ?��?��?�� ?��?��?�� ?��른쪽 ?���? 칸으�? �?
                nextSquare = 6;
            }
            else if(currentSquare == 26) {  // ?���? ?�� �?�? ?��?��?�� ?��?��?�� ?���? ?���? 칸으�? �?
                nextSquare = 11;
            }
            else if(currentSquare == 24){   // ?��중앙 바로 ?�� ?��쪽에 ?��?��?�� ?��중앙?���? �?
                nextSquare = 23;
            }
            else if(currentSquare == 28){   // ?��중앙 바로 ?�� ?��른쪽?�� ?��?��?�� ?��중앙?���? �?
                nextSquare = 23;
            }
            else{                           // ?��머�? 칸들
                nextSquare = currentSquare + moveDistance;
            }
        }

        if(currentSquare == nextSquare)     // 방금 ?��?��?��?��?�� ?��?��?�� 말이 백도�? ?��?���? ?��무것?�� ?��?���? 리턴
            return currentSquare;

        eatAndRollAgain = eatOrMerge(currentSquare, nextSquare, goalIn, almostGoal, turn);    // 말이 먹힌 경우 먹힌 말들?�� ?���?
        deletePieces(currentSquare);
        if(eatAndRollAgain)
            players.get(turn).eatAndRollAgain = true;

        checkFinishedPlayers();                 // 게임 종료?�� ?��?��?��?���? ?��?��
        boolean finished = checkAllFinished();  // 모든 ?��?��?��?��?��?�� 게임 종료?���? ?��?��

        if(finished == true){   // 모든 ?��?��?��?���? ?��?��?��?��
            return -2;
        }

        if(goalIn == true) {    // 골인?��?��?��
            return -1;
        }

        return nextSquare;      // 그냥 말이 ??직인 경우
    }

    // ?��?��?��?��?�� 말이 보드?��?�� ?��?��?�� ?���? ?��?? 말이 존재?�� 경우. ?��?�� ?��로운 말이 ?��?��?��?��?�� ?��?���?...
    boolean initializePiece(int turn){
        if(players.get(turn).notOnBoardPieceNumber > 0 && players.get(turn).onBoardPieceNumber == 0 ){
            eatOrMerge(1, 1, false, false, turn);
            addPiece(1, new Piece(turn));
            players.get(turn).addPieceOnBoard();
            return true;
        }
        return false;
    }

    // ?��?�� 말을 먹거?�� ?���? 말을 ?��?�� ?��?��
    boolean eatOrMerge(int currentSquare, int nextSquare, boolean goalIn, boolean almostGoal, int turn) {
        boolean eatAndRollAgain = false;
        if(nextSquare == -1)                                          // 골인?��?��?�� ?��무것?�� ?��?��
            return false;
        if(squares[nextSquare].pieces.size() > 0 && goalIn == false){ // 목표?�� 말들?�� 존재?���? 골인?�� ?��?��?��
            int deletedPlayer = squares[nextSquare].pieces.get(0).player;
            if(deletedPlayer != turn){                                // ?���? ?��?��?��?��?�� 말일 경우?���? ?��?��
                for(int i = 0; i < squares[nextSquare].pieces.size(); i++){    // ?��?��?�� ?��만큼 �? ?�� 감소
                    players.get(deletedPlayer).deletePieceOnBoard();
                }
                deletePieces(nextSquare);
                eatAndRollAgain = true;
            }
        }
        if (currentSquare != nextSquare && goalIn == false){                   // ?��로운 말이 ?��?��?��?�� 경우�? ?��?��?��
            for(int i = 0; i < squares[currentSquare].pieces.size(); i++){     // ?��?�� ?��?�� 곳의 말들?�� 목표?�� 추�?
                if(almostGoal == true)
                    addPiece(nextSquare, new Piece(turn, almostGoal));
                else{
                    addPiece(nextSquare, new Piece(turn));
                }
            }
        }
        return eatAndRollAgain;
    }

    // 게임 종료?�� ?��?��?��?���? ?��?��?��?�� ?��?��
    void checkFinishedPlayers(){
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).finish == false){
                if(players.get(i).onBoardPieceNumber == 0 && players.get(i).notOnBoardPieceNumber == 0 && players.get(i).goalInNumber == 0){
                    players.get(i).finish = true;
                    players.get(i).finishOrder = defeatCount;
                    defeatCount++;
                }
                else if(players.get(i).onBoardPieceNumber == 0 && players.get(i).notOnBoardPieceNumber == 0 && players.get(i).goalInNumber != 0){
                    players.get(i).finish = true;
                    players.get(i).finishOrder = finishCount;
                    finishCount++;
                }
            }
        }
    }

    // 모든 ?��?��?��?��?��?�� 게임 종료?���? ?��?��?��?�� ?��?��
    boolean checkAllFinished(){
        boolean check = true;
        for(int i = 0; i < players.size(); i++){
            check = players.get(i).finish;
            if(check == false)
                return false;
        }
        return check;
    }
}