package application;

import java.util.ArrayList;

public class Board {    // λ³΄λ?? ????΄? ?΄??€

    Square[] squares;             // κ°κ°? μΉ?(λΈλ‘)?€? λ°°μ΄
    ArrayList<Player> players;    // ?? ?΄?΄?€? λ¦¬μ€?Έ
    int finishCount;              // ?? ?΄?΄?€?΄ κ²μ?¬ μ’λ£? ??
    int defeatCount;              // ?? ?΄?΄?€?΄ κ²μ? ?¨λ°°ν ??(κ³¨μΈ? λͺ»νκ³? λ§λ§ λ¨Ήν κ΅μ°© ??)

    Board(ArrayList<Player> players){
        finishCount = 0;
        defeatCount = 100;
        this.players = players;
        squares = new Square[30];
        for(int i = 1; i <= 29; i++){
            squares[i] = new Square();
        }
    }

    // λ³΄λ? ?Ή?  λΈλ‘??€ λ§μ ?? ?¨?
    void addPiece(int currentSquare, Piece piece){
        squares[currentSquare].pieces.add(piece);
    }

    // λ³΄λ? ?Ή?  λ³Όλ‘? λͺ¨λ  λ§λ€? ?­? ?? ?¨?
    void deletePieces(int currentSquare){
        squares[currentSquare].pieces.clear();
    }

