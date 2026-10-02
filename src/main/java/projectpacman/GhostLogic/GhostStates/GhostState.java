package projectpacman.GhostLogic.GhostStates;

import projectpacman.GhostLogic.GhostEntity;

public interface GhostState {
    void update(GhostEntity ghost, double dt);
    String getName();

    default boolean canMoveTo(GhostEntity ghost, int nextRow, int nextCol, char nextTile, char currentTile) {
        // Default rule: can't walk into walls
        return nextTile != '1';
    }
    
}


