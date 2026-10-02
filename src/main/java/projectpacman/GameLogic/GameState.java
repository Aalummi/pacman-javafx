package projectpacman.GameLogic;

/*
 * GameState is a singleton that is used to store the data sorrounding the player for the given game
 */

 public class GameState {
    private static GameState instance;
    private  GameTime gameTimeInstance;

    private static int score;
    private int remaining_Lives;
    private int remaining_Pellets;

    private long powerStartNano = -1;
    private final long power_Duration = 7_000_000_000L; 

    private GameMode currentMode;

    public GameState() {                                
        score = 0;
        remaining_Lives = 2;
        this.gameTimeInstance = GameTime.getInstance();
        this.currentMode = GameMode.NORMAL;
        
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    // public GameTime getTimeInstance() {
    //     if (instance == null) {
    //         instance = new GameState();
    //     }
    //     return gameTimeInstance;
    // }                                                    //Should have been removed

    //         v     Getters and setters for GameState.Java      v      ///

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public int getRemainingLives() {
        return remaining_Lives;
    }

    public void loseLife() {
        if(getRemainingLives() == 0) {
            remaining_Lives--;
            setMode(GameMode.GAME_OVER);
            new UIUpdater().update();
        }
        else {
            System.out.println("(GameState.java): You lost a life, remaining lives: " + (remaining_Lives - 1));
        }
        remaining_Lives--;
    }

    public void gainLife() {
        remaining_Lives++;
    }

    public void subtract_pellet_count() {
        if (remaining_Pellets == 1) {
            remaining_Pellets--;
            setMode(GameMode.GAME_WON);
            System.out.println("You've Won the game!!!!");
        }
        else {
            remaining_Pellets--;
        }
        System.out.println("(GameState.java): Pellet was eaten, remaining pellets: " + remaining_Pellets);
    }


    public void setPelletCount(int count) {
        remaining_Pellets = count;
    }
    
    public int getRemainingPellets() {
        return remaining_Pellets;
    }

    public void setMode(GameMode mode) {
        this.currentMode = mode;
        System.out.println("(GameState.java): Mode changed to " + mode);
    }

    public GameMode getMode() {
        return currentMode;
    }

    public void startPowerState() {
        powerStartNano = GameTime.getElapsedTimeNano(); //use GameTime
        setMode(GameMode.POWER);
        System.out.println("(GameState.java): Power state started at " + powerStartNano + "ns");
    }

    public long getPowerStart(){
        return powerStartNano;
    }

    public void updatePowerState() {
        if (currentMode == GameMode.POWER) {
            long currentNano = GameTime.getElapsedTimeNano();
            if ((currentNano - powerStartNano) >= power_Duration) {
                setMode(GameMode.NORMAL);
                powerStartNano = -1; // reset
                System.out.println("(GameState.java): Power state ended.");
            }
        }
    }
    
    

}
