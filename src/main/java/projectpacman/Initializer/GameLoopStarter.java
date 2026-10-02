package projectpacman.Initializer;

import projectpacman.GameLogic.GameTime;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GameLogic.GameLoop;

/**
 * Starts the game loop, used after everything else has been initialized in GameStarter
 */
public class GameLoopStarter {
    public static void start() {
        GameTime.startGameTime();
        new GameLoop(CurrentGame.getInstance()).start();
    }
}

