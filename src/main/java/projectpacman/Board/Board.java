package projectpacman.Board;

import java.io.IOException;
import java.util.List;

import projectpacman.GhostLogic.GhostSpawn;

/**
 * This class represents the game board. It encapsulates all the essential data from a levelfile
 * including the layout, pacman position, ghosts types used, and the remaining pellets.
 * 
 * The class is immutable after initialization, thus has no setters. The data is given in the 
 * constructor
 */
public class Board {
    private final List<String> levelData;
    private final List<GhostSpawn> ghostSpawns;
    private final int pacmanStartRow, pacmanStartCol;
    private final int pelletCount;
    private final int doorRow, doorCol;

    public Board(String levelPath) throws IOException {
        BoardLoader loader = new BoardLoader();
        List<String> rawLevel = loader.loadLevel(levelPath);
    
        BoardParser parser = new BoardParser();
        parser.parse(rawLevel);

        this.levelData = parser.getLevelData();
        this.ghostSpawns = parser.getGhostSpawns();
        this.pacmanStartRow = parser.getPacmanStartRow();
        this.pacmanStartCol = parser.getPacmanStartColumn();
        this.pelletCount = parser.getPelletCount();

        this.doorRow = parser.getDoorRow();
        this.doorCol = parser.getDoorCol();
    }

    //          Getters             //

    public List<String> getLevelData() {
        return levelData; 
    }

    public List<GhostSpawn> getGhostSpawns() { 
        return ghostSpawns; 
    }
    
    public int getPacmanStartRow() { 
        return pacmanStartRow; 
    }

    public int getPacmanStartColumn() { 
        return pacmanStartCol; 
    }

    public int getPelletCount() { 
        return pelletCount; 
    }

    public int getRows() { 
        return levelData.size(); 
    }

    public int getColumns() { 
        return levelData.isEmpty() ? 0 : levelData.get(0).length(); 
    }

    public int getDoorRow() {
        return doorRow;
    }

    public int getDoorCol() {
        return doorCol;
    }
}
