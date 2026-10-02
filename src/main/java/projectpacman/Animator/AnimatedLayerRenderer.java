package projectpacman.Animator;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.GameTime;

/**
 * Abstract class for rendering animated layers in the game.
 * This class handles the logic for rendering entities, 
 * on the game board using sprite sheets and animation frames.
 */
public abstract class AnimatedLayerRenderer implements LayerRenderer {
    //GraphicsContext used for rendering on the canvas
    protected  GraphicsContext graphicsContent;

    //Artificially slow down the frame rate of pellets and powers.
    private final int frameDelay;
    
    //Settings for calculating the size of the spritesheet, loaded from animationSettings.
    private static final int 
    COLS = animationSettings.columns_per_spritesheet(), 
    ROWS = animationSettings.rows_per_spritesheet(),
    TOTAL = COLS * ROWS;

    /**
     * Constructers for AnimatedLayerRenderer.
     * 
     * @param graphicsContent The GraphicsContext used for rendering.
     * @param frameDelay The delay between animation frames in milliseconds.
     */
    protected AnimatedLayerRenderer(GraphicsContext graphicsContent, int frameDelay) {
        this.graphicsContent = graphicsContent;
        this.frameDelay = frameDelay;
    }

    /**
     * Abstract Methods to recive the cut frames to render animations
     * 
     * Pellets and powers only use Idle as they are (dancing)
     * Player and Ghosts use directional frames
    */    
    protected abstract Image frameImage_Idle(int col, int row);
    protected abstract Image frameImage_R(int col, int row);
    protected abstract Image frameImage_L(int col, int row);
    protected abstract Image frameImage_U(int col, int row);
    protected abstract Image frameImage_D(int col, int row);

    //abstract method to check if the given tile matches the entity type.
    protected abstract boolean matches(char tile);

    //abstract method to get the size of the entity.
    protected abstract int getEntitySize();

    @Override
    public void render(List<String> levelData) {
        //Calculate the current frame based on the elapsed time and the extra frame delay.
        int frame = (int)(GameTime.getElapsedTimeMillis() / frameDelay) % TOTAL;
        int row   = frame / COLS;
        int col   = frame % COLS;

        //Get the size of the blocks from boardSettings, used to calculate correct position.
        int block = boardSettings.get_Block_size();

        //calculate the number of rows and columns in the level data
        int rows = levelData.size();
        int cols = levelData.get(0).length();

        //clear the graphics context for the current frame
        graphicsContent.clearRect(0, 0, cols * block, rows * block);

        int size  = getEntitySize();

        //Iterate through the level data and render the entities
        //using the frameImage method to get the correct image for the current frame.
        for (int y = 0; y < levelData.size(); y++) {
            char[] rowChars = levelData.get(y).toCharArray();
            for (int x = 0; x < rowChars.length; x++) {
                if (matches(rowChars[x])) {
                    int diff_x = x * block + (block - size) / 2;
                    int diff_Y = y * block + (block - size) / 2;

                    //Draw the current animation frame on the calculated position
                    graphicsContent.drawImage(frameImage_Idle(col, row), diff_x, diff_Y, size, size);
                }
            }
        }
    }
}