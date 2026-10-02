package projectpacman.Animator;

import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import projectpacman.Board.boardSettings;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GameLogic.GameMode;
import projectpacman.GameLogic.GameState;
import projectpacman.GameLogic.GameTime;
import projectpacman.GhostLogic.GhostEntity;

public class GhostRenderer extends AnimatedLayerRenderer {

/**
 * The GhostRenderer class is responsible for rendering the ghosts. 
 * We get the animation frames when we call boardAnimator.
 * 
 * GhostRenderer is used in the class SceneRenderer to render the player character on the screen.
 * //TODO small adjustment. We get all frames from the boardAnimator, but we only need the frames for the player.
 */

    private final boardAnimator animator = new boardAnimator();

    public GhostRenderer(GraphicsContext gc) {
        super(gc, animationSettings.getEntityFrameDelay());
    }
    
    protected Image frameImage_Idle(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateBlinky_Idle(col, row);
            case "Pinky":
                return animator.animatePinky_Idle(col, row);
            case "Inky":
                return animator.animateInky_Idle(col, row);
            case "Clyde":
                return animator.animateClyde_Idle(col, row);
            default:
                throw new AssertionError();
        }    
    }

    
    protected Image frameImage_U(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateBlinky_U(col, row);
            case "Pinky":
                return animator.animatePinky_U(col, row);
            case "Inky":
                return animator.animateInky_U(col, row);
            case "Clyde":
                return animator.animateClyde_U(col, row);
            default:
                throw new AssertionError();
        }
    }

    
    protected Image frameImage_D(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateBlinky_D(col, row);
            case "Pinky":
                return animator.animatePinky_D(col, row);
            case "Inky":
                return animator.animateInky_D(col, row);
            case "Clyde":
                return animator.animateClyde_D(col, row);
            default:
                throw new AssertionError();
        }
    }

    protected Image frameImage_R(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateBlinky_R(col, row);
            case "Pinky":
                return animator.animatePinky_R(col, row);
            case "Inky":
                return animator.animateInky_R(col, row);
            case "Clyde":
                return animator.animateClyde_R(col, row);
            default:
                throw new AssertionError();
        }
    }
    
    protected Image frameImage_L(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateBlinky_L(col, row);
            case "Pinky":
                return animator.animatePinky_L(col, row);
            case "Inky":
                return animator.animateInky_L(col, row);
            case "Clyde":
                return animator.animateClyde_L(col, row);
            default:
                throw new AssertionError();
        }
    }

    protected Image frameImage_Scared(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateGhostScatter(col, row);
            case "Pinky":
                return animator.animateGhostScatter(col, row);
            case "Inky":
                return animator.animateGhostScatter(col, row);
            case "Clyde":
                return animator.animateGhostScatter(col, row);
            default:
                throw new AssertionError();
        }
    }

        protected Image frameImage_TimesUp(String ghostName, int col, int row) {
        switch (ghostName) {
            case "Blinky":
                return animator.animateTimeUpGhost(col, row);
            case "Pinky":
                return animator.animateTimeUpGhost(col, row);
            case "Inky":
                return animator.animateTimeUpGhost(col, row);
            case "Clyde":
                return animator.animateTimeUpGhost(col, row);
            default:
                throw new AssertionError();
        }
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

        graphicsContent.clearRect(0, 0,
        graphicsContent.getCanvas().getWidth(),
        graphicsContent.getCanvas().getHeight());

        List<GhostEntity> ghostEntities = CurrentGame.getInstance().getGhosts();
        
        for (GhostEntity ghost : ghostEntities) {
            Point2D pos = ghost.getPosition();

            int frame = (int)(GameTime.getElapsedTimeMillis() / animationSettings.getEntityFrameDelay()) %
            animationSettings.Frames_per_spritesheet();

            int col = frame % animationSettings.columns_per_spritesheet();
            int row = 1; // For now; use direction later

            Image currentFrame;
            
            if(GameState.getInstance().getMode() == GameMode.POWER) {
                long currentNano = GameTime.getElapsedTimeNano();
                long powerduration = currentNano - GameState.getInstance().getPowerStart();
                if(5_500_000_000L <= powerduration){
                    currentFrame = frameImage_TimesUp(ghost.getName(), col, row);
                }
                else{
                    currentFrame = frameImage_Scared(ghost.getName(), col, row);
                }   
            }
            else{
                switch (ghost.getDirection()) {
                    case UP:
                        currentFrame = frameImage_U(ghost.getName(), col, row);
                        break;
                    case DOWN:
                        currentFrame = frameImage_D(ghost.getName(), col, row);
                        break;
                    case LEFT:
                        currentFrame = frameImage_L(ghost.getName(), col, row);
                        break;
                    case RIGHT:
                        currentFrame = frameImage_R(ghost.getName(), col, row);
                        break;
                    default:
                        currentFrame = frameImage_Idle(ghost.getName(), col, row);
                        break;
                }
            } 




            int size = getEntitySize();


    
            graphicsContent.drawImage(
                currentFrame,
                pos.getX() - size / 2.0,
                pos.getY() - size / 2.0,
                size,
                size
            );
        }


    }


    
    @Override
    protected Image frameImage_Idle(int col, int row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frameImage_Idle'");
    }
    @Override
    protected Image frameImage_R(int col, int row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frameImage_R'");
    }
    @Override
    protected Image frameImage_L(int col, int row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frameImage_L'");
    }
    @Override
    protected Image frameImage_U(int col, int row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frameImage_U'");
    }
    @Override
    protected Image frameImage_D(int col, int row) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frameImage_D'");
    }

}
