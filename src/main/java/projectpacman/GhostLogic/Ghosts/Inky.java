package projectpacman.GhostLogic.Ghosts;

import javafx.geometry.Point2D;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GameLogic.Direction;
import projectpacman.GhostLogic.ChaseMethod;
import projectpacman.GhostLogic.FleeMethod;
import projectpacman.GhostLogic.Ghost;

/**
 * Clyde is the cyan colored ghost! It can be spawned in the level file with the identifier 'I'
 */
public class Inky {
    public static Ghost create() {
        return Ghost.Builder()
            .setGhostName("Inky")
            .setChaseMethod(new InkyChase())
            .setFleeMethod(new InkyFlee())
            .setGhostDelay(4000)
            .build();
    }

    //           v          The unique methods for inky             v             //


    private static class InkyChase extends ChaseMethod {
        @Override
        public void chase() {
            Direction playerDirection = CurrentGame.getInstance().getPlayer().getFacingDirection();
            Point2D target = CurrentGame.getInstance().getPlayer().getPosition();

            ghostEntity.setTarget(target);

        }
    }

    private static class InkyFlee extends FleeMethod {
        @Override
        public void flee() {
            int boardRows = CurrentGame.getInstance().getBoard().getRows();
            int boardCol = CurrentGame.getInstance().getBoard().getColumns();
            ghostEntity.setTarget(new Point2D(boardRows, boardCol));
        }
    }
}
