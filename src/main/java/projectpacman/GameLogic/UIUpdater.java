package projectpacman.GameLogic;

import javafx.scene.control.Label;

/**
 * UIUpdater manages InfoBanner, and the Win / Loss screens
 * 
 * The class recieves a singleton instance of GameState to retrieve the statistics about remaining
 * lives and pellets. And it recieves a instance of currentgame to update the UI banner.
 */
public class UIUpdater {
    private final GameState state = GameState.getInstance();
    private final CurrentGame game = CurrentGame.getInstance();

    public void update() {
        Label resultLabel = game.getGameResultLabel();
        if (resultLabel == null) return;

        if (state.getRemainingPellets() == 0) {
            resultLabel.setText("YOU WIN!");
            resultLabel.setTextFill(javafx.scene.paint.Color.LIMEGREEN);
            resultLabel.setVisible(true);
        } else if (state.getRemainingLives() < 0) {
            resultLabel.setText("GAME OVER");
            resultLabel.setTextFill(javafx.scene.paint.Color.RED);
            resultLabel.setVisible(true);
        } else {
            resultLabel.setVisible(false);
        }

        game.getInfoBanner().updateStatus(
            state.getScore(),
            state.getRemainingLives(),
            resultLabel,
            state.getMode(),
            state.getRemainingPellets(),
            state.getRemainingLives()
        );
    }
}
