package projectpacman.GhostLogic;

import javafx.geometry.Point2D;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GameLogic.Direction;
import projectpacman.GameLogic.GameMode;
import projectpacman.GameLogic.GameState;
import projectpacman.GameLogic.MovableEntity;
import projectpacman.GameLogic.GameTime;
import projectpacman.Animator.boardAnimator;
import projectpacman.Board.boardSettings;
import projectpacman.GhostLogic.GhostStates.GhostState;
import projectpacman.GhostLogic.GhostStates.InBoxState;

import java.util.List;

/**
 * Represents a ghost entity in the game.
 * 
 * A GhostEntity handles its own position, direction, movement, and AI state.
 * It uses a state system (InBox, ExitingBox, Roaming, etc.) to control its behavior,
 * and interacts with the level through tile-based navigation by setting a target with (GhostNavigator).
 * 
 */
public class GhostEntity extends MovableEntity {
    private final Ghost ghost;
    private final double speed;
    private Point2D position;
    private Direction direction = Direction.IDLE;
    private Point2D target;
    private GhostState state;
    private final int startRow, startCol;
    private final Point2D boxExit;
    private double delayTimer;
    private int doorRow, doorCol;
    private boolean hasExitedBox = false;

    public GhostEntity(Ghost ghost, int startRow, int startCol, List<String> levelData, int blockSize) {
        super(startRow, startCol, levelData);
        this.ghost = ghost;
        this.startRow = startRow;
        this.startCol = startCol;
        this.speed = blockSize * 4;
        this.position = tileCenter(startRow, startCol);
        this.boxExit = new Point2D(14 * blockSize + blockSize / 2.0, 11 * blockSize + blockSize / 2.0);
        this.delayTimer = ghost.getGhostDelay() / 1000.0;
        this.state = new InBoxState();

        // Connect ghost AI behaviors to this entity
        ghost.getChaseMethod().setEntity(this);
        ghost.getFleeMethod().setEntity(this);
    }
    
    /**
     * Updates the ghost's position based on its current state logic.
     */
    @Override
    public void UpdatePosition() {
        double dt = GameTime.getDeltaTimeSeconds();
        state.update(this, dt);
    }

    public void moveInCurrentDirection(double dt) {
        double moveDist = speed * dt;
        double dx = 0, dy = 0;

        switch (direction) {
            case UP: dy = -moveDist; break;
            case DOWN: dy = moveDist; break;
            case LEFT: dx = -moveDist; break;
            case RIGHT: dx = moveDist; break;
            default: break;
        }

        Point2D newPos = position.add(dx, dy);
        int row = pixelToRow(newPos);
        int col = pixelToCol(newPos);

        if (canMoveTo(row, col)) {
            position = newPos;
        } else if (canWarpTo(row, col)) {
            position = warpmove(row, col);
        }
    }

    /**
     * Determines if the ghost can move to the specified tile.
     * The current GhostState decides the movement rules (e.g., can it pass through doors).
     */
    @Override
    public boolean canMoveTo(int nextRow, int nextCol) {
        if (nextRow < 0 || nextRow >= levelData.size()) return false;
        if (nextCol < 0 || nextCol >= levelData.get(nextRow).length()) return false;

        char nextTile = levelData.get(nextRow).charAt(nextCol);
        char currentTile = levelData.get(this.row).charAt(this.column);

        return state.canMoveTo(this, nextRow, nextCol, nextTile, currentTile);
    }
    
    /**
     * Resets the ghost to its starting position and state (InBox).
     */
    public void resetToStart() {
        this.row = startRow;
        this.column = startCol;
        this.direction = Direction.IDLE;
        this.position = tileCenter(startRow, startCol);
        this.state = new InBoxState();
        this.delayTimer = ghost.getGhostDelay() / 1000.0;
        this.hasExitedBox = false;

        System.out.println("(GhostEntity): " + getName() + " reset to (" + startRow + ", " + startCol + ")");
    }


    public boolean isCollidingWithPlayer() {
        Point2D playerPos = CurrentGame.getInstance().getPlayer().getPosition();
        double collisionRadius = boardSettings.get_Block_size() * 0.8; //Can make the radius larger or smaller
        return position.distance(playerPos) < collisionRadius;
    }

    public void updateGhostMode() {
        if (GameState.getInstance().getMode() == GameMode.POWER) {
            ghost.getFleeMethod().flee();
        } else {
            ghost.getChaseMethod().chase();
        }

    }

    // --- Getters / Setters / Other Logic ---
    public void setState(GhostState state) { 
        this.state = state; 
    }

    public String getName() { 
        return ghost.getGhostname(); 
    }

    public Point2D getPosition() { 
        return position; 
    }

    public void setTarget(Point2D target) { 
        this.target = target; 
    }

    public Point2D getTarget() { 
        return target; 
    }

    public Direction getDirection() { 
        return direction; 
    }

    public void setDirection(Direction dir) { 
        this.direction = dir; 
    }

    public Point2D getBoxExit() { 
        return boxExit; 
    }

    public boolean isCenteredInTile() {
        double size = boardSettings.get_Block_size();
        double offsetX = Math.abs(position.getX() % size - size / 2.0);
        double offsetY = Math.abs(position.getY() % size - size / 2.0);
        return offsetX < 1 && offsetY < 1;
    }

    public Point2D tileCenter(int row, int col) {
        int size = boardSettings.get_Block_size();
        return new Point2D(col * size + size / 2.0, row * size + size / 2.0);
    }

    public void setDoorPosition(int row, int col) {
        this.doorRow = row;
        this.doorCol = col;
    }

    public int getDoorRow() { 
        return doorRow; 
    }
    public int getDoorCol() { 
        return doorCol; 
    }

    public double getDelayTimer() { 
        return delayTimer; 
    }
    public void decreaseDelayTimer(double dt) { 
        delayTimer -= dt; 
    }

    public boolean hasExitedBox() { 
        return hasExitedBox; 
    }

    public void setHasExitedBox(boolean hasExited) { 
        this.hasExitedBox = hasExited; 
    }
}
