package projectpacman.Animator;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;

import projectpacman.Player.PlayerEntity;

/**
 * SceneRenderer coordinates the drawing of multiple layers (walls, pellets, power-ups).
 * Walls are drawn once with the wallsDrawn boolean; pellets and power-ups are updated each frame.
 * 
 * Used in CurrentGame to render the game scene constantly.
 */
public class SceneRenderer {
    private boolean wallsDrawn = false;
    private final WallRenderer wallLayer;
    private final PelletRenderer pelletLayer;
    private final PowerRenderer powerLayer;
    private final PlayerRenderer playerLayer;
    private final GhostRenderer ghostLayer;

    public SceneRenderer(
        GraphicsContext wallGc,
        GraphicsContext pelletGc,
        GraphicsContext powerGc,
        GraphicsContext playerGc,
        GraphicsContext ghostGc,
        PlayerEntity player
        ) 

    {
        this.wallLayer = new WallRenderer(wallGc);
        this.pelletLayer = new PelletRenderer(pelletGc);
        this.powerLayer = new PowerRenderer(powerGc);
        this.playerLayer = new PlayerRenderer(playerGc, player);
        this.ghostLayer = new GhostRenderer(ghostGc);
    }

    /**
     * Render all layers in order. Walls once, then pellets and power-ups every frame.
     */
    public void renderAll(List<String> levelData) {
        if (!wallsDrawn) {
            wallLayer.render(levelData);
            wallsDrawn = true;
        }
        pelletLayer.render(levelData);
        powerLayer.render(levelData);
        playerLayer.render(levelData);
        ghostLayer.render(levelData);
    }
}
