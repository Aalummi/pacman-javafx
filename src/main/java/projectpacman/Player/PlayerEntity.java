package projectpacman.Player;

import java.util.List;

import javafx.geometry.Point2D;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.Direction;
import projectpacman.GameLogic.MovableEntity;

/**
 * The PlayerEntity class stores the state of the player: 
 * 
 *  1. Player position, 
 *  2. Current movement direction
 *  3. Facing direction (for rendering).
 * 
 *  The class provides a basic API with setPosition and updatePosition
 */
public class PlayerEntity extends MovableEntity {
    private Point2D position;
    private Direction direction = Direction.IDLE;
    private Direction queuedDirection = Direction.IDLE;
    private Direction facingDirection = Direction.RIGHT;

    private PlayerMovement movementController;


    public PlayerEntity(int row, int col, List<String> levelData, PlayerMovement movementController) {
        super(row, col, levelData);
        this.movementController = movementController;
        this.position = new Point2D(
            col * boardSettings.get_Block_size() + boardSettings.get_Block_size() / 2.0,
            row * boardSettings.get_Block_size() + boardSettings.get_Block_size() / 2.0
        );
    }
    

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getQueuedDirection() {
        return queuedDirection;
    }

    public void setQueuedDirection(Direction queuedDirection) {
        this.queuedDirection = queuedDirection;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    @Override
    public void UpdatePosition() {
        movementController.updatePosition(this);
    }
    
}