    // λ§μ ?΄??? ?¨?
    int movePiece(int currentSquare, int moveDistance, int turn) {

        boolean goalIn = false;
        boolean almostGoal = false;
        boolean eatAndRollAgain = false;
        int nextSquare = -1;

        // λΉ½λ ??? ?€? λΈλ‘ κ³μ°
        if(moveDistance != -1){
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){ // ? ? ?Ό?Έ?? μ§ν ? ?
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 21) { // ?? ?? ?± λ©μ·??
                    nextSquare = 1;
                    almostGoal = true;
                }
                else if(nextSquare > 21) { // κ³¨μΈ
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
                else if(currentSquare == 1 && squares[currentSquare].pieces.get(0).almostGoal) { // ??? ? ???° ?λ°ν?? ?΄λ―? ???? κ³¨μΈ. λ°±λ?Όκ²½μ°? ??¨.
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(currentSquare == 6){   // ?€λ₯Έμͺ½ ?? μΉΈμ? ??? ?
                nextSquare = 21;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
            }
            else if(currentSquare == 11){  // ?Όμͺ? ?? μΉΈμ? ??? ?
                nextSquare = 26;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                if(nextSquare == 28){ // λ§μ½ λͺ©ν μΉΈμ΄ ? μ€μ?΄λ©? ? μ€μ ?Έ?±?€λ‘? λ³??
                    nextSquare = 23;
                }
                else if(29 <= nextSquare && nextSquare <= 30) { // λ§μ½ λͺ©ν μΉΈμ΄ ?? λΆ?λΆμΌ κ²½μ°. κ³¨μΈ ??
                    nextSquare--;
                }
            }
            else if(currentSquare == 23){  // ? μ€μ μΉΈμ? ??? ?
                nextSquare = 28;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                if(nextSquare == 30) {     // ?? ?? λ©μ·??
                    nextSquare = 1;
                    almostGoal = true;
                }
                else if(nextSquare > 30) { // κ³¨μΈ
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(21 <= currentSquare && currentSquare <= 25 && currentSquare != 23){ // ?€λ₯Έμͺ½ ??? ?Όμͺ? ??λ‘? ?΄? €κ°?? ??κ°μ ?? ???. ? μ€μ?? ??
                nextSquare = currentSquare + moveDistance;
                if(nextSquare > 25){ // λ§μ½ κ·? ??κ°μ ? ?μΆνλ©? ?Όμͺ? ?? μΉΈμΌλ‘? λ³??? ? ?΄? μ§ν
                    moveDistance = nextSquare - 25;
                    moveDistance--;
                    nextSquare = 16;
                    nextSquare = nextSquare + moveDistance;
                }
            }
            else if(26 <= currentSquare && currentSquare <= 27){ // ?Όμͺ? ??? ?€λ₯Έμͺ½ ??λ‘? ?΄? €κ°?? ??κ°μ ?μ€? ? λΆ?λΆμ ???. ? μ€μ?? ??
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 27){ // ?κ°μ΄ ?λΆ?λΆμ ?¨??? κ²½μ°
                }
                else if(nextSquare == 28){ // λ§μ½ λͺ©ν μΉΈμ΄ ? μ€μ?΄λ©? ? μ€μ ?Έ?±?€λ‘? λ³??
                    nextSquare = 23;
                }
                else if(29 <= nextSquare && nextSquare <= 30) { // λ§μ½ λͺ©ν μΉΈμ΄ ?? λΆ?λΆμΌ κ²½μ°. κ³¨μΈ ??
                    nextSquare--;
                }
                else if(nextSquare == 31){ // ?? μΉΈμ? ?± λ©μΆ κ²½μ°
                    nextSquare = 1;
                    almostGoal = true;
                }
                else{ // κ³¨μΈ
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(28 <= currentSquare && currentSquare <= 29){ // ?Όμͺ? ??? ?€λ₯Έμͺ½ ??λ‘? ?΄? €κ°?? ??κ°μ ?μ€? ?? λΆ?λΆμ ???. ? μ€μ?? ??
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 29) { // ?κ°μ΄ ?? λΆ?λΆμ ?¨??? κ²½μ°

                }
                else if(nextSquare == 30){ // ?? μΉΈμ? ?± λ©μΆ κ²½μ°
                    nextSquare = 1;
                    almostGoal = true;
                }
                else{ // κ³¨μΈ
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
        }

        // λΉ½λ ?Ό? ?€? λΈλ‘ κ³μ°
        else {                  // λΉ½λ ?Ό?
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){ // ? ? ?Ό?Έ?? μ§ν ? ?
                if(currentSquare == 1){                                             // μ²«λ²μ§? μΉΈμ ???°
                    if(squares[currentSquare].pieces.get(0).almostGoal == true){    // ?λ°ν?? ?΄λ―? ????
                        nextSquare = 20;
                    }
                    else{                                                           // ??  μ²μ ?????
                        nextSquare = currentSquare;
                    }
                }
                else{                                                               // μ²«λ²μ§? μΉΈμ΄ ?? ?λ¨Έμ? μΉΈλ€
                    nextSquare = currentSquare + moveDistance;
                }
            }
            else if(currentSquare == 23) {  // ? μ€μ μΉΈμ? ??? ?
                nextSquare = 27;
            }
            else if(currentSquare == 21) {  // ?€λ₯Έμͺ½ ? λΆ?λΆ? ??? ??? ?€λ₯Έμͺ½ ?μͺ? μΉΈμΌλ‘? λ°?
                nextSquare = 6;
            }
            else if(currentSquare == 26) {  // ?Όμͺ? ? λΆ?λΆ? ??? ??? ?Όμͺ? ?μͺ? μΉΈμΌλ‘? λ°?
                nextSquare = 11;
            }
            else if(currentSquare == 24){   // ? μ€μ λ°λ‘ ? ?Όμͺ½μ ??? ? μ€μ?Όλ‘? λ°?
                nextSquare = 23;
            }
            else if(currentSquare == 28){   // ? μ€μ λ°λ‘ ? ?€λ₯Έμͺ½? ??? ? μ€μ?Όλ‘? λ°?
                nextSquare = 23;
            }
            else{                           // ?λ¨Έμ? μΉΈλ€
                nextSquare = currentSquare + moveDistance;
            }
        }

        if(currentSquare == nextSquare)     // λ°©κΈ ??? ?? ??±? λ§μ΄ λ°±λκ°? ??€λ©? ?λ¬΄κ²? ??κ³? λ¦¬ν΄
            return currentSquare;

        eatAndRollAgain = eatOrMerge(currentSquare, nextSquare, goalIn, almostGoal, turn);    // λ§μ΄ λ¨Ήν κ²½μ° λ¨Ήν λ§λ€? ? κ±?
        deletePieces(currentSquare);
        if(eatAndRollAgain)
            players.get(turn).eatAndRollAgain = true;

        checkFinishedPlayers();                 // κ²μ μ’λ£? ?? ?΄?΄λ₯? ??Έ
        boolean finished = checkAllFinished();  // λͺ¨λ  ?? ?΄?΄?€?΄ κ²μ μ’λ£?μ§? ??Έ

        if(finished == true){   // λͺ¨λ  ?? ?΄?΄κ°? ??¬??
            return -2;
        }

        if(goalIn == true) {    // κ³¨μΈ???
            return -1;
        }

        return nextSquare;      // κ·Έλ₯ λ§μ΄ ??μ§μΈ κ²½μ°
    }

    // ?? ?΄?΄? λ§μ΄ λ³΄λ?? ??? ?κ³? ?¨?? λ§μ΄ μ‘΄μ¬?  κ²½μ°. ?΄? ?λ‘μ΄ λ§μ΄ ??±? ?? ?΄?ΌκΈ?...
    boolean initializePiece(int turn){
        if(players.get(turn).notOnBoardPieceNumber > 0 && players.get(turn).onBoardPieceNumber == 0 ){
            eatOrMerge(1, 1, false, false, turn);
            addPiece(1, new Piece(turn));
            players.get(turn).addPieceOnBoard();
            return true;
        }
        return false;
    }

    // ?‘? λ§μ λ¨Ήκ±°? ?κ΅? λ§μ ?? ?¨?
    boolean eatOrMerge(int currentSquare, int nextSquare, boolean goalIn, boolean almostGoal, int turn) {
        boolean eatAndRollAgain = false;
        if(nextSquare == -1)                                          // κ³¨μΈ?Ό?? ?λ¬΄κ²? ??¨
            return false;
        if(squares[nextSquare].pieces.size() > 0 && goalIn == false){ // λͺ©ν? λ§λ€?΄ μ‘΄μ¬?κ³? κ³¨μΈ?΄ ???
            int deletedPlayer = squares[nextSquare].pieces.get(0).player;
            if(deletedPlayer != turn){                                // ?€λ₯? ?? ?΄?΄? λ§μΌ κ²½μ°?λ§? ?­? 
                for(int i = 0; i < squares[nextSquare].pieces.size(); i++){    // ?­? ? ?λ§νΌ λ§? ? κ°μ
                    players.get(deletedPlayer).deletePieceOnBoard();
                }
                deletePieces(nextSquare);
                eatAndRollAgain = true;
            }
        }
        if (currentSquare != nextSquare && goalIn == false){                   // ?λ‘μ΄ λ§μ΄ ???? κ²½μ°κ°? ???
            for(int i = 0; i < squares[currentSquare].pieces.size(); i++){     // ?? ?? κ³³μ λ§λ€? λͺ©ν? μΆκ?
                if(almostGoal == true)
                    addPiece(nextSquare, new Piece(turn, almostGoal));
                else{
                    addPiece(nextSquare, new Piece(turn));
                }
            }
        }
        return eatAndRollAgain;
    }

    // κ²μ μ’λ£? ?? ?΄?΄λ₯? ??Έ?? ?¨?
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

    // λͺ¨λ  ?? ?΄?΄?€?΄ κ²μ μ’λ£?μ§? ??Έ?? ?¨?
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