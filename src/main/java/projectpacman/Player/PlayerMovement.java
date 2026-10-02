package projectpacman.Player;

import javafx.geometry.Point2D;

import java.util.List;

import projectpacman.GameLogic.Direction;
import projectpacman.GameLogic.GameTime;
import projectpacman.Board.boardSettings;


/**
 * PlayerMovement controls how the player moves on the board. Handles player :
 *
 * 1. queued turns,
 * 2. movement updates,
 * 3. collision detection.
 *
 */
public class PlayerMovement {
    private final int blockSize;
    private final double baseSpeed;

    public PlayerMovement(List<String> levelData) {
        this.blockSize = boardSettings.get_Block_size();
        this.baseSpeed = blockSize * 5;
    }

    /**
     * The main method of PlayerMovement, the method controls a static player entity in a active game
     * and updates the position along the current direction the player is facing, if valid
     */
    public void updatePosition(PlayerEntity player) {
        Point2D position = player.getPosition();
        double deltaTime = GameTime.getDeltaTimeSeconds();
        double scaledSpeed = baseSpeed * deltaTime;

        // Use player's methods to convert pixel to row/column
        int currentRow = player.pixelToRow(position);
        int currentCol = player.pixelToCol(position);

        Direction queued = player.getQueuedDirection();
        Direction current = player.getDirection();

        // Attempt to turn toward queued direction if it's a valid move
        if (queued != Direction.IDLE && queued != current) {
            int tryRow = currentRow + deltaRow(queued);
            int tryCol = currentCol + deltaCol(queued);

            // Use player's canMoveTo and canWarpTo from MovableEntity
            if (player.canMoveTo(tryRow, tryCol)) {
                player.setDirection(queued);
                player.setFacingDirection(queued);
                // Clear the queued direction once it's acted upon
                player.setQueuedDirection(Direction.IDLE);
            } else if (player.canWarpTo(tryRow, tryCol)){ // Use else if for mutually exclusive checks
                player.setDirection(queued);
                player.setFacingDirection(queued);
                // Clear the queued direction for warping too
                player.setQueuedDirection(Direction.IDLE);
            }
        }

        // Move in the current direction
        Point2D delta = directionToDelta(player.getDirection(), scaledSpeed);
        Point2D next = position.add(delta);

        // Use player's methods to convert pixel to row/column for the next position
        int nextRow = player.pixelToRow(next);
        int nextCol = player.pixelToCol(next);

        // Uses the player's canMoveTo method to test if the next row and column would be valid
        if (player.canMoveTo(nextRow, nextCol)) {
            player.setPosition(next);
        } else {
            // Use player's canWarpTo and warpmove methods
            if(player.canWarpTo(nextRow, nextCol)){
                Point2D warp = player.warpmove(nextRow, nextCol);
                player.setPosition(warp);
            }
            // If not warpable either, player stops at the wall.
        }
    }

    /**
     * Converts a direction and movement speed into a 2D movement vector.
     */
    private Point2D directionToDelta(Direction dir, double speed) {
        switch (dir) {
            case UP: return new Point2D(0, -speed);
            case DOWN: return new Point2D(0, speed);
            case LEFT: return new Point2D(-speed, 0);
            case RIGHT: return new Point2D(speed, 0);
            default: return Point2D.ZERO;
        }
    }

    /**
     * Returns the vertical offset (row change) for a given direction.
     * Used when trying to change direction for up and down
     */
    private int deltaRow(Direction dir) {
        switch (dir) {
            case UP: return -1;
            case DOWN: return 1;
            default: return 0;
        }
    }

    /**
     * Returns the horizontal offset (column change) for a given direction.
     * Used when trying to change direction for right and left
     */
    private int deltaCol(Direction dir) {
        switch (dir) {
            case LEFT: return -1;
            case RIGHT: return 1;
            default: return 0;
        }
    }

}