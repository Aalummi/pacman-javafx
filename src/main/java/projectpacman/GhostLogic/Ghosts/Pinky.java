package projectpacman.GhostLogic.Ghosts;

import javafx.geometry.Point2D;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GameLogic.Direction;
import projectpacman.GhostLogic.ChaseMethod;
import projectpacman.GhostLogic.FleeMethod;
import projectpacman.GhostLogic.Ghost;

/**
 * Blinky is the pink colored ghost! It can be spawned in the level file with the identifier 'K'
 */
public class Pinky {
    public static Ghost create() {
        return Ghost.Builder()
            .setGhostName("Pinky")
            .setChaseMethod(new PinkyChase())
            .setFleeMethod(new PinkyFlee())
            .setGhostDelay(6000)
            .build();
    }

    //           v          The unique methods for Pinky             v             //

    private static class PinkyChase extends ChaseMethod {

        /**
         * Pinky's chase method calculates ahead of pacman, and tries to ambush the player from the front
         */
        @Override
        public void chase() {

        Direction playerDirection = CurrentGame.getInstance().getPlayer().getFacingDirection();
        Point2D target = CurrentGame.getInstance().getPlayer().getPosition();
        double targetX = target.getX();
        double targetY = target.getY();
        int blockSize = boardSettings.get_Block_size();

        switch (playerDirection) {

            case UP:
                targetY = targetY - (blockSize * 4);
                target = new Point2D(targetX, targetY);
                break;
            case DOWN:
                targetY = targetY + (blockSize * 4);
                target = new Point2D(targetX, targetY);
                break;
            case LEFT:
                targetX = targetX - (blockSize * 4);
                target = new Point2D(targetX, targetY);
                break;
            case RIGHT:
                targetX = targetX + (blockSize * 4);
                target = new Point2D(targetX, targetY);
                break;
            default:
                target = CurrentGame.getInstance().getPlayer().getPosition();
        }

        ghostEntity.setTarget(target);
        }
    }

    private static class PinkyFlee extends FleeMethod {
        @Override
        public void flee() {
            int boardCol = CurrentGame.getInstance().getBoard().getColumns();
            ghostEntity.setTarget(new Point2D(0, boardCol));
        }
    }
}
