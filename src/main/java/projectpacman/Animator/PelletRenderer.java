package projectpacman.Animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import projectpacman.Board.boardSettings;

/**
 * The PelletRenderer class is responsible for rendering the pellet layer of the game.
 * It animates pellets at a slower frame rate compared to other game elements.
 * 
 * PelletRenderer is used in the class SceneRenderer to render the pellet layer of the game.
 */
public class PelletRenderer extends AnimatedLayerRenderer {
    private final boardAnimator animator = new boardAnimator();

    /**
     * Constructor for PelletRenderer.
     * 
     * @param gc The GraphicsContext used for rendering the pellets.
     * getPelletPowerFrameDelay() used to slow down the frame rate of pellets. can be changed in animationSettings.
     */
    public PelletRenderer(GraphicsContext gc) {
        super(gc, animationSettings.getPelletPowerFrameDelay());
    }

    /**
     * Retrieves the image for the current animation frame of a pellet at the specified position.
     *
     * @param col the column index of the pellet
     * @param row the row index of the pellet
     * @return the Image representing the current animation frame of the pellet
     */
    @Override
    protected Image frameImage_Idle(int col, int row) {
        return animator.animatePellet(col, row);
    }

    //Determins if a tile mathes a pellet.
    @Override
    protected boolean matches(char tile) {
        return tile == '2';
    }

    @Override
    protected int getEntitySize() {
        return boardSettings.get_Pellet_size();
    }


    /*
     * Not in use for pellets
     */
    @Override
    protected Image frameImage_R(int col, int row) {
        return frameImage_Idle(col, row);
    }
    @Override
    protected Image frameImage_L(int col, int row) {
        return frameImage_Idle(col, row);
    }
    @Override
    protected Image frameImage_U(int col, int row) {
        return frameImage_Idle(col, row);
    }
    @Override
    protected Image frameImage_D(int col, int row) {
        return frameImage_Idle(col, row);
    }
}