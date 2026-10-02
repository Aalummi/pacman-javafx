package projectpacman.Board;

/*
 * boardSettings is a settings class where you can change the size of the blocks and pellets in the canvas
 * It's basically just related to JavaFX
 */
public class boardSettings {

    private static int defaultBlockSize = 25;
    private static int blockSize = defaultBlockSize;

    private static int pelletSize = blockSize / 2;
    private static int powerSize = blockSize / 2;

    public static void set_Block_Size(int new_block_size) {
        System.out.println("boardSettings.java : setting blocksize to : " + new_block_size);
        blockSize = new_block_size;
    }

    public static int get_Block_size() {
        // ⚠️ Spams a lot. Possible some place is using it too much
        // System.out.println("boardSettings.java : getting blocksize : " + blockSize);
        return blockSize;
    }

    public static int get_Pellet_size() {
        // ⚠️ Spams a lot. Possible some place is using it too much
        // System.out.println("boardSettings.java : getting pelletSize : " + pelletSize);
        return pelletSize;
    }

    public static int get_Power_size() {
        // ⚠️ Spams a lot. Possible some place is using it too much
        // System.out.println("boardSettings.java : getting powerSize : " + powerSize);
        return powerSize;
    }
    
}


