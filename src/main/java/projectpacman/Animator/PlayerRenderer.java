package projectpacman.Animator;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.Direction;
import projectpacman.GameLogic.GameTime;
import projectpacman.Player.PlayerEntity;



/**
 * The PlayerRenderer class is responsible for rendering the player character in the game.
 * We get the animation frames when we call boardAnimator.
 * 
 * PlayerRenderer is used in the class SceneRenderer to render the player character on the screen.
 */

public class PlayerRenderer extends AnimatedLayerRenderer {
    private final boardAnimator animator = new boardAnimator();
    private final PlayerEntity player;

    public PlayerRenderer(GraphicsContext gc, PlayerEntity player) {
        super(gc, animationSettings.getEntityFrameDelay());
        this.player = player;
    }

    @Override
    protected Image frameImage_Idle(int col, int row) {
        return animator.animatePacman_Idle(col, row);
    }

    @Override
    protected Image frameImage_U(int col, int row) {
        return animator.animatePacman_U(col, row);
    }

    @Override
    protected Image frameImage_D(int col, int row) {
        return animator.animatePacman_D(col, row);
    }

    @Override
    protected Image frameImage_R(int col, int row) {
        return animator.animatePacman_R(col, row);
    }

    @Override
    protected Image frameImage_L(int col, int row) {
        return animator.animatePacman_L(col, row);
    }

    /**
     * Dosent do anything, but is required to override the method.
     */
    @Override
    protected boolean matches(char tile) {
        return false;
    }

    /**
     * We get size to render the player from the universial block size.
     * Can multiply the return statement for some goofy effetcs, not reccomended.
     */
    @Override
    protected int getEntitySize() {
        return boardSettings.get_Block_size();
    }

    @Override
    public void render(java.util.List<String> levelData) {
        Point2D pos = player.getPosition(); // <- use the field!
        Direction facing = player.getFacingDirection();
    
        int frame = (int)(GameTime.getElapsedTimeMillis() / animationSettings.getEntityFrameDelay()) %
                              animationSettings.Frames_per_spritesheet();
    
        int col = frame % animationSettings.columns_per_spritesheet();
        int row = 1; // Could be dynamic if needed
    
        Image currentFrame;
        switch (facing) {
            case UP:
                currentFrame = frameImage_U(col, row);
                break;
            case DOWN:
                currentFrame = frameImage_D(col, row);
                break;
            case LEFT:
                currentFrame = frameImage_L(col, row);
                break;
            case RIGHT:
                currentFrame = frameImage_R(col, row);
                break;
            default:
                currentFrame = frameImage_Idle(col, row);
                break;
        }
    
        int size = getEntitySize();
    
        graphicsContent.clearRect(0, 0,
            graphicsContent.getCanvas().getWidth(),
            graphicsContent.getCanvas().getHeight());
    
        graphicsContent.drawImage(
            currentFrame,
            pos.getX() - size / 2.0,
            pos.getY() - size / 2.0,
            size,
            size
        );
    }
    
}
