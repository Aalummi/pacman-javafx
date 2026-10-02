package projectpacman.GameLogic;

import projectpacman.Player.PlayerEntity;
import projectpacman.GhostLogic.GhostEntity;

/**
 * GameUpdater is responsable for updating the game logic and the UI
 */
public class GameUpdater {
    private final CurrentGame game = CurrentGame.getInstance();

    public void updateGame() {
        GameState.getInstance().updatePowerState();

        PlayerEntity player = game.getPlayer();
        player.UpdatePosition();                            // Updates the player position
        game.getTileConsumer().checkAndConsume(player);     // Consume the tile if possible

        for (GhostEntity ghost : game.getEntityManager().getGhosts()) {
            ghost.updateGhostMode();
            ghost.UpdatePosition();
        }

        if (handleGhostCollisions()) return;

        new UIUpdater().update(); // update info banner / win/loss
        game.getRenderer().renderAll(game.getBoard().getLevelData());
    }

    private boolean handleGhostCollisions() {
        GameState state = GameState.getInstance();
        for (GhostEntity ghost : game.getEntityManager().getGhosts()) {
            if (ghost.isCollidingWithPlayer()) {
                if (state.getMode() == GameMode.POWER) {
                    state.addScore(200);
                    ghost.resetToStart();
                } else {
                    state.loseLife();
                    game.getEntityManager().resetEntities(game.getBoard());
                    return true;
                }
            }
        }
        return false;
    }
}
