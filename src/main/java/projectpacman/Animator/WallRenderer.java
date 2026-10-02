package projectpacman.Animator;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import projectpacman.Board.boardSettings;

/**
 * The Renderer class is responsible for rendering the game level onto the canvas.
 * It processes the level data, classifies walls, and draws entities based on their type.
 */
public class WallRenderer implements LayerRenderer {
    private final GraphicsContext gc;

    public WallRenderer(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void render(List<String> levelData) {
        //Determine the number of rows and columns in the levelData
        int rows = levelData.size();
        int cols = levelData.get(0).length();
        
        //Get the block size from boardSettings to render at the approrpiate position.
        int block = boardSettings.get_Block_size();

        //Creates a levelmatrix with the size of the levelData list.
        char[][] levelmatrix = new char[rows][cols];

        //Fills the levelmatrix with the levelData from the levelData list.
        for (int y = 0; y < rows; y++) {
            levelmatrix[y] = levelData.get(y).toCharArray();
        }
        //Gets wall classifier to classify the type of wall.
        WallClassifier wallclassifier = new WallClassifier(levelmatrix);

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (levelmatrix[y][x] == 'D'){
                    String type = wallclassifier.classifydoor(x, y);
                    EntityRenderer.drawEntity(gc, type, x * block, y * block, block);
                }
                else if (levelmatrix[y][x] == '1') { //1 is a wall in the Level.txt file.
                    String type = wallclassifier.classify(x, y);
                    EntityRenderer.drawEntity(gc, type, x * block, y * block, block);
                    // System.out.println("(WallRenderer.java): " + type + "Drawn at (" + x + ", " + y + ")");
                    }
                }
                //Added 1 as it feels more natural if you want to verify and not count from 0
                //System.out.println("(WallRenderer.java): Drawn walls for layer: " + (y + 1 ));
            }
            System.out.println("(WallRenderer.java): Walls have been drawn");;
        }
}
