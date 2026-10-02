package projectpacman.GhostLogic;

import javafx.geometry.Point2D;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.Direction;

/**
 * Ghost Navigator handles choosing the best direction for the ghosts to move towards their target
 */
public class GhostNavigator {
    public static Direction chooseDirection(GhostEntity ghost, Point2D target) {
        int row = (int)(ghost.getPosition().getY() / boardSettings.get_Block_size());
        int col = (int)(ghost.getPosition().getX() / boardSettings.get_Block_size());

        double closest = Double.MAX_VALUE;
        Direction best = Direction.IDLE;

        for (Direction dir : Direction.values()) {
            if (dir == Direction.IDLE || dir == ghost.getDirection().opposite()) continue;

            int nextRow = row + dir.dy();
            int nextCol = col + dir.dx();

            if (ghost.canMoveTo(nextRow, nextCol)) {
                double centerX = nextCol * boardSettings.get_Block_size() + boardSettings.get_Block_size() / 2.0;
                double centerY = nextRow * boardSettings.get_Block_size() + boardSettings.get_Block_size() / 2.0;
                double distance = target.distance(centerX, centerY);

                if (distance < closest) {
                    closest = distance;
                    best = dir;
                }
            }
        }
        return best;
    }
}
