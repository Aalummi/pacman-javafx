package projectpacman.Initializer;

import projectpacman.Board.Board;
import projectpacman.GameSettings;

import java.io.IOException;

/*
 * Helper class used to initialize the gameboard
 */
public class BoardInitializer {
    public Board loadBoard() throws IOException {
        GameSettings settings = GameSettings.getInstance();
        Board board = new Board(settings.selected_level);
        settings.board = board;
        return board;
    }
}

