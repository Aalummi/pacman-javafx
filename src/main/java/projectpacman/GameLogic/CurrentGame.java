package projectpacman.GameLogic;

import projectpacman.Board.Board;
import projectpacman.GhostLogic.GhostEntity;
import projectpacman.Animator.SceneRenderer;
import projectpacman.Player.PlayerEntity;
import projectpacman.Player.PlayerConsume;
import projectpacman.InfoBanner;

import java.util.List;

import javafx.scene.control.Label;

/**
 * CurrentGame is a Singleton Data container for the current active game
 */
public class CurrentGame {
    private static CurrentGame instance;

    private Board board;
    private PlayerEntity player;
    private SceneRenderer renderer;
    private InfoBanner infoBanner;
    private Label gameResultLabel;
    private EntityManager entityManager;

    private CurrentGame() {}

    public static CurrentGame getInstance() {
        if (instance == null) instance = new CurrentGame();
        return instance;
    }

    public void setCurrentBoard(Board board) {
        this.board = board;
        GameState.getInstance().setPelletCount(board.getPelletCount());
    }

    public void updateGame() {
        if(GameState.getInstance().getMode() != GameMode.GAME_WON &&
              GameState.getInstance().getMode() != GameMode.GAME_OVER) {
                new GameUpdater().updateGame();
        }

    }

    public List<GhostEntity> getGhosts() {
    return entityManager.getGhosts();
    }

    // We set a tile consumer to use in GameUpdater
    private PlayerConsume tileConsumer;
    public void setTileConsumer(PlayerConsume consumer) {
        this.tileConsumer = consumer;
    }
    public PlayerConsume getTileConsumer() {
        // System.out.println("(CurrentGame.java) : tileConsumer returned");
        return tileConsumer;
    }

    public void setEntityManager(EntityManager em) { 
        this.entityManager = em; 
    }

    public void setPlayer(PlayerEntity player) { 
        this.player = player; 
    }

    public void setSceneRenderer(SceneRenderer renderer) { 
        this.renderer = renderer; 
    }

    public void setInfoBanner(InfoBanner banner) { 
        this.infoBanner = banner; 
    }
    public void setGameResultLabel(Label label) { 
        this.gameResultLabel = label; 
    }

    public Board getBoard() { 
        return board; 
    }

    public PlayerEntity getPlayer() { 
        return player; 
    }

    public SceneRenderer getRenderer() { 
        return renderer; 
    }

    public InfoBanner getInfoBanner() { 
        return infoBanner; 
    }

    public Label getGameResultLabel() { 
        return gameResultLabel; 
    }

    public EntityManager getEntityManager() { 
        return entityManager; 
    }
}
