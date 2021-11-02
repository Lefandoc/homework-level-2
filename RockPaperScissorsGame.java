package gb.ru.java2homework4;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.util.Random;

public class RockPaperScissorsGame {

    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    private int playerScore = 0;
    private int computerScore = 0;


    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public String playerChoose(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "rockButton":
                return ROCK;
            case "paperButton":
                return PAPER;
            default:
                return SCISSORS;
        }
    }

    public String computerChoose() {
        Random r = new Random();
        switch (r.nextInt(3)) {
            case 0:
                return ROCK;
            case 1:
                return PAPER;
            default:
                return SCISSORS;
        }
    }

    public String computerWin() {
        computerScore++;
        return "Победил компьютер";
    }

    public String playerWin() {
        playerScore++;
        return "Победил игрок";
    }

    public String draw() {
        return "Ничья";
    }

    public String winner(String playerChoose, String computerChoose) {
        if (playerChoose.equals(ROCK)) {
            if (computerChoose.equals(PAPER)) {
                return computerWin();
            } else if (computerChoose.equals(SCISSORS)) {
                return playerWin();
            }
        }
        if (playerChoose.equals(PAPER)) {
            if (computerChoose.equals(ROCK)) {
                return playerWin();
            } else if (computerChoose.equals(SCISSORS)) {
                return computerWin();
            }
        }
        if (playerChoose.equals(SCISSORS)) {
            if (computerChoose.equals(ROCK)) {
                return computerWin();
            } else if (computerChoose.equals(PAPER)) {
                return playerWin();
            }
        }
        return draw();
    }
}
