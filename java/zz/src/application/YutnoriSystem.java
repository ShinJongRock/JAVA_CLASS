package application;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Collections;

public class YutnoriSystem {    // ?·???΄ λͺ¨λΈ? λͺ¨λ  ? λ³΄κ? ?? μ΅μ? λͺ¨λΈ

    int pieceNum;
    int playerNum;
    ArrayList<Player> playingPlayer;
    Yut[] yuts = new Yut[4];
    Board board;

    YutnoriSystem(){
        playingPlayer = new ArrayList<>();
        board = new Board(playingPlayer);
        for(int i = 0; i < 4; i++){
            yuts[i] = new Yut();        // yut μ΄κΈ°?
        }
    }

    // ?? ?΄?΄?€? ? ? ??Όλ‘? ? ? ¬. λ§μ?λ§μ ?? κ³μ°? ? ?¬?©
    void calcRank(){
        Collections.sort(playingPlayer);
    }

    // λΉ½λ, ?, κ°?, κ²?, ?·, λͺ¨μ κ²°κ³Όλ₯? λ°ν
    int rollYuts() {

        int yutResult = 0;	                                // 1?΄λ©? ?(λ§μ½ ? ?΄ ?? ?·?΄λ©? λΉ½λ), 2λ©? κ°?, 3λ©? κ±?..
        for(int i = 0; i < 4; i++){
            yutResult += yuts[i].rollYut();                 // ?·? κ°κ° ?? Έ ?· κ²°κ³Όλ₯? ?»?
        }
        if(yuts[0].status == 1 && yutResult == 1) return 5; // yut[0]?? λΉ½λλ₯? ????΄? ?·
        return yutResult;
    }

    // κ²μ? ??? ? λ³??κ°λ€?? μ΄κΈ°?
    void startGame(int playerNum, int pieceNum) {
        this.playerNum = playerNum;
        this.pieceNum = pieceNum;

        for(int i = 0; i < playerNum; i++) {
            playingPlayer.add(new Player(pieceNum, i));     // ?? ?΄?΄ ?λ§νΌ arraylist κ³΅κ° ? ?Ή
        }

        board.addPiece(1, new Piece(0));
        playingPlayer.get(0).addPieceOnBoard();
    }

    // ? ?? λ§κ³Ό ?· λͺ©λ‘? ?΅?΄ ??μ§?? κ³? ??μ§μΌ κ±°λ¦¬ κ³μ°
    int switchYut(String yut){
        int distance = 0;
        switch(yut){
            case "λΉ½λ":
                distance =  -1;
                break;
            case "?":
                distance = 1;
                break;
            case "κ°?":
                distance = 2;
                break;
            case "κ±?":
                distance = 3;
                break;
            case "?·":
                distance = 4;
                break;
            case "λͺ?":
                distance = 5;
                break;
        }
        return distance;
    }

    // ?€? ?? ?΄?΄? ?΄? κ³μ°?? λ©μ?
    int nextTurn() {

        int i = currentTurn();
        int count = 1;
        while(count < playerNum){
            if(playingPlayer.get(i % playerNum).turn == true && playingPlayer.get((i+count) % playerNum).finish == false){
                playingPlayer.get((i+count) % playerNum).turn = true;
                playingPlayer.get(i % playerNum).turn = false;
                return (i+count)% playerNum;
            }
            count++;
        }
        return i;
    }

    // ??¬ ?΄?€ ?? ?΄?΄? ?΄?Έμ§? λ¦¬ν΄
    int currentTurn(){
        for(int i = 0; i < playingPlayer.size(); i++) {
            if(playingPlayer.get(i).turn == true)
                return i;
        }
        return 0;
    }

    // ??¬ ?΄?Έ ?? ?΄?΄? ?? λ¦¬ν΄
    Color currentColor(int turn){
        return playingPlayer.get(turn).getColor();
    }
}
