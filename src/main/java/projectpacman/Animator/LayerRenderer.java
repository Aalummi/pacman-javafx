package projectpacman.Animator;

import java.util.List;

/**
 * Interface to share a common render method for AnimatedLayerRenderer and EntityRenderer
 */
public interface LayerRenderer {
    /**
     * Draws one frame of the game board using the provided level data.
     * @param levelData the list of strings representing each row of the level
     */
    void render(List<String> levelData) ;
}
