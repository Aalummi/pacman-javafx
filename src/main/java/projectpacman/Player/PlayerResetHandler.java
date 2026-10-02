package projectpacman.Player;

import javafx.geometry.Point2D;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.Direction;

/**
 * Handles resetting the player to the starting position. 
 * Used in the EntityManager class for when pacman looses a life
 */
public class PlayerResetHandler {
    private final int blockSize;

    public PlayerResetHandler() {
        this.blockSize = boardSettings.get_Block_size();
    }

    public void resetPlayer(PlayerEntity player, int row, int col) {
        Point2D startPosition = new Point2D(
            col * blockSize + blockSize / 2.0,
            row * blockSize + blockSize / 2.0
        );
        player.setPosition(startPosition);
        player.setDirection(Direction.IDLE);
        player.setQueuedDirection(Direction.IDLE);
        player.setFacingDirection(Direction.RIGHT);

        System.out.println("(PlayerResetHandler): Reset pacman to : (" + row + ", " + col + ")");
    }
}
