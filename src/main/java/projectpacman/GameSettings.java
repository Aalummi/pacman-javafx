package projectpacman;

import java.io.IOException;

import projectpacman.Board.Board;


/* 
 * GameSettings is a singleton class used to encaptulate and store all the details sorrounding the current game
 * 
*/
public class GameSettings {
    public static GameSettings instance;
    public Board board;
    public String selected_level = "levels/level1.txt";

    private GameSettings() {
        try {
            board = new Board(selected_level);  // We make a new board with the selected_level
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("(GameSettings): Failed to load board for level " + selected_level);
        }
    }

    public static GameSettings getInstance() {
        if (instance == null) instance = new GameSettings();
        System.out.println("(GameSettings.java): No instance found, getting new singleton instance");
        return instance;
    }

    /**
     * Method not in use, can be used at some point to change level
     * possibly after winning a level
     * @param level
     */
    public void setGameLevel(String level) {
        System.out.println("(GameSettings.java): setting game level to : " + level);
        this.selected_level = level;
        try {
            board = new Board(level);  // Reset with a new board
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("(GameSettings): Failed to load board for level " + level);
        }
    }
}

