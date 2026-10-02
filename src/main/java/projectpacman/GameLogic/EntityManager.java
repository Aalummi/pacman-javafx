package projectpacman.GameLogic;

import java.util.ArrayList;
import java.util.List;

import projectpacman.Board.Board;
import projectpacman.Board.boardSettings;
import projectpacman.GhostLogic.GhostEntity;
import projectpacman.GhostLogic.GhostSpawn;
import projectpacman.Player.PlayerEntity;
import projectpacman.Player.PlayerResetHandler;

/**
 * EntityManager handles resetting the player and ghosts when the player looses a life from a ghost
 * Uses both logic for resetting from other classes like GhostEntity and PlayerResetHandler
 */
public class EntityManager {
    private final List<GhostEntity> ghosts = new ArrayList<>();
    private final List<GhostSpawn> ghostSpawns;
    private final PlayerEntity player;

    public EntityManager(Board board, PlayerEntity player) {
        this.player = player;
        this.ghostSpawns = board.getGhostSpawns();

        for (GhostSpawn spawn : ghostSpawns) {
            GhostEntity ghostEntity = new GhostEntity(
                spawn.getGhost(),
                spawn.getRow(),
                spawn.getCol(),
                board.getLevelData(),
                boardSettings.get_Block_size()
            );
            

            ghostEntity.setDoorPosition(board.getDoorRow(), board.getDoorCol());

            ghosts.add(ghostEntity);
        }
    }

    public List<GhostEntity> getGhosts() {
        return ghosts;
    }

    /**
     * The main method that resets the player and the ghosts
     */
    public void resetEntities(Board board) {
        PlayerResetHandler handler = new PlayerResetHandler();
        handler.resetPlayer(player, board.getPacmanStartRow(), board.getPacmanStartColumn());

        for (GhostEntity ghost : ghosts) {
            ghost.resetToStart();
        }
        System.out.println("(EntityManager.java) : entities have been reset");
    }
}
