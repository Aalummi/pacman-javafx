package projectpacman.Initializer;

import javafx.scene.canvas.Canvas;
import projectpacman.Board.Board;
import projectpacman.Board.boardSettings;
import projectpacman.InfoBanner;

/**
 * Canvas Initializer builds the canvases for the game
 */
public class CanvasInitializer {
    private final int width, height;

    /**
     * Canvas Initializer calculates how large the canvas should be, to corectly display any given
     * level file, for any blocksize
     * 
     * @param blocksize // (How many pixels each tile is)
     * @param getColumns() Finds how many columns there are in the level file
     * @param getRows() Finds how many rows there are in the level file
     */
    public CanvasInitializer(Board board) {
        int block = boardSettings.get_Block_size();
        this.width = board.getColumns() * block;
        this.height = board.getRows() * block + InfoBanner.getVerticalBuffer();
    }

    // We make a canvas for each type of object (Walls, Pellets, Powers, Player, Ghost)
    public CanvasLayers createCanvases() {
        int canvasHeight = height - InfoBanner.getVerticalBuffer();
        return new CanvasLayers(
            new Canvas(width, canvasHeight),
            new Canvas(width, canvasHeight),
            new Canvas(width, canvasHeight),
            new Canvas(width, canvasHeight),
            new Canvas(width, canvasHeight)
        );
    }
}
