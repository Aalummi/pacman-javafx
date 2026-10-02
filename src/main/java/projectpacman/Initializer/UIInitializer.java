package projectpacman.Initializer;

import projectpacman.InfoBanner;
import projectpacman.Board.Board;
import projectpacman.Board.boardSettings;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 * UI Initializer is a initializer class that handles setting up the visual interface
 * 
 *  Info banner : score, lives
 *  Game Result : Game Over / You won
 *  Game_Box : the stacked game canvases
 * 
 */
public class UIInitializer {
    public InfoBanner createInfoBanner() {
        InfoBanner.setVerticalBuffer(boardSettings.get_Block_size() * 2);
        return new InfoBanner();
    }

    /*
     * Method to create a game result level
     */
    public Label createGameResultLabel() {
        Label label = new Label();
        label.setFont(Font.loadFont(
            getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"),
            boardSettings.get_Block_size() * 1.5
        ));
        label.setTextFill(Color.LIMEGREEN);
        label.setVisible(false);
        StackPane.setAlignment(label, Pos.CENTER);
        return label;
    }

    // We set up the stack panes in order, there is a stack pane for each different game object
    public StackPane buildStackPane(CanvasLayers layers, Label label) {
        return new StackPane(
            layers.wallCanvas,
            layers.pelletCanvas,
            layers.powerCanvas,
            layers.playerCanvas,
            layers.ghostCanvas,
            label
        );
    }

    public VBox game_box(InfoBanner banner, StackPane gameCanvas, Board board) {
        int block = boardSettings.get_Block_size();
        int width = board.getColumns() * block;
        int height = board.getRows() * block + InfoBanner.getVerticalBuffer();

        VBox root = new VBox(banner, gameCanvas);
        root.setPrefSize(width, height);
        root.setStyle("-fx-background-color: #0C0C0C");
        return root;
    }
}
