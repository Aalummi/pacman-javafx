package projectpacman.GhostLogic.GhostStates;

import projectpacman.GameLogic.Direction;
import projectpacman.GhostLogic.GhostEntity;
import projectpacman.GhostLogic.GhostNavigator;

/**
 * Default movement state for ghosts after they leave the ghost box.
 * In this state, the ghost follows its target using its assigned chase or flee logic.
 * Ghosts are not allowed to re-enter the ghost box once they have exited.
 */
public class RoamingState implements GhostState {
    @Override
    public void update(GhostEntity ghost, double dt) {
        // If ghost is centered and has a target, pick a new direction
        if (ghost.isCenteredInTile() && ghost.getTarget() != null) {
            Direction newDir = GhostNavigator.chooseDirection(ghost, ghost.getTarget());
            // Avoid reversing direction
            if (newDir != Direction.IDLE && newDir != ghost.getDirection().opposite()) {
                ghost.setDirection(newDir);
            }
        }
        // Move based on current direction
        ghost.moveInCurrentDirection(dt);
    }

    @Override
    public String getName() {
        return "CHASE";
    }

    @Override
    public boolean canMoveTo(GhostEntity ghost, int nextRow, int nextCol, char nextTile, char currentTile) {
        if (ghost.hasExitedBox()) {
            // If ghost is trying to enter a door OR is already in one and tries to stay/move inside
            if (nextTile == 'D' || currentTile == 'D') {
                return false;
            }
        }
    
        return nextTile != '1'; // block walls
    }
    

}