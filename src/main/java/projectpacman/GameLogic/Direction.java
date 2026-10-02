package projectpacman.GameLogic;

/**
 * Represents the possible movement directions for entities in the game.
 */
public enum Direction {
    UP, DOWN, LEFT, RIGHT, IDLE;

    /**
     * Returns the opposite of the current direction.
     * Used by ghosts to disallow them going in the opposite direction (Dosent work correctly rn)
     */
    public Direction opposite() {
        switch (this) {
            case UP: return DOWN;
            case DOWN: return UP;
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case IDLE: default: return IDLE;
        }
    }

    /**
    * Used by GhostNavigator to calculate next row left/right for finding way to pacman
    * @return -1 for LEFT, 1 for RIGHT, 0 otherwise.
    */
    public int dx() {
        switch (this) {
            case LEFT: return -1;
            case RIGHT: return 1;
            default: return 0;
        }
    }

    /**
    * Used by GhostNavigator to calculate next row up/down for finding way to pacman
    * @return -1 for UP, 1 for DOWN, 0 otherwise.
    */
    public int dy() {
        switch (this) {
            case UP: return -1;
            case DOWN: return 1;
            default: return 0;
        }
    }
}