package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {      // Î™®Îç∏Í≥? Î∑∞Î?? Ïª®Ìä∏Î°§Ìïò?äî ?Å¥?ûò?ä§

    // Î™®Îç∏
    private YutnoriSystem yutnoriSystem;                // ?ú∑???ù¥ ?ãú?ä§?Öú(ÏµúÏ¢ÖÎ™®Îç∏)?ùÑ ?Çò???Ç¥?äî ?ò§Î∏åÏ†ù?ä∏

    // Î∑? Í¥??†® ?ò§Î∏åÏ†ù?ä∏?ùò ?ûêÎ£åÍµ¨Ï°?
    private Alert alert;                                // ?åù?óÖÏ∞? Í¥??†® ?ò§Î∏åÏ†ù?ä∏
    ArrayList<Label> playerPieceStatus;                 // ?îå?†à?ù¥?ñ¥ ?òÑ?ô©?ùÑ ?Çò???Ç¥?äî ?†à?ù¥Î∏îÏùò Î¶¨Ïä§?ä∏
    Circle[][] subSquares;                              // Î≥¥Îìú?úÑ?ùò Ïπ?(Î∏îÎ°ù) ?ïà?ùò ?ûë?? Ïπ∏Îì§?ùÑ ?Çò???Ç¥?äî Î∞∞Ïó¥
    Circle[] mainSquares;                               // Î≥¥Îìú?úÑ?ùò Ïπ?(Î∏îÎ°ù)?ùÑ ?Çò???Ç¥?äî Î∞∞Ïó¥

    // Í∏∞Ì?
    int currentSquare;                                  // ?òÑ?û¨ ÎßêÏùò Ï∂úÎ∞ú ?úÑÏπ?
    boolean rollAgain;                                  // ?ú∑?ù¥?Çò Î™®Í? ?Çò?? ?îå?†à?ù¥?ñ¥Í∞? ?ã§?ãú ?ú∑?ùÑ ?çòÏß??äî ?ÉÅ?Éú

    // Î∑?
    @FXML private TextField playerNumInput;
    @FXML private TextField pieceNumInput;
    @FXML private Button startGame;
    @FXML private Button rollYut;
    @FXML private Button newPiece;
    @FXML private Label showPlayerTurn;
    @FXML private Label player1PieceStatus;
    @FXML private Label player2PieceStatus;
    @FXML private Label player3PieceStatus;
    @FXML private Label player4PieceStatus;
    @FXML private ListView yutList;
    @FXML private Circle p1Color;
    @FXML private Circle p2Color;
    @FXML private Circle p3Color;
    @FXML private Circle p4Color;
    @FXML private Circle square1;
    @FXML private Circle square1_1;
    @FXML private Circle square1_2;
    @FXML private Circle square1_3;
    @FXML private Circle square1_4;
    @FXML private Circle square1_5;
    @FXML private Circle square2;
    @FXML private Circle square2_1;
    @FXML private Circle square2_2;
    @FXML private Circle square2_3;
    @FXML private Circle square2_4;
    @FXML private Circle square2_5;
    @FXML private Circle square3;
    @FXML private Circle square3_1;
    @FXML private Circle square3_2;
    @FXML private Circle square3_3;
    @FXML private Circle square3_4;
    @FXML private Circle square3_5;
    @FXML private Circle square4;
    @FXML private Circle square4_1;
    @FXML private Circle square4_2;
    @FXML private Circle square4_3;
    @FXML private Circle square4_4;
    @FXML private Circle square4_5;
    @FXML private Circle square5;
    @FXML private Circle square5_1;
    @FXML private Circle square5_2;
    @FXML private Circle square5_3;
    @FXML private Circle square5_4;
    @FXML private Circle square5_5;
    @FXML private Circle square6;
    @FXML private Circle square6_1;
    @FXML private Circle square6_2;
    @FXML private Circle square6_3;
    @FXML private Circle square6_4;
    @FXML private Circle square6_5;
    @FXML private Circle square7;
    @FXML private Circle square7_1;
    @FXML private Circle square7_2;
    @FXML private Circle square7_3;
    @FXML private Circle square7_4;
    @FXML private Circle square7_5;
    @FXML private Circle square8;
    @FXML private Circle square8_1;
    @FXML private Circle square8_2;
    @FXML private Circle square8_3;
    @FXML private Circle square8_4;
    @FXML private Circle square8_5;
    @FXML private Circle square9;
    @FXML private Circle square9_1;
    @FXML private Circle square9_2;
    @FXML private Circle square9_3;
    @FXML private Circle square9_4;
    @FXML private Circle square9_5;
    @FXML private Circle square10;
    @FXML private Circle square10_1;
    @FXML private Circle square10_2;
    @FXML private Circle square10_3;
    @FXML private Circle square10_4;
    @FXML private Circle square10_5;
    @FXML private Circle square11;
    @FXML private Circle square11_1;
    @FXML private Circle square11_2;
    @FXML private Circle square11_3;
    @FXML private Circle square11_4;
    @FXML private Circle square11_5;
    @FXML private Circle square12;
    @FXML private Circle square12_1;
    @FXML private Circle square12_2;
    @FXML private Circle square12_3;
    @FXML private Circle square12_4;
    @FXML private Circle square12_5;
    @FXML private Circle square13;
    @FXML private Circle square13_1;
    @FXML private Circle square13_2;
    @FXML private Circle square13_3;
    @FXML private Circle square13_4;
    @FXML private Circle square13_5;
    @FXML private Circle square14;
    @FXML private Circle square14_1;
    @FXML private Circle square14_2;
    @FXML private Circle square14_3;
    @FXML private Circle square14_4;
    @FXML private Circle square14_5;
    @FXML private Circle square15;
    @FXML private Circle square15_1;
    @FXML private Circle square15_2;
    @FXML private Circle square15_3;
    @FXML private Circle square15_4;
    @FXML private Circle square15_5;
    @FXML private Circle square16;
    @FXML private Circle square16_1;
    @FXML private Circle square16_2;
    @FXML private Circle square16_3;
    @FXML private Circle square16_4;
    @FXML private Circle square16_5;
    @FXML private Circle square17;
    @FXML private Circle square17_1;
    @FXML private Circle square17_2;
    @FXML private Circle square17_3;
    @FXML private Circle square17_4;
    @FXML private Circle square17_5;
    @FXML private Circle square18;
    @FXML private Circle square18_1;
    @FXML private Circle square18_2;
    @FXML private Circle square18_3;
    @FXML private Circle square18_4;
    @FXML private Circle square18_5;
    @FXML private Circle square19;
    @FXML private Circle square19_1;
    @FXML private Circle square19_2;
    @FXML private Circle square19_3;
    @FXML private Circle square19_4;
    @FXML private Circle square19_5;
    @FXML private Circle square20;
    @FXML private Circle square20_1;
    @FXML private Circle square20_2;
    @FXML private Circle square20_3;
    @FXML private Circle square20_4;
    @FXML private Circle square20_5;
    @FXML private Circle square21;
    @FXML private Circle square21_1;
    @FXML private Circle square21_2;
    @FXML private Circle square21_3;
    @FXML private Circle square21_4;
    @FXML private Circle square21_5;
    @FXML private Circle square22;
    @FXML private Circle square22_1;
    @FXML private Circle square22_2;
    @FXML private Circle square22_3;
    @FXML private Circle square22_4;
    @FXML private Circle square22_5;
    @FXML private Circle square23;
    @FXML private Circle square23_1;
    @FXML private Circle square23_2;
    @FXML private Circle square23_3;
    @FXML private Circle square23_4;
    @FXML private Circle square23_5;
    @FXML private Circle square24;
    @FXML private Circle square24_1;
    @FXML private Circle square24_2;
    @FXML private Circle square24_3;
    @FXML private Circle square24_4;
    @FXML private Circle square24_5;
    @FXML private Circle square25;
    @FXML private Circle square25_1;
    @FXML private Circle square25_2;
    @FXML private Circle square25_3;
    @FXML private Circle square25_4;
    @FXML private Circle square25_5;
    @FXML private Circle square26;
    @FXML private Circle square26_1;
    @FXML private Circle square26_2;
    @FXML private Circle square26_3;
    @FXML private Circle square26_4;
    @FXML private Circle square26_5;
    @FXML private Circle square27;
    @FXML private Circle square27_1;
    @FXML private Circle square27_2;
    @FXML private Circle square27_3;
    @FXML private Circle square27_4;
    @FXML private Circle square27_5;
    @FXML private Circle square28;
    @FXML private Circle square28_1;
    @FXML private Circle square28_2;
    @FXML private Circle square28_3;
    @FXML private Circle square28_4;
    @FXML private Circle square28_5;
    @FXML private Circle square29;
    @FXML private Circle square29_1;
    @FXML private Circle square29_2;
    @FXML private Circle square29_3;
    @FXML private Circle square29_4;
    @FXML private Circle square29_5;

    // Í≤åÏûÑ ?ãú?ûë Î≤ÑÌäº?ùÑ ?Å¥Î¶??ñà?ùÑ?ïå
    @FXML private void startGameButtonClicked(ActionEvent event) {

        String inputPlayerNumTextField = playerNumInput.getText();  // ?ûÖ?†•Í∞íÏùÑ ?ùΩ?äî?ã§
        String inputPieceNumTextField = pieceNumInput.getText();
        ObservableList<String> yutListElement = FXCollections.observableArrayList();

        // ?ûÖ?†•Í∞íÏóê ???ïú ?òà?ô∏Ï≤òÎ¶¨
        try {
            int tempPlayerNum = Integer.parseInt(inputPlayerNumTextField);
            int tempPieceNum = Integer.parseInt(inputPieceNumTextField);

            // ?îå?†à?ù¥?ñ¥ ?àò?? ÎßêÏùò ?àò?ùò Î≤îÏúÑÎ•? Î≤óÏñ¥?Ç† ?ïå
            if(tempPlayerNum < 2 || tempPlayerNum > 4 || (tempPieceNum<2 || tempPieceNum > 5)){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("?îå?†à?ù¥?ñ¥ ?àò?äî 2?óê?Ñú 4 ?Ç¨?ù¥?ùò ?àòÎ°? ?ûÖ?†•?ïò?Ñ∏?öî." +
                        "\nÎßêÏùò ?àò?äî 2?óê?Ñú 5 ?Ç¨?ù¥?ùò ?àòÎ°? ?ûÖ?†•?ïò?Ñ∏?öî");
                alert.setHeaderText(null);
                alert.show();
                playerNumInput.setText("");
                pieceNumInput.setText("");
            }
            // ?†ï?ÉÅ?†Å?úºÎ°? ÏßÑÌñâ?ê† ?ïå
            else {
                showPlayerTurn.setText("?îå?†à?ù¥?ñ¥" +  1 + " ?àú?Ñú?ûÖ?ãà?ã§." +			// !!!!?àú?Ñú ?ûú?ç§?úºÎ°? ?ï†?ãú ?àò?†ï?Ç¨?ï≠!!!!
                        "\nÎßêÏùÑ ?Ñ†?Éù?õÑ ?ú∑?ùÑ ?çò?†∏Ï£ºÏÑ∏?öî!");
                yutList.setItems(yutListElement);
                yutnoriSystem.startGame(tempPlayerNum, tempPieceNum);          // Î™®Îç∏?ùÑ Ï¥àÍ∏∞?ôî

                subSquares[1][1].setVisible(true);                             // Ï≤´Î≤àÏß? squareÎ•? View?óê Î≥¥Ïù¥Í≤? ?Ñ§?†ï?ïòÍ≥?
                subSquares[1][1].setFill(yutnoriSystem.currentColor(0));

                int totalPieceNumber;
                for(int i = 0; i < yutnoriSystem.playingPlayer.size(); i++){   // ?îå?†à?ù¥?ñ¥Î≥? Îß? ?òÑ?ô© Ï∂úÎ†•
                    totalPieceNumber = yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + yutnoriSystem.playingPlayer.get(i).notOnBoardPieceNumber;
                    playerPieceStatus.get(i).setText("?òÑ?û¨: " + yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + " / Ï¥?: "
                            + totalPieceNumber + " / Í≥®Ïù∏: " + yutnoriSystem.playingPlayer.get(i).goalInNumber);
                }

                playerNumInput.setDisable(true);
                pieceNumInput.setDisable(true);
                startGame.setDisable(true);
                enableMainSquares();

                currentSquare = 1;                                  // Ï∂úÎ∞ú Ïπ∏Ï? Í∏∞Î≥∏?úºÎ°? ?ãú?ûë?†ê
                yutnoriSystem.playingPlayer.get(0).turn = true;     // ?îå?†à?ù¥?ñ¥ 1?ù¥ Ï≤´Î≤àÏß∏Î°ú ?ãú?ûë?ïú?ã§
            }
        }
        // ?à´?ûêÍ∞? ?ïÑ?ãå ?ûÖ?†•Í∞íÏùº?ïå
        catch (NumberFormatException e) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("?à´?ûêÎ°? ?ã§?ãú ?ûÖ?†•?ïò?ãú?ò§");
            alert.setHeaderText(null);
            alert.show();
            playerNumInput.setText("");
            pieceNumInput.setText("");
        }
    }

    // ?ú∑?? ?çòÏß??äî Î≤ÑÌäº?ùÑ ?Å¥Î¶??ñà?ùÑ?ïå
    @FXML private void rollYutButtonClicked(ActionEvent event) {

        String[] yutResultList = {"Î™?","?èÑ","Í∞?","Í±?","?ú∑","ÎπΩÎèÑ"};
        int yutResult = yutnoriSystem.rollYuts();
        yutList.getItems().add(yutResultList[yutResult]);
        if(yutResult == 0 | yutResult == 4) {               // ?ú∑?ù¥?Çò Î™®Ïù¥Î©? ?ã§?ãú ?ïúÎ≤? ?çòÏßàÏàò ?ûà?ùå
            showPlayerTurn.setText("?ú∑?ù¥?Çò Î™®Í? ?Çò?? ?ïúÎ≤? ?çî ?çòÏßàÏàò ?ûà?äµ?ãà?ã§!");
            return;
        }

        yutnoriSystem.playingPlayer.get(yutnoriSystem.currentTurn()).eatAndRollAgain = false;
        rollYut.setDisable(true);
        disableMainSquares();
        yutList.setDisable(false);
    }

    // ?çòÏß? ?ú∑ Î™©Î°ù?óê?Ñú ?ú∑?ùÑ ?Ñ†?Éù(?Å¥Î¶?)?ñà?ùÑ?ïå
    @FXML private void listViewSetOnMouseClicked(MouseEvent event){

        String yutType;
        Circle temp;
        Color color;
        int turn;
        int yutindex;
        int moveDistance;
        int nextSquare;

        try{
            yutType = yutList.getSelectionModel().getSelectedItem().toString();
        }
        catch(Exception e){
            return;
        }

        yutindex = yutList.getSelectionModel().getSelectedIndex();       // ?Ñ†?Éù?ïú ?ú∑ Î™©Î°ù
        moveDistance = yutnoriSystem.switchYut(yutType);                 // ?Ñ†?Éù?ïú ?ú∑ Î™©Î°ù?ùÑ int?òï ??ÏßÅÏùº Í±∞Î¶¨Î°? return
        yutList.getItems().remove(yutindex);                             // ??ÏßÅÏù∏ ?ú∑ Î™©Î°ù ?Ç≠?†ú

        turn = yutnoriSystem.currentTurn();
        color = yutnoriSystem.currentColor(turn);
        for(int i = 1; i <= (yutnoriSystem.board.squares)[currentSquare].pieces.size(); i++){   // ?õê?ûò ?ûà?çò square?ùò circle?ì§?ùÑ ?ïàÎ≥¥Ïù¥Í≤?
            subSquares[currentSquare][i].setVisible(false);
        }

        nextSquare = yutnoriSystem.board.movePiece(currentSquare, moveDistance, turn);          // piece ?ù¥?èô!!!!!!!!!!!!!!!!!

        // ?ãú?ûë Ïß??†ê?óê?Ñú Î∞±ÎèÑ?Çò?ò§Î©? ?ã§?ãú circle?ì§?ùÑ Î≥¥Ïù¥Í≤?
        if(nextSquare == currentSquare){
            for(int i = 1; i <= (yutnoriSystem.board.squares)[currentSquare].pieces.size(); i++){
                subSquares[currentSquare][i].setVisible(true);
            }
        }
        // Î™®Îì† ?îå?†à?ù¥?ñ¥?ùò ?Ñ¥?ù¥ ?Åù?ÇòÎ©? Í≤åÏûÑ Ï¢ÖÎ£å
        else if(nextSquare == -2){
            int totalPieceNumber;
            for(int i = 0; i < yutnoriSystem.playingPlayer.size(); i++){ // ?îå?†à?ù¥?ñ¥Î≥? Îß? ?òÑ?ô© Ï∂úÎ†•
                totalPieceNumber = yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + yutnoriSystem.playingPlayer.get(i).notOnBoardPieceNumber;
                playerPieceStatus.get(i).setText("?òÑ?û¨: " + yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + " / Ï¥?: "
                        + totalPieceNumber + " / Í≥®Ïù∏: " + yutnoriSystem.playingPlayer.get(i).goalInNumber);
            }

            int[] rank = new int[yutnoriSystem.playerNum];
            String rankMsg = null;
            rankMsg = "Í≤åÏûÑ?ù¥ ?Åù?Ç¨?äµ?ãà?ã§. ?àú?úÑ?äî ?ïÑ?ûò?? Í∞ôÏäµ?ãà?ã§.\n\n";
            yutnoriSystem.calcRank();                                   // ?àú?úÑ Í≥ÑÏÇ∞
            for(int i = 0; i < yutnoriSystem.playerNum; i++){
                rank[i] = yutnoriSystem.playingPlayer.get(i).playerID;
                rankMsg = rankMsg.concat((i + 1) + "?ì±: ?îå?†à?ù¥?ñ¥" + (rank[i] + 1) + "\n");
            }
            showPlayerTurn.setText("");

            alert = new Alert(Alert.AlertType.INFORMATION);             // ?àú?úÑ Ï∂úÎ†•
            alert.setTitle("Good Game");
            alert.setContentText(rankMsg);
            alert.setHeaderText(null);
            alert.show();

            return;
        }
        // ?ù¥?èô ?ñà?äî?ç∞ Í≥®Ïù∏ ?ïà?ñà?ùÑ Í≤ΩÏö∞ ?èÑÏ∞? square?ùò circle?ì§?ùÑ Î≥¥Ïù¥Í≤?
        else if(nextSquare != -1){
            for(int i = 1; i <= 5; i++){   // Î™©Ìëú Ïπ? ?ùº?ã® Î™®Îëê ?ïàÎ≥¥Ïù¥Í≤? ?ïòÍ≥?
                temp = subSquares[nextSquare][i];
                temp.setVisible(false);
            }
            for(int i = 1; i <= (yutnoriSystem.board.squares)[nextSquare].pieces.size(); i++){   // Î™©Ìëú Ïπ∏Ïóê ?ã§?†ú Ï°¥Ïû¨?ïò?äî ÎßêÎì§Îß? Î≥¥Ïù¥Í≤? ?ïòÍ∏?
                temp = subSquares[nextSquare][i];
                temp.setVisible(true);
                temp.setFill(color);
            }
        }
        // ?ù¥?èô?ïòÍ≥? Í≥®Ïù∏?ñà?ùÑ Í≤ΩÏö∞ ?Ç®?ïÑ?ûà?äî yutListÎ•? Ï¥àÍ∏∞?ôî
        else {
            yutList.getItems().clear();
        }


        // Í∞ôÏ? ?îå?†à?ù¥?ñ¥Í∞? ?òê ?ú∑?ùÑ ?çòÏß?Ïß? ?ïä?ùÑ?ïå turn Î≥?Í≤?
        if(yutList.getItems().size() ==  0){
            if(yutnoriSystem.playingPlayer.get(turn).eatAndRollAgain == false){
                turn = yutnoriSystem.nextTurn();                                               // ?ã§?ùå Ï∞®Î?Î•? ?Ñ§?†ï

                boolean initialized = yutnoriSystem.board.initializePiece(turn);  // ?ã§?ùå Ï∞®Î?Í∞? Î≥¥Îìú ?úÑ?óê ÎßêÏù¥ ?ïò?Çò?èÑ ?óÜ?ùÑ Í≤ΩÏö∞ ?ûê?èô?úºÎ°? ?ÜìÍ∏?. ?ù¥ÎØ? Ï°¥Ïû¨?ïò?äî ÎßêÏùÑ Î®πÏùÑ ?àò ?ûà?ã§.
                if(initialized == true){
                    subSquares[1][1].setFill(yutnoriSystem.currentColor(turn));
                    subSquares[1][1].setVisible(true);
                    newPiece.setDisable(true);
                }
                else if(yutnoriSystem.playingPlayer.get(turn).notOnBoardPieceNumber == 0){
                    newPiece.setDisable(true);
                }
                else {
                    newPiece.setDisable(false);
                }
                showPlayerTurn.setText("?îå?†à?ù¥?ñ¥" + (turn + 1) + " ?àú?Ñú?ûÖ?ãà?ã§." +
                        "\nÎßêÏùÑ ?Ñ†?Éù?õÑ ?ú∑?ùÑ ?çò?†∏Ï£ºÏÑ∏?öî!");
                rollAgain = false;
                rollYut.setDisable(true);
                yutList.setDisable(true);
                enableMainSquares();
            }
            else{
                showPlayerTurn.setText("?îå?†à?ù¥?ñ¥" + (turn + 1) + " ?àú?Ñú?ûÖ?ãà?ã§." +
                        "\n?ÉÅ?? ÎßêÏùÑ Î®πÏóà?úº?ãà ?ú∑?ùÑ ?çòÏß??Ñ∏?öî!");
                rollAgain = true;
                rollYut.setDisable(false);
                yutList.setDisable(true);
                disableMainSquares();
                currentSquare = nextSquare;
            }
        }
        // Í∞ôÏ? ?îå?†à?ù¥?ñ¥Í∞? ?òê ?ú∑?ùÑ ?çòÏß??äî Í≤ΩÏö∞
        else{
            showPlayerTurn.setText("?îå?†à?ù¥?ñ¥" + (turn + 1) + " ?àú?Ñú?ûÖ?ãà?ã§." +
                    "\nÎßêÏùÑ ?Ñ†?Éù?õÑ ?ù¥?èô ?Ñ†?Éù?ùÑ ?ï¥Ï£ºÏÑ∏?öî!");
            rollAgain = true;
            rollYut.setDisable(true);
            yutList.setDisable(true);
            enableMainSquares();
        }

        int totalPieceNumber;
        for(int i = 0; i < yutnoriSystem.playingPlayer.size(); i++){      // ?îå?†à?ù¥?ñ¥Î≥? Îß? ?òÑ?ô© Ï∂úÎ†•
            totalPieceNumber = yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + yutnoriSystem.playingPlayer.get(i).notOnBoardPieceNumber;
            playerPieceStatus.get(i).setText("?òÑ?û¨: " + yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + " / Ï¥?: "
                    + totalPieceNumber + " / Í≥®Ïù∏: " + yutnoriSystem.playingPlayer.get(i).goalInNumber);
        }
    }

    // Î≥¥Îìú ?úÑ?óê?Ñú Ïπ?(Î∏îÎ°ù)?ùÑ ?Å¥Î¶??ïò?ó¨ ?Ñ†?Éù?ï† Í≤ΩÏö∞
    @FXML private void boardOnMouseClicked(MouseEvent event){
        Circle circle = (Circle)event.getSource();
        circle.setFill(Color.RED);
        for(int i = 1; i <= 29; i++){                           // Î™®Îì† Ïπ?(Î∏îÎ°ù)?ì§?? Í∏∞Î≥∏?Éâ?úºÎ°? Î∞îÍæ∏Í≥?
            if(mainSquares[i] != circle){
                mainSquares[i].setFill(Color.LIGHTGOLDENRODYELLOW);
            }
        }

        currentSquare = getSquareIndex(circle);                 // ?Ñ†?Éù?ïú Ïπ∏Ïùò ?ù∏?ç±?ä§Î•? Î∞õÏïÑ?ò§Í≥?

        int turn = yutnoriSystem.currentTurn();                 // ?òÑ?û¨ ?àú?Ñú?ù∏ ?îå?†à?ù¥?ñ¥Î•? ?ôï?ù∏?ïòÍ≥?

        // ?Ñ†?Éù(?Å¥Î¶?)?ïú Ïπ?(Î∏îÎ°ù)?óê Î≥∏Ïù∏ ?Üå?ú†?ùò ÎßêÏù¥ ?óÜ?ùÑ Í≤ΩÏö∞ 1
        if(yutnoriSystem.board.squares[currentSquare].pieces.size() == 0){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("?ï¥?ãπ Ïπ∏Ïóê?äî ?Üå?ú†?ïú ÎßêÏù¥ ?óÜ?äµ?ãà?ã§. ?ã§?ãú ?Ñ†?Éù?ï¥Ï£ºÏÑ∏?öî");
            alert.setHeaderText(null);
            alert.show();
            circle.setFill(Color.LIGHTGOLDENRODYELLOW);
            return;
        }
        // ?Ñ†?Éù(?Å¥Î¶?)?ïú Ïπ?(Î∏îÎ°ù)?óê Î≥∏Ïù∏ ?Üå?ú†?ùò ÎßêÏù¥ ?óÜ?ùÑ Í≤ΩÏö∞ 2
        else if(yutnoriSystem.board.squares[currentSquare].pieces.get(0).player != turn){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setContentText("?ï¥?ãπ Ïπ∏Ïóê?äî ?Üå?ú†?ïú ÎßêÏù¥ ?óÜ?äµ?ãà?ã§. ?ã§?ãú ?Ñ†?Éù?ï¥Ï£ºÏÑ∏?öî");
            alert.setHeaderText(null);
            alert.show();
            circle.setFill(Color.LIGHTGOLDENRODYELLOW);
            return;
        }

        // ?îå?†à?ù¥?ñ¥Í∞? ?ú∑?ùÑ ?ã§?ãú ?çòÏß? Í≤ΩÏö∞
        if(rollAgain == true) {
            rollYut.setDisable(true);
            yutList.setDisable(false);
        }
        else {
            rollYut.setDisable(false);
        }
        newPiece.setDisable(true);
    }

    // ?îå?†à?ù¥?ñ¥Í∞? ?ÉàÎ°úÏö¥ ÎßêÏùÑ ?Ç¥Î≥¥ÎÇ¥?äî Î≤ÑÌäº?ùÑ ?Å¥Î¶??ñà?ùÑ?ïå
    @FXML private void newPieceClicked(MouseEvent event){

        int turn = yutnoriSystem.currentTurn();           // ?òÑ?û¨ ?àú?Ñú?ù∏ ?îå?†à?ù¥?ñ¥Î•? ?ôï?ù∏?ïòÍ≥?

        yutnoriSystem.board.eatOrMerge(1,1, false, false, turn);   // ?ù¥ÎØ? ?ãú?ûëÏπ∏Ïóê Ï°¥Ïû¨?ïò?äî ?ã§Î•? ?îå?†à?ù¥?ñ¥?ùò ÎßêÏùÑ Î®πÏùå
        yutnoriSystem.board.squares[1].pieces.add(new Piece(turn));                                             // ?ãú?ûëÏπ∏Ïóê ?ÉàÎ°úÏö¥ ÎßêÏùÑ Ï∂îÍ?
        yutnoriSystem.playingPlayer.get(turn).addPieceOnBoard();

        Circle temp;
        for(int i = 1; i <= (yutnoriSystem.board.squares)[1].pieces.size(); i++){  // ?ãú?ûë Ïß??†ê?ùò circle?ì§?ùÑ ?ïåÎßûÍ≤å ?ÉâÏπ†ÌïòÍ≥? ?óÖ?ç∞?ù¥?ä∏ Î≥¥Ïù¥Í≤?
            temp = subSquares[1][i];
            temp.setVisible(true);
            temp.setFill(yutnoriSystem.playingPlayer.get(turn).getColor());
        }

        int totalPieceNumber;
        for(int i = 0; i < yutnoriSystem.playingPlayer.size(); i++) {              // ?îå?†à?ù¥?ñ¥Î≥? Îß? ?òÑ?ô© Ï∂úÎ†•
            totalPieceNumber = yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + yutnoriSystem.playingPlayer.get(i).notOnBoardPieceNumber;
            playerPieceStatus.get(i).setText("?òÑ?û¨: " + yutnoriSystem.playingPlayer.get(i).onBoardPieceNumber + " / Ï¥?: "
                    + totalPieceNumber + " / Í≥®Ïù∏: " + yutnoriSystem.playingPlayer.get(i).goalInNumber);
        }

        disableMainSquares();
        yutList.setDisable(true);
        newPiece.setDisable(true);
        rollYut.setDisable(false);
        currentSquare = 1;
    }

    // ?îå?†à?ù¥?ñ¥Í∞? Î≥¥Îìú?óê?Ñú ?Ñ†?Éù?ïú Ïπ?(Î∏îÎ°ù)?óê ?ï¥?ãπ?ïò?äî ?ù∏?ç±?ä§Î•? Î¶¨ÌÑ¥?ïò?äî ?ï®?àò
    int getSquareIndex(Circle circle){
        if(circle == square1)
            return 1;
        else if(circle == square2)
            return 2;
        else if(circle == square3)
            return 3;
        else if(circle == square4)
            return 4;
        else if(circle == square5)
            return 5;
        else if(circle == square6)
            return 6;
        else if(circle == square7)
            return 7;
        else if(circle == square8)
            return 8;
        else if(circle == square9)
            return 9;
        else if(circle == square10)
            return 10;
        else if(circle == square11)
            return 11;
        else if(circle == square12)
            return 12;
        else if(circle == square13)
            return 13;
        else if(circle == square14)
            return 14;
        else if(circle == square15)
            return 15;
        else if(circle == square16)
            return 16;
        else if(circle == square17)
            return 17;
        else if(circle == square18)
            return 18;
        else if(circle == square19)
            return 19;
        else if(circle == square20)
            return 20;
        else if(circle == square21)
            return 21;
        else if(circle == square22)
            return 22;
        else if(circle == square23)
            return 23;
        else if(circle == square24)
            return 24;
        else if(circle == square25)
            return 25;
        else if(circle == square26)
            return 26;
        else if(circle == square27)
            return 27;
        else if(circle == square28)
            return 28;
        return 29;
    }

    // Î≥¥Îìú ?úÑ?ùò Î™®Îì† Ïπ∏ÏùÑ ?Ñ†?Éù Î∂àÍ??ä•?ïòÍ≤? Î≥?Í≤ΩÌïò?äî ?ï®?àò
    void disableMainSquares(){
        for(int i = 1; i <= 29; i++){
            mainSquares[i].setDisable(true);
            mainSquares[i].setFill(Color.LIGHTGOLDENRODYELLOW);
        }
    }

    // Î≥¥Îìú ?úÑ?ùò Î™®Îì† Ïπ∏ÏùÑ ?Ñ†?Éù Í∞??ä•?ïòÍ≤? Î≥?Í≤ΩÌïò?äî ?ï®?àò
    void enableMainSquares(){
        for(int i = 1; i <= 29; i++){
            mainSquares[i].setDisable(false);
            mainSquares[i].setFill(Color.LIGHTGOLDENRODYELLOW);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    // Î∑? ?öî?Üå?ì§Í≥? ?ûêÎ£åÍµ¨Ï°? Ï¥àÍ∏∞?ôî

        yutnoriSystem = new YutnoriSystem();

        yutList.setDisable(true);
        rollYut.setDisable(true);

        subSquares = new Circle[30][6];
        mainSquares = new Circle[30];

        subSquares[1][1] = (square1_1);  // Î≥¥Îìú ?ûêÎ£åÍµ¨Ï°∞Ïóê ?ï¥?ãπ?ïò?äî Î∑? ?öî?Üå ÏßëÏñ¥?Ñ£Í∏?
        subSquares[1][2] = (square1_2);
        subSquares[1][3] = (square1_3);
        subSquares[1][4] = (square1_4);
        subSquares[1][5] = (square1_5);
        subSquares[2][1] = (square2_1);
        subSquares[2][2] = (square2_2);
        subSquares[2][3] = (square2_3);
        subSquares[2][4] = (square2_4);
        subSquares[2][5] = (square2_5);
        subSquares[3][1] = (square3_1);
        subSquares[3][2] = (square3_2);
        subSquares[3][3] = (square3_3);
        subSquares[3][4] = (square3_4);
        subSquares[3][5] = (square3_5);
        subSquares[4][1] = (square4_1);
        subSquares[4][2] = (square4_2);
        subSquares[4][3] = (square4_3);
        subSquares[4][4] = (square4_4);
        subSquares[4][5] = (square4_5);
        subSquares[5][1] = (square5_1);
        subSquares[5][2] = (square5_2);
        subSquares[5][3] = (square5_3);
        subSquares[5][4] = (square5_4);
        subSquares[5][5] = (square5_5);
        subSquares[6][1] = (square6_1);
        subSquares[6][2] = (square6_2);
        subSquares[6][3] = (square6_3);
        subSquares[6][4] = (square6_4);
        subSquares[6][5] = (square6_5);
        subSquares[7][1] = (square7_1);
        subSquares[7][2] = (square7_2);
        subSquares[7][3] = (square7_3);
        subSquares[7][4] = (square7_4);
        subSquares[7][5] = (square7_5);
        subSquares[8][1] = (square8_1);
        subSquares[8][2] = (square8_2);
        subSquares[8][3] = (square8_3);
        subSquares[8][4] = (square8_4);
        subSquares[8][5] = (square8_5);
        subSquares[9][1] = (square9_1);
        subSquares[9][2] = (square9_2);
        subSquares[9][3] = (square9_3);
        subSquares[9][4] = (square9_4);
        subSquares[9][5] = (square9_5);
        subSquares[10][1] = (square10_1);
        subSquares[10][2] = (square10_2);
        subSquares[10][3] = (square10_3);
        subSquares[10][4] = (square10_4);
        subSquares[10][5] = (square10_5);
        subSquares[11][1] = (square11_1);
        subSquares[11][2] = (square11_2);
        subSquares[11][3] = (square11_3);
        subSquares[11][4] = (square11_4);
        subSquares[11][5] = (square11_5);
        subSquares[12][1] = (square12_1);
        subSquares[12][2] = (square12_2);
        subSquares[12][3] = (square12_3);
        subSquares[12][4] = (square12_4);
        subSquares[12][5] = (square12_5);
        subSquares[13][1] = (square13_1);
        subSquares[13][2] = (square13_2);
        subSquares[13][3] = (square13_3);
        subSquares[13][4] = (square13_4);
        subSquares[13][5] = (square13_5);
        subSquares[14][1] = (square14_1);
        subSquares[14][2] = (square14_2);
        subSquares[14][3] = (square14_3);
        subSquares[14][4] = (square14_4);
        subSquares[14][5] = (square14_5);
        subSquares[15][1] = (square15_1);
        subSquares[15][2] = (square15_2);
        subSquares[15][3] = (square15_3);
        subSquares[15][4] = (square15_4);
        subSquares[15][5] = (square15_5);
        subSquares[16][1] = (square16_1);
        subSquares[16][2] = (square16_2);
        subSquares[16][3] = (square16_3);
        subSquares[16][4] = (square16_4);
        subSquares[16][5] = (square16_5);
        subSquares[17][1] = (square17_1);
        subSquares[17][2] = (square17_2);
        subSquares[17][3] = (square17_3);
        subSquares[17][4] = (square17_4);
        subSquares[17][5] = (square17_5);
        subSquares[18][1] = (square18_1);
        subSquares[18][2] = (square18_2);
        subSquares[18][3] = (square18_3);
        subSquares[18][4] = (square18_4);
        subSquares[18][5] = (square18_5);
        subSquares[19][1] = (square19_1);
        subSquares[19][2] = (square19_2);
        subSquares[19][3] = (square19_3);
        subSquares[19][4] = (square19_4);
        subSquares[19][5] = (square19_5);
        subSquares[20][1] = (square20_1);
        subSquares[20][2] = (square20_2);
        subSquares[20][3] = (square20_3);
        subSquares[20][4] = (square20_4);
        subSquares[20][5] = (square20_5);
        subSquares[21][1] = (square21_1);
        subSquares[21][2] = (square21_2);
        subSquares[21][3] = (square21_3);
        subSquares[21][4] = (square21_4);
        subSquares[21][5] = (square21_5);
        subSquares[22][1] = (square22_1);
        subSquares[22][2] = (square22_2);
        subSquares[22][3] = (square22_3);
        subSquares[22][4] = (square22_4);
        subSquares[22][5] = (square22_5);
        subSquares[23][1] = (square23_1);
        subSquares[23][2] = (square23_2);
        subSquares[23][3] = (square23_3);
        subSquares[23][4] = (square23_4);
        subSquares[23][5] = (square23_5);
        subSquares[24][1] = (square24_1);
        subSquares[24][2] = (square24_2);
        subSquares[24][3] = (square24_3);
        subSquares[24][4] = (square24_4);
        subSquares[24][5] = (square24_5);
        subSquares[25][1] = (square25_1);
        subSquares[25][2] = (square25_2);
        subSquares[25][3] = (square25_3);
        subSquares[25][4] = (square25_4);
        subSquares[25][5] = (square25_5);
        subSquares[26][1] = (square26_1);
        subSquares[26][2] = (square26_2);
        subSquares[26][3] = (square26_3);
        subSquares[26][4] = (square26_4);
        subSquares[26][5] = (square26_5);
        subSquares[27][1] = (square27_1);
        subSquares[27][2] = (square27_2);
        subSquares[27][3] = (square27_3);
        subSquares[27][4] = (square27_4);
        subSquares[27][5] = (square27_5);
        subSquares[28][1] = (square28_1);
        subSquares[28][2] = (square28_2);
        subSquares[28][3] = (square28_3);
        subSquares[28][4] = (square28_4);
        subSquares[28][5] = (square28_5);
        subSquares[29][1] = (square29_1);
        subSquares[29][2] = (square29_2);
        subSquares[29][3] = (square29_3);
        subSquares[29][4] = (square29_4);
        subSquares[29][5] = (square29_5);

        mainSquares[1] = square1;
        mainSquares[2] = square2;
        mainSquares[3] = square3;
        mainSquares[4] = square4;
        mainSquares[5] = square5;
        mainSquares[6] = square6;
        mainSquares[7] = square7;
        mainSquares[8] = square8;
        mainSquares[9] = square9;
        mainSquares[10] = square10;
        mainSquares[11] = square11;
        mainSquares[12] = square12;
        mainSquares[13] = square13;
        mainSquares[14] = square14;
        mainSquares[15] = square15;
        mainSquares[16] = square16;
        mainSquares[17] = square17;
        mainSquares[18] = square18;
        mainSquares[19] = square19;
        mainSquares[20] = square20;
        mainSquares[21] = square21;
        mainSquares[22] = square22;
        mainSquares[23] = square23;
        mainSquares[24] = square24;
        mainSquares[25] = square25;
        mainSquares[26] = square26;
        mainSquares[27] = square27;
        mainSquares[28] = square28;
        mainSquares[29] = square29;

        playerPieceStatus = new ArrayList<>();      // ?îå?†à?ù¥?ñ¥ ?òÑ?ô© ?†à?ù¥Î∏îÎèÑ ?ûêÎ£åÍµ¨Ï°∞Ïóê Ï∂îÍ?
        playerPieceStatus.add(player1PieceStatus);
        playerPieceStatus.add(player2PieceStatus);
        playerPieceStatus.add(player3PieceStatus);
        playerPieceStatus.add(player4PieceStatus);

        for(int i = 1; i <= 29; i++){              // Î≥¥Îìú?ùò Î™®Îì† Ïπ?(Î∏îÎ°ù)?Ç¥?ùò ?Ñ∏Î∂? Ïπ∏Îì§?ù¥ ?ïàÎ≥¥Ïù¥Í≤? Ï¥àÍ∏∞?ôî
            for(int j = 1; j <= 5; j++){
                subSquares[i][j].setVisible(false);
            }
            mainSquares[i].setFill(Color.LIGHTGOLDENRODYELLOW); // Ï£ºÏöî Ïπ∏Îì§ ?Éâ Ï¥àÍ∏∞?ôî
            mainSquares[i].setDisable(true);
        }

        p1Color.setFill(Color.ORANGE);             // ?îå?†à?ù¥?ñ¥ ?Éâ Ïß??†ï
        p2Color.setFill(Color.GREEN);
        p3Color.setFill(Color.PURPLE);
        p4Color.setFill(Color.PINK);

        newPiece.setDisable(true);
    }
}
