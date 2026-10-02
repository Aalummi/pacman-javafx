package projectpacman.Initializer;

import java.util.List;

import projectpacman.Board.Board;
import projectpacman.Player.PlayerEntity;
import projectpacman.Player.PlayerMovement;

/**
 * Player initializer handles setting up the player
 */
public class PlayerInitializer {
    private final Board board;

    public PlayerInitializer(Board board) {
        this.board = board;
    }

    public PlayerEntity createPlayer() {
        int row = board.getPacmanStartRow();
        int col = board.getPacmanStartColumn();
        List<String> levelData = board.getLevelData();
        PlayerMovement movementController = new PlayerMovement(levelData);

        return new PlayerEntity(row, col, levelData, movementController);
    }
}

