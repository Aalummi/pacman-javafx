package projectpacman.GhostLogic;


/*
 * Represents a predefined spawn point for a specific ghost on the game board.
 * This class encapsulates the ghost's type and its starting coordinates.
 */
public class GhostSpawn {
    private final Ghost ghost;
    private final int row;
    private final int col;

    /**
     * Constructs a new ghost instance with the specified ghost type, eg blinky, pinky etc.
     * and its initial board coordinates.
     *
     * @param ghost Representing the type of ghost to be spawned.
     * @param row   The row index (Y-coordinate) where the ghost should initially appear.
     * @param col   The column index (X-coordinate) where the ghost should initially appear.
     */
    public GhostSpawn(Ghost ghost, int row, int col) {
        this.ghost = ghost;
        this.row = row;
        this.col = col;
    }

    public Ghost getGhost() {
        System.out.println("(GhostSpawn.java): Requested ghost for " + ghost.getGhostname());
        return ghost;
    }

    public int getRow() {
        System.out.println("(GhostSpawn.java): Requested row for ghost: " + ghost.getGhostname() +  " At row " + row);
        return row;
    }

    public int getCol() {
        System.out.println("(GhostSpawn.java): Requested column for ghost: " + ghost.getGhostname() +  " At row " + row);
        return col;
    }
}
