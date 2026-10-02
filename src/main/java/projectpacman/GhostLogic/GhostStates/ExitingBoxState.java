package projectpacman.GhostLogic.GhostStates;

import javafx.geometry.Point2D;
import projectpacman.GhostLogic.GhostEntity;
import projectpacman.GameLogic.Direction;
import projectpacman.GhostLogic.GhostNavigator;

/**
 * State where a ghost exits the ghost box in two steps:
 * 1. Move to the door tile.
 * 2. Move just outside the door (box exit).
 * After exiting, the ghost switches to RoamingState.
 */
public class ExitingBoxState implements GhostState {
    private int exitStep = 0;  // 0 = go to door, 1 = go to exit point

    @Override
    public void update(GhostEntity ghost, double dt) {
        Point2D targetPos = null;

        // Step 0: move toward the door
        if (exitStep == 0) {
            targetPos = ghost.tileCenter(ghost.getDoorRow(), ghost.getDoorCol());

            if (ghost.getPosition().distance(targetPos) < 2.0) {
                exitStep = 1;
            }
        }
        // Step 1: move to the exit point outside the box
        if (exitStep == 1) {
            targetPos = ghost.getBoxExit();

            if (ghost.getPosition().distance(targetPos) < 2.0) {
                ghost.setState(new RoamingState());
                ghost.setHasExitedBox(true);
                System.out.println("(ExitingBoxState.java): " + ghost.getName() + " exited the box and is now roaming.");
                return;
            }
        }

        // Choose new direction if centered in tile
        if (targetPos != null && ghost.isCenteredInTile()) {
            Direction newDir = GhostNavigator.chooseDirection(ghost, targetPos);

            if (newDir != Direction.IDLE && newDir != ghost.getDirection().opposite()) {
                ghost.setDirection(newDir);
            }
        }

        ghost.moveInCurrentDirection(dt);
    }

    @Override
    public String getName() {
        return "EXITING_BOX";
    }

    // Allow moving through anything except walls
    @Override
    public boolean canMoveTo(GhostEntity ghost, int nextRow, int nextCol, char nextTile, char currentTile) {
    return nextTile != '1'; // allow doors and paths
    }

}
