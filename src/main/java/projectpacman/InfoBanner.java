package projectpacman;

import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import projectpacman.Board.boardSettings;

import projectpacman.GameLogic.GameMode;

/**
 * InfoBanner is loaded as a VBox inside the initializer, it has HBoxes to horrizontially display
 * the current game information
 */
public class InfoBanner extends StackPane {
    private static int verticalCanvasBuffer;
    private final Label scoreLabel;

    public InfoBanner() {
        setMinHeight(getVerticalBuffer());
        setStyle("-fx-background-color: rgb(21, 21, 21);");
    
        scoreLabel = new Label("Score: " + "Lives: ");
        Font gameFont = Font.loadFont(
            getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"),
            boardSettings.get_Block_size()
        );
        scoreLabel.setFont(gameFont);
        scoreLabel.setTextFill(Color.rgb(86, 75, 239));
        
        getChildren().addAll(scoreLabel);
    }


    public void updateScore(int score, int lives) {
        scoreLabel.setText("Score: " + score + " Lives:" + lives);
    }

    public static int getVerticalBuffer() {
        return verticalCanvasBuffer;
    }

    public static void setVerticalBuffer(int new_verticalCanvasBuffer) {
        verticalCanvasBuffer = new_verticalCanvasBuffer;
    }

    public void updateStatus(int score, int lives, Label resultLabel, GameMode mode, int remainingPellets, int remainingLives) {
        updateScore(score, lives);
    
        if (resultLabel == null) return;
    
        if (remainingPellets == 0) {
            resultLabel.setText("YOU WIN!");
            resultLabel.setTextFill(Color.LIMEGREEN);
            resultLabel.setVisible(true);
        } else if (remainingLives < 0) {
            resultLabel.setText("GAME OVER");
            resultLabel.setTextFill(Color.RED);
            resultLabel.setVisible(true);
        } else {
            resultLabel.setVisible(false); // hide it during normal play
        }
    }
    


}
