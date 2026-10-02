package projectpacman.GameLogic;

import java.util.List;

import javafx.geometry.Point2D;
import projectpacman.Board.boardSettings;

/**
 * MovableEntity is a abstract "superclass" for all entities that can move on the game board.
 * It provides a method to check if the entity can move to a specific position on the board.
 */
public abstract class MovableEntity {
    protected int row, column;
    protected Direction direction;
    protected List<String> levelData;
    

    public MovableEntity(int row, int column, List<String> levelData) {
        this.row = row;
        this.column = column;
        this.levelData = levelData;
    }

    public boolean canMoveTo(int row, int column) {
        if (row < 0 || row >= levelData.size()) return false;
        if (column < 0 || column >= levelData.get(0).length()) return false;
        return levelData.get(row).charAt(column) != '1' && levelData.get(row).charAt(column) != 'D'; //Walls are 1 therefore not traversable.
    }

    public boolean canWarpTo(int r, int c){
        if (r < 0) return levelData.get(levelData.size()).charAt(c) != '1';
        if (r >= levelData.size()) return levelData.get(0).charAt(c) != '1';
        if (c < 0) return levelData.get(r).charAt(levelData.get(0).length() - 1) != '1';
        if (c >= levelData.get(0).length()) return levelData.get(r).charAt(0) != '1';
        else return false;
    }

    public Point2D warpmove(int row, int column){
        if (row < 0)return gridToPixel((levelData.size()-1), column);
        if (row >= levelData.size())return gridToPixel(1, column);
        if (column < 0) return gridToPixel(row, levelData.get(0).length() - 1);
        if (column >= levelData.get(0).length()) return gridToPixel(row, 0);
        else return new Point2D(row, column);
    }

    public Point2D gridToPixel(int row, int col) {
        int blocksize = boardSettings.get_Block_size();
        return new Point2D(
            col * blocksize + blocksize / 2.0,
            row * blocksize + blocksize / 2.0
        );
    }

    // Converts a pixel from a Point2D into a row in the leveldata
    public int pixelToRow(Point2D p) {
        int blocksize = boardSettings.get_Block_size();
        return (int)(p.getY() / blocksize);
    }
    // Converts a pixel from a Point2D into a column in the leveldata
    public int pixelToCol(Point2D p) {
        int blocksize = boardSettings.get_Block_size();
        return (int)(p.getX() / blocksize);
    }

    public abstract void UpdatePosition();

    public abstract void setDirection(Direction direction);

    public abstract Direction getDirection();

    public int getRow() { return row; }
    
    public int getColumn() { return column; }
}
