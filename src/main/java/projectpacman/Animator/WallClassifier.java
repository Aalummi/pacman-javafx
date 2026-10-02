package projectpacman.Animator;

public class WallClassifier {
    private final char[][] levelData;
    private final int rows, columns;

    public WallClassifier(char[][] levelData) {
        this.levelData = levelData;
        this.rows = levelData.length;
        this.columns = levelData[0].length;
    }

    private class WallNeighbour {
        boolean up, down, left, right, up_left, up_right, down_left, down_right;

        WallNeighbour(int x, int y) {
            this.up = y > 0 && levelData[y - 1][x] == '1' || y > 0 && levelData[y - 1][x] == 'D' ;
            this.down = y < rows - 1 && levelData[y + 1][x] == '1'|| y < rows - 1 && levelData[y + 1][x] == 'D';
            this.left = x > 0 && levelData[y][x - 1] == '1' || x > 0 && levelData[y][x - 1] == 'D';
            this.right = x < columns - 1 && levelData[y][x + 1] == '1' || x < columns - 1 && levelData[y][x + 1] == 'D';
            this.up_left = y > 0 && x > 0 && levelData[y - 1][x - 1] == '1' || y > 0 && x > 0 && levelData[y - 1][x - 1] == 'D';
            this.up_right = y > 0 && x < columns - 1 && levelData[y - 1][x + 1] == '1' || y > 0 && x < columns - 1 && levelData[y - 1][x + 1] == 'D';
            this.down_left = y < rows - 1 && x > 0 && levelData[y + 1][x - 1] == '1' || y < rows - 1 && x > 0 && levelData[y + 1][x - 1] == 'D';
            this.down_right = y < rows - 1 && x < columns - 1 && levelData[y + 1][x + 1] == '1' || y < rows - 1 && x < columns - 1 && levelData[y + 1][x + 1] == 'D';
        }
    }

    public String classify(int x, int y) {

        //Makes an instance of WallNeighbour so it's able to classify the walltype that should be made
        WallNeighbour w = new WallNeighbour(x, y);

        if (!w.up && !w.down && !w.left && !w.right) 
            return "single_block";
        if (!w.up && !w.down && w.left && w.right) 
            return "horizontal_line";
        if (!w.up && !w.down && !w.left && w.right) 
            return "horizontal_line_left";
        if (!w.up && !w.down && w.left && !w.right) 
            return "horizontal_line_right";
        if (w.up && w.down && !w.left && !w.right) 
            return "vertical_line";
        if (!w.up && w.down && !w.left && !w.right) 
            return "vertical_line_top";
        if (w.up && !w.down && !w.left && !w.right) 
            return "vertical_line_bottom";
        if (w.up && !w.down && !w.left && w.right) 
            return "down_right_corner";
        if (w.up && !w.down && w.left && !w.right) 
            return "down_left_corner";
        if (!w.up && w.down && !w.left && w.right) 
            return "top_left_corner";
        if (!w.up && w.down && w.left && !w.right) 
            return "top_right_corner";
        if (w.up && w.down && w.left && w.right) 
            if(w.up_left && w.up_right && w.down_left && w.down_right)
            return "empty";
            else if(!w.up_left && w.up_right && w.down_left && w.down_right)
                return "down_left_corner";
            else if(w.up_left && !w.up_right && w.down_left && w.down_right)
                return "down_right_corner";
            else if(w.up_left && w.up_right && !w.down_left && w.down_right)
                return "top_right_corner";
            else if(w.up_left && w.up_right && w.down_left && !w.down_right)
                return "top_left_corner";
            else 
                return "intersection";
        if (w.up && !w.down && w.left && w.right) 
            if(w.up_left && w.up_right)
                return "horizontal_line";
            else
                return "top_t";
        if (!w.up && w.down && w.left && w.right) 
            if(w.down_left && w.down_right)
                return "horizontal_line";
            else
                return "bottom_t";
        if (w.up && w.down && w.left && !w.right)
            if(w.up_left && w.down_left)
                return "vertical_line";
            else
                return "left_t";
        if (w.up && w.down && !w.left && w.right) 
            if(w.up_right && w.down_right)
                return "vertical_line";
            else
                return "right_t";

        //If a unknown configuration exists for some reason
        return null;
    }

    public String classifydoor(int x, int y){

        //Makes an instance of WallNeighbour so it's able to classify the walltype that should be made
        WallNeighbour w = new WallNeighbour(x, y);
        
        if (w.up && w.down && !w.left && !w.right) 
            return "DoorP";
        if (!w.up && !w.down && w.left && w.right)
            return "DoorS";
        else
            return null;
    }
}
