package projectpacman.GhostLogic;

import projectpacman.GhostLogic.Ghosts.Blinky;
import projectpacman.GhostLogic.Ghosts.Clyde;
import projectpacman.GhostLogic.Ghosts.Inky;
import projectpacman.GhostLogic.Ghosts.Pinky;

/**
 * Ghost factory that is used for creating ghosts when they are found in board parser
 */
public class GhostFactory {
    public static Ghost createGhost(char ghostChar) {
        switch (Character.toUpperCase(ghostChar)) {
            case 'B':
                return Blinky.create();
            case 'K':
                return Pinky.create();
            case 'I':
                return Inky.create();
            case 'C':
                return Clyde.create();
            default:
                return null;
        }
    }
}
