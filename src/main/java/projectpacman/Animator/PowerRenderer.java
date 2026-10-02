package projectpacman.Animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import projectpacman.Board.boardSettings;

/**
 * The PelletRenderer class is responsible for rendering the power layer of the game.
 * It animates powers at a slower frame rate compared to other game elements.
 * 
 * PelletRenderer is used in the class SceneRenderer to render the power layer of the game.
 */
public class PowerRenderer extends AnimatedLayerRenderer {
    private final boardAnimator animator = new boardAnimator();

    /**
     * Constructor for PowerRenderer.
     * 
     * @param gc The GraphicsContext used for rendering the power tiles.
     * getPelletPowerFrameDelay() used to slow down the frame rate of power tiles. 
     * Can be changed in animationSettings.
     */
    public PowerRenderer(GraphicsContext gc) {
        super(gc, animationSettings.getPelletPowerFrameDelay());
    }

    /**
     * Retrieves the image for the current animation frame of a power at the specified position.
     *
     * @param col the column index of the power.
     * @param row the row index of the power.
     * @return the Image representing the current animation frame of the power.
     */
    @Override
    protected Image frameImage_Idle(int col, int row) {
        return animator.animatePower(col, row);
    }

    //Determins if a tile mathes a power.
    @Override
    protected boolean matches(char tile) {
        return tile == '3';
    }

    @Override
    protected int getEntitySize() {
        return boardSettings.get_Power_size();
    }


    @Override
    protected Image frameImage_R(int col, int row) {
        return animator.animatePower(col, row);
    }

    @Override
    protected Image frameImage_L(int col, int row) {
        return animator.animatePower(col, row);
    }

    @Override
    protected Image frameImage_U(int col, int row) {
        return animator.animatePower(col, row);
    }

    @Override
    protected Image frameImage_D(int col, int row) {
        return animator.animatePower(col, row);
    }
}