package application;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Collections;

public class YutnoriSystem {    // ?��???�� 모델?�� 모든 ?��보�? ?��?�� 최상?�� 모델

    int pieceNum;
    int playerNum;
    ArrayList<Player> playingPlayer;
    Yut[] yuts = new Yut[4];
    Board board;

    YutnoriSystem(){
        playingPlayer = new ArrayList<>();
        board = new Board(playingPlayer);
        for(int i = 0; i < 4; i++){
            yuts[i] = new Yut();        // yut 초기?��
        }
    }

    // ?��?��?��?��?��?�� ?��?�� ?��?���? ?��?��. 마�?막에 ?��?�� 계산?��?�� ?��?��
    void calcRank(){
        Collections.sort(playingPlayer);
    }

    // 빽도, ?��, �?, �?, ?��, 모의 결과�? 반환
    int rollYuts() {

        int yutResult = 0;	                                // 1?���? ?��(만약 ?��?�� ?��?�� ?��?���? 빽도), 2�? �?, 3�? �?..
        for(int i = 0; i < 4; i++){
            yutResult += yuts[i].rollYut();                 // ?��?�� 각각 ?��?�� ?�� 결과�? ?��?��
        }
        if(yuts[0].status == 1 && yutResult == 1) return 5; // yut[0]?? 빽도�? ?��???��?�� ?��
        return yutResult;
    }

    // 게임?�� ?��?��?��?�� �??��값들?? 초기?��
    void startGame(int playerNum, int pieceNum) {
        this.playerNum = playerNum;
        this.pieceNum = pieceNum;

        for(int i = 0; i < playerNum; i++) {
            playingPlayer.add(new Player(pieceNum, i));     // ?��?��?��?�� ?��만큼 arraylist 공간 ?��?��
        }

        board.addPiece(1, new Piece(0));
        playingPlayer.get(0).addPieceOnBoard();
    }

    // ?��?��?�� 말과 ?�� 목록?�� ?��?�� ?��?���??���? ??직일 거리 계산
    int switchYut(String yut){
        int distance = 0;
        switch(yut){
            case "빽도":
                distance =  -1;
                break;
            case "?��":
                distance = 1;
                break;
            case "�?":
                distance = 2;
                break;
            case "�?":
                distance = 3;
                break;
            case "?��":
                distance = 4;
                break;
            case "�?":
                distance = 5;
                break;
        }
        return distance;
    }

    // ?��?�� ?��?��?��?��?�� ?��?�� 계산?��?�� 메소?��
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

    // ?��?�� ?��?�� ?��?��?��?��?�� ?��?���? 리턴
    int currentTurn(){
        for(int i = 0; i < playingPlayer.size(); i++) {
            if(playingPlayer.get(i).turn == true)
                return i;
        }
        return 0;
    }

    // ?��?�� ?��?�� ?��?��?��?��?�� ?��?�� 리턴
    Color currentColor(int turn){
        return playingPlayer.get(turn).getColor();
    }
}