package projectpacman.GhostLogic.GhostStates;

import projectpacman.GhostLogic.GhostEntity;

/**
 * State where the ghost waits inside the ghost box before exiting.
 * The ghost stays in the box for a short delay, then switches to ExitingBoxState.
 */
public class InBoxState implements GhostState {
    @Override
    public void update(GhostEntity ghost, double dt) {
        ghost.decreaseDelayTimer(dt);

       // When delay finishes, begin exiting the box
        if (ghost.getDelayTimer() <= 0) {
            ghost.setState(new ExitingBoxState());
            System.out.println("(GhostEntity): " + ghost.getName() + " is now EXITING_BOX");
        }
    }

    @Override
    public String getName() {
        return "IN_BOX";
    }

    // Only allow movement on door tiles (within or out of the ghost house)
    @Override
    public boolean canMoveTo(GhostEntity ghost, int nextRow, int nextCol, char nextTile, char currentTile) {
    return nextTile == 'D' || currentTile == 'D'; // Only allow moving within/into door tiles
    }

}
