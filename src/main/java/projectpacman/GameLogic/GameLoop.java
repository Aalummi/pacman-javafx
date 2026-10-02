package projectpacman.GameLogic;

import javafx.animation.AnimationTimer;

/**
 * GameLoop updates the time and updates the game
 */
public class GameLoop extends AnimationTimer {
    private final CurrentGame current_Game;

    public GameLoop(CurrentGame current_Game) {
        this.current_Game = current_Game;
    }

    @Override
    public void handle(long now) {
        GameTime.updateDeltaTime(); 
        current_Game.updateGame();
    }
}