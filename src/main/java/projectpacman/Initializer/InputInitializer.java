package projectpacman.Initializer;

import projectpacman.GameLogic.Direction;
import projectpacman.Player.PlayerEntity;
import javafx.scene.Scene;

/**
 * InputInitializer maps the arrow buttons as game controls for the player to move
 * 
 * Added support for arrow controlls and WASD controlls like a more modern game
 */
public class InputInitializer {
    public static void setupControls(Scene scene, PlayerEntity player) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                case W:
                    player.setQueuedDirection(Direction.UP);
                    break;
                case DOWN:
                case S:
                    player.setQueuedDirection(Direction.DOWN);
                    break;
                case LEFT:
                case A:
                    player.setQueuedDirection(Direction.LEFT);
                    break;
                case RIGHT:
                case D:
                    player.setQueuedDirection(Direction.RIGHT);
                    break;
                default:
                    break;
            }
        });
    }
}

