package projectpacman.Animator;

import java.io.InputStream;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/*
 * EntityRenderer is a class we can use anywhere where we draw entities to get the correct path to the tiles
 */
public class EntityRenderer {
    public static void drawEntity(GraphicsContext graphics, String entityName, int x, int y, int blockSize) {
        String path = "/projectpacman/tiles/" + entityName + ".png";
        InputStream stream = EntityRenderer.class.getResourceAsStream(path);
        
        if (stream == null) {
            throw new IllegalAccessError("(EntityRenderer.java): Tile image not found: " + entityName + ".png");
        }

        Image entity = new Image(stream);
        graphics.drawImage(entity, x, y, blockSize, blockSize);
    }
}