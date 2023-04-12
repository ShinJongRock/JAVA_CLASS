package application.YootGame;

import java.util.ArrayList;

public class Board {    // �������� ��Ÿ���� Ŭ����

    Square[] squares;             // ������ ĭ(���)���� �迭
    ArrayList<Player> players;    // �÷��̾���� ����Ʈ
    int finishCount;              // �÷��̾���� ���ӿ� ������ ����
    int defeatCount;              // �÷��̾���� ���ӿ� �й��� ����(������ ���ϰ� ���� ���� ���� ����)

    Board(ArrayList<Player> players){
        finishCount = 0;
        defeatCount = 100;
        this.players = players;
        squares = new Square[30];
        for(int i = 1; i <= 29; i++){
            squares[i] = new Square();
        }
    }

    // ������ Ư�� ��Ͽ��� ���� ���� �Լ�
    void addPiece(int currentSquare, Piece piece){
        squares[currentSquare].pieces.add(piece);
    }

    // ������ Ư�� ������ ��� ������ �����ϴ� �Լ�
    void deletePieces(int currentSquare){
        squares[currentSquare].pieces.clear();
    }

    // ���� �̵��ϴ� �Լ�
    int movePiece(int currentSquare, int moveDistance, int turn) {

        boolean goalIn = false;
        boolean almostGoal = false;
        boolean eatAndRollAgain = false;
        int nextSquare = -1;

        // ���� �ƴҶ� ���� ��� ���
        if(moveDistance != -1) {
        	// ���� ���ο��� ���� �ɶ�
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11){
                nextSquare = currentSquare + moveDistance;
                // �������� �� ��������
                if(nextSquare == 21) {
                    nextSquare = 1;
                    almostGoal = true;
                // ����
                } else if(nextSquare > 21) {
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                // �������� �ִµ� �ѹ��� �̹� �������� ����. �鵵�ϰ��� �ȵ�.
                } else if(currentSquare == 1 && squares[currentSquare].pieces.get(0).almostGoal) {
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            // ������ ���� ĭ���� �����Ҷ�
            } else if(currentSquare == 6) {
                nextSquare = 21;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
            // ���� ���� ĭ���� �����Ҷ�
            } else if(currentSquare == 11) {
                nextSquare = 26;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                // ���� ��ǥ ĭ�� ���߾��̸� ���߾� �ε����� ��ȯ
                if(nextSquare == 28){
                    nextSquare = 23;
                // ���� ��ǥ ĭ�� �Ʒ� �κ��� ��� ������ �ƴ�
                } else if(29 <= nextSquare && nextSquare <= 30) {
                    nextSquare--;
                }
            // ���߾� ĭ���� �����Ҷ�
            } else if(currentSquare == 23) {
                nextSquare = 28;
                moveDistance--;
                nextSquare = nextSquare + moveDistance;
                // �������� ��������
                if(nextSquare == 30) {
                    nextSquare = 1;
                    almostGoal = true;
                // ����
                } else if(nextSquare > 30) {
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            // ������ ������ ���� �Ʒ��� �������� �밢���� ������. ���߾��� �ƴ�
            } else if(21 <= currentSquare && currentSquare <= 25 && currentSquare != 23) {
                nextSquare = currentSquare + moveDistance;
                // ���� �� �밢���� Ż���ϸ� ���� �Ʒ� ĭ���� ������ �� �̵� ����
                if(nextSquare > 25) { 
                    moveDistance = nextSquare - 25;
                    moveDistance--;
                    nextSquare = 16;
                    nextSquare = nextSquare + moveDistance;
                }
            // ���� ������ ������ �Ʒ��� �������� �밢������ �� �κп� ������. ���߾��� �ƴ�
            } else if(26 <= currentSquare && currentSquare <= 27) {
                nextSquare = currentSquare + moveDistance;
                // �Ȱ��� ���κп� �������� ���
                if(nextSquare == 27){
                // ���� ��ǥ ĭ�� ���߾��̸� ���߾� �ε����� ��ȯ
                } else if(nextSquare == 28) {
                    nextSquare = 23;
                // ���� ��ǥ ĭ�� �Ʒ� �κ��� ���. ���� �ƴ�
                } else if(29 <= nextSquare && nextSquare <= 30) {
                    nextSquare--;
                // ���� ĭ���� �� ���� ���
                } else if(nextSquare == 31) {
                    nextSquare = 1;
                    almostGoal = true;
                // ����
                } else {
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            // ���� ������ ������ �Ʒ��� �������� �밢������ �Ʒ� �κп� ������. ���߾��� �ƴ�
            } else if(28 <= currentSquare && currentSquare <= 29) {
                nextSquare = currentSquare + moveDistance;
                // �Ȱ��� �Ʒ� �κп� �������� ���
                if(nextSquare == 29) { 
                // ���� ĭ���� �� ���� ���
                } else if(nextSquare == 30) {
                    nextSquare = 1;
                    almostGoal = true;
                // ����
                } else {
                    goalIn = true;
                    nextSquare = -1;
                    for(int i = 0; i < squares[currentSquare].pieces.size(); i++){
                        players.get(turn).addGoalInNumber();
                    }
                }
            }
        // ���� �϶� ���� ��� ���
        } else {
        	// ���� ���ο��� ���� �ɶ�
            if(1 <= currentSquare && currentSquare <= 20 && currentSquare != 6 && currentSquare != 11) {
            	// ù��° ĭ�� �ִµ�
                if(currentSquare == 1) {
                	// �ѹ��� �̹� ��������
                    if(squares[currentSquare].pieces.get(0).almostGoal == true) {
                        nextSquare = 20;
                    // ���� ó�� ����������
                    } else {
                        nextSquare = currentSquare;
                    }
                // ù��° ĭ�� �ƴ� ������ ĭ��
                } else {
                    nextSquare = currentSquare + moveDistance;
                }
            // ���߾� ĭ���� �����Ҷ�
            } else if(currentSquare == 23) {
                nextSquare = 27;
            // ������ �� �κ� ���ۿ� ������ ������ ���� ĭ���� ��
            } else if(currentSquare == 21) {
                nextSquare = 6;
            // ���� �� �κ� ���ۿ� ������ ���� ���� ĭ���� ��
            } else if(currentSquare == 26) {
                nextSquare = 11;
            // ���߾� �ٷ� �� ���ʿ� ������ ���߾����� ��
            } else if(currentSquare == 24) {
                nextSquare = 23;
            // ���߾� �ٷ� �� �����ʿ� ������ ���߾����� ��
            } else if(currentSquare == 28){
                nextSquare = 23;
            // ������ ĭ
            } else {
                nextSquare = currentSquare + moveDistance;
            }
        }
        // ���������� ������ ���� �鵵�� ������ �ƹ��͵� ���ϰ� ����
        if(currentSquare == nextSquare)
            return currentSquare;
        // ���� ���� ��� ���� ������ ����
        eatAndRollAgain = eatOrMerge(currentSquare, nextSquare, goalIn, almostGoal, turn);
        deletePieces(currentSquare);
        if(eatAndRollAgain)
            players.get(turn).eatAndRollAgain = true;
        
        // ���� ������ �÷��̾ Ȯ��
        checkFinishedPlayers();
        // ��� �÷��̾���� ���� �������� Ȯ��
        boolean finished = checkAllFinished();
        
        // ��� �÷��̾ ��������
        if(finished == true) {
            return -2;
        }
        // ����������
        if(goalIn == true) {
            return -1;
        }
        // �׳� ���� ������ ���
        return nextSquare;
    }

    // ���� ���� �԰ų� �Ʊ� ���� ���� �Լ�
    boolean eatOrMerge(int currentSquare, int nextSquare, boolean goalIn, boolean almostGoal, int turn) {
        boolean eatAndRollAgain = false;
        // �����϶��� �ƹ��͵� ����
        if(nextSquare == -1)
            return false;
        // ��ǥ�� ������ �����ϰ� ������ �ƴҶ�
        if(squares[nextSquare].pieces.size() > 0 && goalIn == false) {
            int deletedPlayer = squares[nextSquare].pieces.get(0).player;
            // �ٸ� �÷��̾��� ���� ��쿡�� ����
            if(deletedPlayer != turn) {
            	// ������ ����ŭ �� �� ����
                for(int i = 0; i < squares[nextSquare].pieces.size(); i++) {
                    players.get(deletedPlayer).deletePieceOnBoard();
                }
                deletePieces(nextSquare);
                eatAndRollAgain = true;
            }
        }
        // ���ο� ���� �����ϴ� ��찡 �ƴҶ�
        if (currentSquare != nextSquare && goalIn == false) {
        	// ���� �ִ� ���� ������ ��ǥ�� �߰�
            for(int i = 0; i < squares[currentSquare].pieces.size(); i++) {
                if(almostGoal == true)
                    addPiece(nextSquare, new Piece(turn, almostGoal));
                else{
                    addPiece(nextSquare, new Piece(turn));
                }
            }
        }
        return eatAndRollAgain;
    }

    // ���� ������ �÷��̾ Ȯ���ϴ� �Լ�
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

    // ��� �÷��̾���� ���� �������� Ȯ���ϴ� �Լ�
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