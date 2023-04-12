package application;

import java.util.ArrayList;

public class Board {    // ë³´ë“œ?Œ?„ ?‚˜???‚´?Š” ?´?˜?Š¤

    Square[] squares;             // ê°ê°?˜ ì¹?(ë¸”ë¡)?“¤?˜ ë°°ì—´
    ArrayList<Player> players;    // ?”Œ? ˆ?´?–´?“¤?˜ ë¦¬ìŠ¤?Š¸
    int finishCount;              // ?”Œ? ˆ?´?–´?“¤?´ ê²Œì„?˜¬ ì¢…ë£Œ?•œ ?ˆœ?„œ
    int defeatCount;              // ?”Œ? ˆ?´?–´?“¤?´ ê²Œì„?— ?Œ¨ë°°í•œ ?ˆœ?„œ(ê³¨ì¸?„ ëª»í•˜ê³? ë§ë§Œ ë¨¹íŒ êµì°© ?ƒ?ƒœ)

    Board(ArrayList<Player> players){
        finishCount = 0;
        defeatCount = 100;
        this.players = players;
        squares = new Square[30];
        for(int i = 1; i <= 29; i++){
            squares[i] = new Square();
        }
    }

    // ë³´ë“œ?˜ ?Š¹? • ë¸”ë¡?—?‹¤ ë§ì„ ?†“?Š” ?•¨?ˆ˜
    void addPiece(int currentSquare, Piece piece){
        squares[currentSquare].pieces.add(piece);
    }

    // ë³´ë“œ?˜ ?Š¹? • ë³¼ë¡?˜ ëª¨ë“  ë§ë“¤?„ ?‚­? œ?•˜?Š” ?•¨?ˆ˜
    void deletePieces(int currentSquare){
        squares[currentSquare].pieces.clear();
    }

