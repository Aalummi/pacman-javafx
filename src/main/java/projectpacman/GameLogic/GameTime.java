package projectpacman.GameLogic;

/*
 * GameTime is a singleton that makes sure we only have one global instance of time, that is used
 * for all elements of the code related to time
 */
public class GameTime {
    private static GameTime instance;

    private static long startTime = -1;
    private static long lastUpdateTime = -1;
    private static double deltaTimeSeconds = -1;

    private GameTime() {}

    public static GameTime getInstance() {
        if (instance == null) {
            instance = new GameTime();
            System.out.println("(GameTime.java): Created new singleton instance.");
        }
        return instance;
    }

    public static void startGameTime() {
        startTime = System.nanoTime();
        lastUpdateTime = startTime;
    }

    public static void updateDeltaTime() {
        long now = System.nanoTime();
        deltaTimeSeconds = (now - lastUpdateTime) / 1_000_000_000.0;
        lastUpdateTime = now;
    }

    public static double getDeltaTimeSeconds() {
        return deltaTimeSeconds;
    }

    public static long getElapsedTimeNano() {
        return System.nanoTime() - startTime;
    }

    public static double getElapsedTimeSeconds() {
        return getElapsedTimeNano() / 1_000_000_000.0;
    }

    public static long getElapsedTimeMillis() {
        return getElapsedTimeNano() / 1_000_000;
    }
}
