package projectpacman.Player;

import java.util.List;
import javafx.geometry.Point2D;
import projectpacman.GameLogic.GameState;
import projectpacman.Board.boardSettings;

/**
 * PlayerConsume checks the levelData for consumable tiles,
 * Used in GameUpdater to make the player eat the edible tiles
 */
public class PlayerConsume {
    private final List<String> levelData;
    private final int blockSize;

    public PlayerConsume(List<String> levelData) {
        this.levelData = levelData;
        this.blockSize = boardSettings.get_Block_size();
    }

    public void checkAndConsume(PlayerEntity player) {
        Point2D position = player.getPosition();
        int row = (int)(position.getY() / blockSize);
        int col = (int)(position.getX() / blockSize);

        if (row < 0 || row >= levelData.size() || col < 0 || col >= levelData.get(0).length()) {
            return; // Prevent out-of-bounds
        }

        char ch = levelData.get(row).charAt(col);
        if (ch == '2' || ch == '3') {
            if (ch == '2') {
                GameState.getInstance().addScore(10);
                GameState.getInstance().subtract_pellet_count();
            } else {
                GameState.getInstance().addScore(50);
                GameState.getInstance().startPowerState();
            }

            replaceLevelChar(row, col, '0');        //Removes the eaten pellet/power

            System.out.println("(TileConsumer): Consumed " + (ch == '2' ? "Pellet" : "Power") +
                    " at (" + row + ", " + col + ") - Score: " + GameState.getInstance().getScore());
        }
    }

    private void replaceLevelChar(int row, int col, char replacement) {
        char[] chars = levelData.get(row).toCharArray();
        chars[col] = replacement;
        levelData.set(row, new String(chars));
    }
}
