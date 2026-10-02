package projectpacman.Board;

import java.util.ArrayList;
import java.util.List;

import projectpacman.GhostLogic.Ghost;
import projectpacman.GhostLogic.GhostFactory;
import projectpacman.GhostLogic.GhostSpawn;

/**
 * BoardParser is responsible going through the levelData to analyze the characters meaning
 * into concrete game objects
 * 
 */
public class BoardParser {
    private List<String> levelData;
    private int rows, columns;
    private int pacmanStartRow, pacmanStartColumn;
    private final List<GhostSpawn> ghostSpawns = new ArrayList<>();
    private int pelletCount = -1;

    private int doorRow = -1;
    private int doorCol = -1;

    public void parse(List<String> levelData) {
        this.levelData = new ArrayList<>(levelData); // Defensive copy
        this.rows = levelData.size();
        this.columns = (rows > 0) ? levelData.get(0).length() : 0;

        calculatePelletCount();
        locatePacman();
        locateGhosts();
        locateDoor();
    }

    private void locatePacman() {
        for (int y = 0; y < rows; y++) {
            char[] row = levelData.get(y).toCharArray();
            for (int x = 0; x < columns; x++) {
                if (row[x] == 'P') {
                    pacmanStartRow = y;
                    pacmanStartColumn = x;
                    row[x] = '0';
                    levelData.set(y, new String(row));
                }
            }
        }
    }

    private void locateGhosts() {
        for (int y = 0; y < rows; y++) {
            char[] row = levelData.get(y).toCharArray();
            for (int x = 0; x < columns; x++) {
                Ghost g = GhostFactory.createGhost(row[x]);
                if (g != null) {
                    ghostSpawns.add(new GhostSpawn(g, y, x));
                    row[x] = '0';
                    levelData.set(y, new String(row));
                }
            }
        }
    }

    private void calculatePelletCount() {
        int count = 0;
        for (String row : levelData) {
            for (char c : row.toCharArray()) {
                if (c == '2') count++;
            }
        }
        pelletCount = count;
    }

    private void locateDoor() {
        for (int y = 0; y < rows; y++) {
            char[] row = levelData.get(y).toCharArray();
            for (int x = 0; x < columns; x++) {
                if (row[x] == 'D') {
                    doorRow = y;
                    doorCol = x;
                    return; // Only one door
                }
            }
        }
    }

    // Getters
    public List<String> getLevelData() {
        return levelData; 
    }

    public int getRows() { 
        return rows; 
    }

    public int getColumns() { 
        return columns; 
    }

    public int getPacmanStartRow() { 
        return pacmanStartRow; 
    }

    public int getPacmanStartColumn() { 
        return pacmanStartColumn; 
    }

    public List<GhostSpawn> getGhostSpawns() { 
        return ghostSpawns; 
    }

    public int getPelletCount() {
        return pelletCount;
    }

    public int getDoorRow() {
        return doorRow;
    }

    public int getDoorCol() {
        return doorCol;
    }
}
