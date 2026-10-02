package projectpacman.Initializer;

import javafx.scene.canvas.Canvas;

/**
 * CanvasLayers is a class that holds the types of canvases we want to use
 */
public class CanvasLayers {
    public final Canvas wallCanvas;
    public final Canvas pelletCanvas;
    public final Canvas powerCanvas;
    public final Canvas playerCanvas;
    public final Canvas ghostCanvas;

    public CanvasLayers(Canvas wallCanvas, Canvas pelletCanvas, Canvas powerCanvas,
                        Canvas playerCanvas, Canvas ghostCanvas) {
        this.wallCanvas = wallCanvas;
        this.pelletCanvas = pelletCanvas;
        this.powerCanvas = powerCanvas;
        this.playerCanvas = playerCanvas;
        this.ghostCanvas = ghostCanvas;
    }
}
