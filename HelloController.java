package gb.ru.java2homework4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label scoreMark;
    @FXML
    private Label gameLog;
    @FXML
    private Button rockButton;
    @FXML
    private Button paperButton;
    @FXML
    private Button scissorsButton;

    private RockPaperScissorsGame game;

    public HelloController() {
        this.game = new RockPaperScissorsGame();
    }

    @FXML
    public Label score;

    public void onRockButtonClick(ActionEvent event) {
        playGame(event);
    }

    public void onScissorsButtonClick(ActionEvent event) {
        playGame(event);
    }

    public void onPaperButtonClick(ActionEvent event) {
        playGame(event);
    }

    private void playGame(ActionEvent event) {
        gameLog.setText(game.winner(game.playerChoose(event), game.computerChoose()));
        scoreMark.setVisible(true);
        scoreMark.setText("Общий счет");
        gameLog.setVisible(true);
        score.setText(String.format("Игрок %d - %d Компьютер", game.getPlayerScore(), game.getComputerScore()));
    }

    public void startNewGame(ActionEvent event) {
        gameLog.setVisible(false);
        scoreMark.setVisible(false);
        score.setText("Выбери ход");
        game.setPlayerScore(0);
        game.setComputerScore(0);
    }

    public void exitGame(ActionEvent event) {
        System.exit(0);
    }
}