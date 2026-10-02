package projectpacman.GhostLogic.Ghosts;

import javafx.geometry.Point2D;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GhostLogic.ChaseMethod;
import projectpacman.GhostLogic.FleeMethod;
import projectpacman.GhostLogic.Ghost;

/**
 * Blinky is the red ghost. It is created with the builder, and implements its own chase and flee methods
 */
public class Blinky {
    public static Ghost create() {
        return Ghost.Builder()
            .setGhostName("Blinky")
            .setChaseMethod(new BlinkyChase())
            .setFleeMethod(new BlinkyFlee())
            .setGhostDelay(0)
            .build();
    }

    /**
     * Aggressivly targets the exact position of pacman
     */
    private static class BlinkyChase extends ChaseMethod {
        @Override
        public void chase() {
            Point2D target = CurrentGame.getInstance().getPlayer().getPosition();
            ghostEntity.setTarget(target);
        }
    }
    
    /**
     * Blinky targets top left row
     */
    private static class BlinkyFlee extends FleeMethod {
        @Override
        public void flee() {
            ghostEntity.setTarget(new Point2D(0, 0));
        }
    }
}