    // ë§ì„ ?´?™?•˜?Š” ?•¨?ˆ˜
    int movePiece(int currentSquare, int moveDistance, int turn) {

        boolean goalIn = false;
        boolean almostGoal = false;
        boolean eatAndRollAgain = false;
        int nextSquare = -1;

        // ë¹½ë„ ?•„?‹?•Œ ?‹¤?Œ ë¸”ë¡ ê³„ì‚°
        if(moveDistance != -1){
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){ // ? •?ƒ ?¼?¸?—?„œ ì§„í–‰ ? ?•Œ
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 21) { // ?›? ?—?„œ ?”± ë©ˆì·„?„?•Œ
                    nextSquare = 1;
                    almostGoal = true;
                }
                else if(nextSquare > 21) { // ê³¨ì¸
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
                else if(currentSquare == 1 && squares[currentSquare].pieces.get(0).almostGoal) { // ?‹œ?‘? ?— ?ˆ?Š”?° ?•œë°”í?? ?´ë¯? ?Œ?•˜?„?•Œ ê³¨ì¸. ë°±ë„?¼ê²½ìš°?Š” ?•ˆ?¨.
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(currentSquare == 6){   // ?˜¤ë¥¸ìª½ ?œ„?— ì¹¸ì—?„œ ?‹œ?‘?• ?•Œ
                nextSquare = 21;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
            }
            else if(currentSquare == 11){  // ?™¼ìª? ?œ„?— ì¹¸ì—?„œ ?‹œ?‘?• ?•Œ
                nextSquare = 26;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                if(nextSquare == 28){ // ë§Œì•½ ëª©í‘œ ì¹¸ì´ ? •ì¤‘ì•™?´ë©? ? •ì¤‘ì•™ ?¸?±?Š¤ë¡? ë³??™˜
                    nextSquare = 23;
                }
                else if(29 <= nextSquare && nextSquare <= 30) { // ë§Œì•½ ëª©í‘œ ì¹¸ì´ ?•„?˜ ë¶?ë¶„ì¼ ê²½ìš°. ê³¨ì¸ ?•„?‹˜
                    nextSquare--;
                }
            }
            else if(currentSquare == 23){  // ? •ì¤‘ì•™ ì¹¸ì—?„œ ?‹œ?‘?• ?•Œ
                nextSquare = 28;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                if(nextSquare == 30) {     // ?›? ?—?„œ ë©ˆì·„?„?•Œ
                    nextSquare = 1;
                    almostGoal = true;
                }
                else if(nextSquare > 30) { // ê³¨ì¸
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(21 <= currentSquare && currentSquare <= 25 && currentSquare != 23){ // ?˜¤ë¥¸ìª½ ?œ„?—?„œ ?™¼ìª? ?•„?˜ë¡? ?‚´? ¤ê°??Š” ??ê°ì„ ?ƒ?— ?ˆ?„?•Œ. ? •ì¤‘ì•™?? ?•„?‹˜
                nextSquare = currentSquare + moveDistance;
                if(nextSquare > 25){ // ë§Œì•½ ê·? ??ê°ì„ ?„ ?ƒˆì¶œí•˜ë©? ?™¼ìª? ?•„?˜ ì¹¸ìœ¼ë¡? ë³??˜•?•œ ?›„ ?´?™ ì§„í–‰
                    moveDistance = nextSquare - 25;
                    moveDistance--;
                    nextSquare = 16;
                    nextSquare = nextSquare + moveDistance;
                }
            }
            else if(26 <= currentSquare && currentSquare <= 27){ // ?™¼ìª? ?œ„?—?„œ ?˜¤ë¥¸ìª½ ?•„?˜ë¡? ?‚´? ¤ê°??Š” ??ê°ì„ ?ƒì¤? ?œ— ë¶?ë¶„ì— ?ˆ?„?•Œ. ? •ì¤‘ì•™?? ?•„?‹˜
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 27){ // ?˜‘ê°™ì´ ?œ—ë¶?ë¶„ì— ?‚¨?•„?ˆ?„ ê²½ìš°
                }
                else if(nextSquare == 28){ // ë§Œì•½ ëª©í‘œ ì¹¸ì´ ? •ì¤‘ì•™?´ë©? ? •ì¤‘ì•™ ?¸?±?Š¤ë¡? ë³??™˜
                    nextSquare = 23;
                }
                else if(29 <= nextSquare && nextSquare <= 30) { // ë§Œì•½ ëª©í‘œ ì¹¸ì´ ?•„?˜ ë¶?ë¶„ì¼ ê²½ìš°. ê³¨ì¸ ?•„?‹˜
                    nextSquare--;
                }
                else if(nextSquare == 31){ // ?‹œ?‘ ì¹¸ì—?„œ ?”± ë©ˆì¶œ ê²½ìš°
                    nextSquare = 1;
                    almostGoal = true;
                }
                else{ // ê³¨ì¸
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
            else if(28 <= currentSquare && currentSquare <= 29){ // ?™¼ìª? ?œ„?—?„œ ?˜¤ë¥¸ìª½ ?•„?˜ë¡? ?‚´? ¤ê°??Š” ??ê°ì„ ?ƒì¤? ?•„?˜ ë¶?ë¶„ì— ?ˆ?„?•Œ. ? •ì¤‘ì•™?? ?•„?‹˜
                nextSquare = currentSquare + moveDistance;
                if(nextSquare == 29) { // ?˜‘ê°™ì´ ?•„?˜ ë¶?ë¶„ì— ?‚¨?•„?ˆ?„ ê²½ìš°

                }
                else if(nextSquare == 30){ // ?‹œ?‘ ì¹¸ì—?„œ ?”± ë©ˆì¶œ ê²½ìš°
                    nextSquare = 1;
                    almostGoal = true;
                }
                else{ // ê³¨ì¸
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
        }

        // ë¹½ë„ ?¼?•Œ ?‹¤?Œ ë¸”ë¡ ê³„ì‚°
        else {                  // ë¹½ë„ ?¼?•Œ
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){ // ? •?ƒ ?¼?¸?—?„œ ì§„í–‰ ? ?•Œ
                if(currentSquare == 1){                                             // ì²«ë²ˆì§? ì¹¸ì— ?ˆ?Š”?°
                    if(squares[currentSquare].pieces.get(0).almostGoal == true){    // ?•œë°”í?? ?´ë¯? ?Œ?•˜?„?•Œ
                        nextSquare = 20;
                    }
                    else{                                                           // ?™„? „ ì²˜ìŒ ?‹œ?‘?–ˆ?„?•Œ
                        nextSquare = currentSquare;
                    }
                }
                else{                                                               // ì²«ë²ˆì§? ì¹¸ì´ ?•„?‹Œ ?‚˜ë¨¸ì? ì¹¸ë“¤
                    nextSquare = currentSquare + moveDistance;
                }
            }
            else if(currentSquare == 23) {  // ? •ì¤‘ì•™ ì¹¸ì—?„œ ?‹œ?‘?• ?•Œ
                nextSquare = 27;
            }
            else if(currentSquare == 21) {  // ?˜¤ë¥¸ìª½ ?œ— ë¶?ë¶? ?‹œ?‘?— ?ˆ?„?•Œ ?˜¤ë¥¸ìª½ ?œ„ìª? ì¹¸ìœ¼ë¡? ë°?
                nextSquare = 6;
            }
            else if(currentSquare == 26) {  // ?™¼ìª? ?œ— ë¶?ë¶? ?‹œ?‘?— ?ˆ?„?•Œ ?™¼ìª? ?œ„ìª? ì¹¸ìœ¼ë¡? ë°?
                nextSquare = 11;
            }
            else if(currentSquare == 24){   // ? •ì¤‘ì•™ ë°”ë¡œ ?• ?™¼ìª½ì— ?ˆ?„?•Œ ? •ì¤‘ì•™?œ¼ë¡? ë°?
                nextSquare = 23;
            }
            else if(currentSquare == 28){   // ? •ì¤‘ì•™ ë°”ë¡œ ?• ?˜¤ë¥¸ìª½?— ?ˆ?„?•Œ ? •ì¤‘ì•™?œ¼ë¡? ë°?
                nextSquare = 23;
            }
            else{                           // ?‚˜ë¨¸ì? ì¹¸ë“¤
                nextSquare = currentSquare + moveDistance;
            }
        }

        if(currentSquare == nextSquare)     // ë°©ê¸ˆ ?‹œ?‘? ?—?„œ ?ƒ?„±?œ ë§ì´ ë°±ë„ê°? ?‚˜?˜¤ë©? ?•„ë¬´ê²ƒ?„ ?•ˆ?•˜ê³? ë¦¬í„´
            return currentSquare;

        eatAndRollAgain = eatOrMerge(currentSquare, nextSquare, goalIn, almostGoal, turn);    // ë§ì´ ë¨¹íŒ ê²½ìš° ë¨¹íŒ ë§ë“¤?„ ? œê±?
        deletePieces(currentSquare);
        if(eatAndRollAgain)
            players.get(turn).eatAndRollAgain = true;

        checkFinishedPlayers();                 // ê²Œì„ ì¢…ë£Œ?•œ ?”Œ? ˆ?´?–´ë¥? ?™•?¸
        boolean finished = checkAllFinished();  // ëª¨ë“  ?”Œ? ˆ?´?–´?“¤?´ ê²Œì„ ì¢…ë£Œ?•œì§? ?™•?¸

        if(finished == true){   // ëª¨ë“  ?”Œ? ˆ?´?–´ê°? ??‚¬?„?•Œ
            return -2;
        }

        if(goalIn == true) {    // ê³¨ì¸?–ˆ?„?•Œ
            return -1;
        }

        return nextSquare;      // ê·¸ëƒ¥ ë§ì´ ??ì§ì¸ ê²½ìš°
    }

    // ?”Œ? ˆ?´?–´?˜ ë§ì´ ë³´ë“œ?œ„?— ?•˜?‚˜?„ ?—†ê³? ?‚¨?? ë§ì´ ì¡´ì¬?•  ê²½ìš°. ?´?•Œ ?ƒˆë¡œìš´ ë§ì´ ?ƒ?„±? ?•Œ?˜ ?´?•¼ê¸?...
    boolean initializePiece(int turn){
        if(players.get(turn).notOnBoardPieceNumber > 0 && players.get(turn).onBoardPieceNumber == 0 ){
            eatOrMerge(1, 1, false, false, turn);
            addPiece(1, new Piece(turn));
            players.get(turn).addPieceOnBoard();
            return true;
        }
        return false;
    }

    // ?¡?Œ ë§ì„ ë¨¹ê±°?‚˜ ?•„êµ? ë§ì„ ?—…?Š” ?•¨?ˆ˜
    boolean eatOrMerge(int currentSquare, int nextSquare, boolean goalIn, boolean almostGoal, int turn) {
        boolean eatAndRollAgain = false;
        if(nextSquare == -1)                                          // ê³¨ì¸?¼?•Œ?Š” ?•„ë¬´ê²ƒ?„ ?•ˆ?•¨
            return false;
        if(squares[nextSquare].pieces.size() > 0 && goalIn == false){ // ëª©í‘œ?— ë§ë“¤?´ ì¡´ì¬?•˜ê³? ê³¨ì¸?´ ?•„?‹?•Œ
            int deletedPlayer = squares[nextSquare].pieces.get(0).player;
            if(deletedPlayer != turn){                                // ?‹¤ë¥? ?”Œ? ˆ?´?–´?˜ ë§ì¼ ê²½ìš°?—ë§? ?‚­? œ
                for(int i = 0; i < squares[nextSquare].pieces.size(); i++){    // ?‚­? œ?œ ?ˆ˜ë§Œí¼ ë§? ?ˆ˜ ê°ì†Œ
                    players.get(deletedPlayer).deletePieceOnBoard();
                }
                deletePieces(nextSquare);
                eatAndRollAgain = true;
            }
        }
        if (currentSquare != nextSquare && goalIn == false){                   // ?ƒˆë¡œìš´ ë§ì´ ?‹œ?‘?•˜?Š” ê²½ìš°ê°? ?•„?‹?•Œ
            for(int i = 0; i < squares[currentSquare].pieces.size(); i++){     // ?›?˜ ?ˆ?˜ ê³³ì˜ ë§ë“¤?„ ëª©í‘œ?— ì¶”ê?
                if(almostGoal == true)
                    addPiece(nextSquare, new Piece(turn, almostGoal));
                else{
                    addPiece(nextSquare, new Piece(turn));
                }
            }
        }
        return eatAndRollAgain;
    }

    // ê²Œì„ ì¢…ë£Œ?•œ ?”Œ? ˆ?´?–´ë¥? ?™•?¸?•˜?Š” ?•¨?ˆ˜
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

    // ëª¨ë“  ?”Œ? ˆ?´?–´?“¤?´ ê²Œì„ ì¢…ë£Œ?•œì§? ?™•?¸?•˜?Š” ?•¨?ˆ˜
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