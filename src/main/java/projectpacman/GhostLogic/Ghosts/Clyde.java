package projectpacman.GhostLogic.Ghosts;

import javafx.geometry.Point2D;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GhostLogic.ChaseMethod;
import projectpacman.GhostLogic.FleeMethod;
import projectpacman.GhostLogic.Ghost;

/**
 * Clyde is the orange colored ghost! It can be spawned in the level file with the identifier 'C'
 */
public class Clyde {
    public static Ghost create() {
        return Ghost.Builder()
            .setGhostName("Clyde")
            .setChaseMethod(new ClydeChase())
            .setFleeMethod(new ClydeFlee())
            .setGhostDelay(2000)
            .build();
    }

    //           v          The unique methods for Clyde             v             //

    private static class ClydeChase extends ChaseMethod {
        @Override
        public void chase() {

        Point2D target = CurrentGame.getInstance().getPlayer().getPosition();
        int boardRows = CurrentGame.getInstance().getBoard().getRows();

        if(ghostEntity.getPosition().distance(target) > (boardSettings.get_Block_size() * 8)) {
            ghostEntity.setTarget(target);
        } else {
            ghostEntity.setTarget(new Point2D(boardRows * boardSettings.get_Block_size(), 0));
        }
        }
    }

    private static class ClydeFlee extends FleeMethod {
        @Override
        public void flee() {
            int boardRows = CurrentGame.getInstance().getBoard().getRows();
            ghostEntity.setTarget(new Point2D(boardRows, 0));

        }
    }
}
