package projectpacman.Initializer;

import java.io.IOException;

import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projectpacman.InfoBanner;
import projectpacman.Animator.SceneRenderer;
import projectpacman.Board.Board;
import projectpacman.GameLogic.CurrentGame;
import projectpacman.GameLogic.EntityManager;
import projectpacman.Player.PlayerEntity;
import projectpacman.Player.PlayerConsume;

/**
 * GameStarter is the main Initializer class that connects all the other
 * initializer classes to construct the game and start the game loop
 * 
 */
public class GameStarter {
    public void initialize(Stage stage) throws IOException {
        Board board = new BoardInitializer().loadBoard();

        //Initializes a canvas for the given level
        CanvasInitializer canvasInit = new CanvasInitializer(board);
        CanvasLayers layers = canvasInit.createCanvases();

        PlayerEntity player = new PlayerInitializer(board).createPlayer();
        //We get a instance of the pellet consumer to use for the player in GameUpdater
        CurrentGame.getInstance().setTileConsumer(new PlayerConsume(board.getLevelData()));

        UIInitializer uiInit = new UIInitializer();
        InfoBanner infoBanner = uiInit.createInfoBanner();
        Label gameResultLabel = uiInit.createGameResultLabel();

        // The canvases that needs to be dynamically updated
        // wall canvas depends on the level, and the other canvases adjust to the game state
        SceneRenderer renderer = new SceneRenderer(
            layers.wallCanvas.getGraphicsContext2D(),
            layers.pelletCanvas.getGraphicsContext2D(),
            layers.powerCanvas.getGraphicsContext2D(),
            layers.playerCanvas.getGraphicsContext2D(),
            layers.ghostCanvas.getGraphicsContext2D(),
            player
        );

        CurrentGame game = CurrentGame.getInstance();
        game.setPlayer(player);
        game.setCurrentBoard(board);
        
        EntityManager em = new EntityManager(board, player);
        game.setEntityManager(em);

        game.setSceneRenderer(renderer);
        game.setInfoBanner(infoBanner);
        game.setGameResultLabel(gameResultLabel);

        StackPane gameCanvas = uiInit.buildStackPane(layers, gameResultLabel);
        VBox root = uiInit.game_box(infoBanner, gameCanvas, board);

        Scene scene = new Scene(root);
        InputInitializer.setupControls(scene, player);

        stage.setScene(scene);
        stage.setTitle("Pacman");
        stage.show();

        GameLoopStarter.start();
    }
}

