package projectpacman.Animator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

/**
 * boardAnimator is the class that handles loading, slicing, and returning sprite frames
 * for all animated entities like pellets, power-ups, and Pacman.
 * 
 */
public class boardAnimator {
    private final int sprite_frames;

    //Pellets and powers
    private final Image pelletSheet;
    private final Image powerSheet;

    private final Image[][] pelletFrames;
    private final Image[][] powerFrames;

    //Pacman
    private final Image pacmanSheet_Idle;
    private final Image pacmanSheet_U;
    private final Image pacmanSheet_D;
    private final Image pacmanSheet_L;
    private final Image pacmanSheet_R;
    private final Image pacmanDeathSheet;

    private final Image[][] pacmanFrames_Idle;
    private final Image[][] pacmanFrames_U;
    private final Image[][] pacmanFrames_D;
    private final Image[][] pacmanFrames_L;
    private final Image[][] pacmanFrames_R;
    private final Image[][] pacmanDeathFrames;


    //Blinky
    private final Image blinkySheet_Idle;
    private final Image blinkySheet_U;
    private final Image blinkySheet_D;
    private final Image blinkySheet_L;
    private final Image blinkySheet_R;

    private final Image[][] blinkyFrames_Idle;
    private final Image[][] blinkyFrames_U;
    private final Image[][] blinkyFrames_D;
    private final Image[][] blinkyFrames_L;
    private final Image[][] blinkyFrames_R;

    //Clyde
    private final Image clydeSheet_Idle;
    private final Image clydeSheet_U;
    private final Image clydeSheet_D;
    private final Image clydeSheet_L;
    private final Image clydeSheet_R;

    private final Image[][] clydeFrames_Idle;
    private final Image[][] clydeFrames_U;
    private final Image[][] clydeFrames_D;
    private final Image[][] clydeFrames_L;
    private final Image[][] clydeFrames_R;

    //Inky
    private final Image inkySheet_Idle;
    private final Image inkySheet_U;
    private final Image inkySheet_D;
    private final Image inkySheet_L;
    private final Image inkySheet_R;

    private final Image[][] inkyFrames_Idle;
    private final Image[][] inkyFrames_U;
    private final Image[][] inkyFrames_D;
    private final Image[][] inkyFrames_L;
    private final Image[][] inkyFrames_R;

    //Pinky
    private final Image pinkySheet_Idle;
    private final Image pinkySheet_U;
    private final Image pinkySheet_D;
    private final Image pinkySheet_L;
    private final Image pinkySheet_R;

    private final Image[][] pinkyFrames_Idle;
    private final Image[][] pinkyFrames_U;
    private final Image[][] pinkyFrames_D;
    private final Image[][] pinkyFrames_L;
    private final Image[][] pinkyFrames_R;

    //Time up ghost
    private final Image timeUpGhostSheet;
    private final Image[][] timeUpGhostFrames;

    //Ghost scatter
    private final Image ghostScatterSheet;
    private final Image[][] ghostScatterFrames;

    //Ghost death eyes
    private final Image ghostDeathSheet_U;
    private final Image ghostDeathSheet_D;
    private final Image ghostDeathSheet_L;
    private final Image ghostDeathSheet_R;

    private final Image[][] ghostDeathFrames_U;
    private final Image[][] ghostDeathFrames_D;
    private final Image[][] ghostDeathFrames_L;
    private final Image[][] ghostDeathFrames_R;





    public boardAnimator() {
        sprite_frames = animationSettings.Frames_per_spritesheet();
    
        //Pellets and Powers
        pelletSheet = new Image(getClass().getResourceAsStream("/projectpacman/tiles/Pellet.png"));
        powerSheet  = new Image(getClass().getResourceAsStream("/projectpacman/tiles/Power.png"));

        pelletFrames = sliceSheet(pelletSheet, "Pellet Frames");
        powerFrames  = sliceSheet(powerSheet, "Power Frames");

        //Pacman frames
        pacmanSheet_Idle = new Image(getClass().getResourceAsStream("/projectpacman/tiles/MrPacmanIdle.png"));
        pacmanSheet_U = new Image(getClass().getResourceAsStream("/projectpacman/tiles/MrPacmanUp.png"));
        pacmanSheet_D = new Image(getClass().getResourceAsStream("/projectpacman/tiles/MrPacmanDown.png"));
        pacmanSheet_L = new Image(getClass().getResourceAsStream("/projectpacman/tiles/MrPacmanLeft.png"));
        pacmanSheet_R = new Image(getClass().getResourceAsStream("/projectpacman/tiles/MrPacmanRight.png"));
        pacmanDeathSheet = new Image(getClass().getResourceAsStream("/projectpacman/tiles/MrPacmanDyingLeft.png"));

        pacmanFrames_Idle = sliceSheet(pacmanSheet_Idle, "Player Idle");
        pacmanFrames_D = sliceSheet(pacmanSheet_D, "Player Down");
        pacmanFrames_U = sliceSheet(pacmanSheet_U, "Player Up");
        pacmanFrames_L = sliceSheet(pacmanSheet_L, "Player Left");
        pacmanFrames_R = sliceSheet(pacmanSheet_R, "Player Right");
        pacmanDeathFrames = sliceSheet(pacmanDeathSheet, "Pacman death frames");

        //Blinky frames
        blinkySheet_Idle = new Image(getClass().getResourceAsStream("/projectpacman/tiles/RedGhostBlinkyIdle.png"));
        blinkySheet_U = new Image(getClass().getResourceAsStream("/projectpacman/tiles/RedGhostBlinkyUp.png"));
        blinkySheet_D = new Image(getClass().getResourceAsStream("/projectpacman/tiles/RedGhostBlinkyDown.png"));
        blinkySheet_L = new Image(getClass().getResourceAsStream("/projectpacman/tiles/RedGhostBlinkyLeft.png"));
        blinkySheet_R = new Image(getClass().getResourceAsStream("/projectpacman/tiles/RedGhostBlinkyRight.png"));
        
        blinkyFrames_Idle = sliceSheet(blinkySheet_Idle, "Blinky Idle");
        blinkyFrames_D = sliceSheet(blinkySheet_D, "Blinky Down");
        blinkyFrames_U = sliceSheet(blinkySheet_U, "Blinky Up");
        blinkyFrames_L = sliceSheet(blinkySheet_L, "Blinky Left");
        blinkyFrames_R = sliceSheet(blinkySheet_R, "Blinky Right");

        //Clyde frames
        clydeSheet_Idle = new Image(getClass().getResourceAsStream("/projectpacman/tiles/OrangeGhostClydeIdle.png"));
        clydeSheet_U = new Image(getClass().getResourceAsStream("/projectpacman/tiles/OrangeGhostClydeUp.png"));
        clydeSheet_D = new Image(getClass().getResourceAsStream("/projectpacman/tiles/OrangeGhostClydeDown.png"));
        clydeSheet_L = new Image(getClass().getResourceAsStream("/projectpacman/tiles/OrangeGhostClydeLeft.png"));
        clydeSheet_R = new Image(getClass().getResourceAsStream("/projectpacman/tiles/OrangeGhostClydeRight.png"));
        
        clydeFrames_Idle = sliceSheet(clydeSheet_Idle, "clyde Idle");
        clydeFrames_D = sliceSheet(clydeSheet_D, "clyde Down");
        clydeFrames_U = sliceSheet(clydeSheet_U, "clyde Up");
        clydeFrames_L = sliceSheet(clydeSheet_L, "clyde Left");
        clydeFrames_R = sliceSheet(clydeSheet_R, "clyde Right");

        //Inky frames
        inkySheet_Idle = new Image(getClass().getResourceAsStream("/projectpacman/tiles/CyanGhostInkyIdle.png"));
        inkySheet_U = new Image(getClass().getResourceAsStream("/projectpacman/tiles/CyanGhostInkyUp.png"));
        inkySheet_D = new Image(getClass().getResourceAsStream("/projectpacman/tiles/CyanGhostInkyDown.png"));
        inkySheet_L = new Image(getClass().getResourceAsStream("/projectpacman/tiles/CyanGhostInkyLeft.png"));
        inkySheet_R = new Image(getClass().getResourceAsStream("/projectpacman/tiles/CyanGhostInkyRight.png"));
        
        inkyFrames_Idle = sliceSheet(inkySheet_Idle, "inky Idle");
        inkyFrames_D = sliceSheet(inkySheet_D, "inky Down");
        inkyFrames_U = sliceSheet(inkySheet_U, "inky Up");
        inkyFrames_L = sliceSheet(inkySheet_L, "inky Left");
        inkyFrames_R = sliceSheet(inkySheet_R, "inky Right");

        //Pinky frames
        pinkySheet_Idle = new Image(getClass().getResourceAsStream("/projectpacman/tiles/PinkGhostPinkyIdle.png"));
        pinkySheet_U = new Image(getClass().getResourceAsStream("/projectpacman/tiles/PinkGhostPinkyUp.png"));
        pinkySheet_D = new Image(getClass().getResourceAsStream("/projectpacman/tiles/PinkGhostPinkyDown.png"));
        pinkySheet_L = new Image(getClass().getResourceAsStream("/projectpacman/tiles/PinkGhostPinkyLeft.png"));
        pinkySheet_R = new Image(getClass().getResourceAsStream("/projectpacman/tiles/PinkGhostPinkyRight.png"));
        
        pinkyFrames_Idle = sliceSheet(pinkySheet_Idle, "pinky Idle");
        pinkyFrames_D = sliceSheet(pinkySheet_D, "pinky Down");
        pinkyFrames_U = sliceSheet(pinkySheet_U, "pinky Up");
        pinkyFrames_L = sliceSheet(pinkySheet_L, "pinky Left");
        pinkyFrames_R = sliceSheet(pinkySheet_R, "pinky Right");

        //Time up ghost
        timeUpGhostSheet = new Image(getClass().getResourceAsStream("/projectpacman/tiles/TimeUpGhost.png"));
        timeUpGhostFrames = sliceSheet(timeUpGhostSheet, "Time up ghost Animations");

        //Ghost scatter
        ghostScatterSheet = new Image(getClass().getResourceAsStream("/projectpacman/tiles/ScatterGhost.png"));
        ghostScatterFrames = sliceSheet(ghostScatterSheet, "Ghost death Animations");

        //Ghost death eyes
        ghostDeathSheet_U = new Image(getClass().getResourceAsStream("/projectpacman/tiles/EyeUpAnimated.png"));
        ghostDeathSheet_D = new Image(getClass().getResourceAsStream("/projectpacman/tiles/EyeDownAnimated.png"));
        ghostDeathSheet_L = new Image(getClass().getResourceAsStream("/projectpacman/tiles/EyeLeftAnimated.png"));
        ghostDeathSheet_R = new Image(getClass().getResourceAsStream("/projectpacman/tiles/EyeRightAnimated.png"));

        ghostDeathFrames_U = sliceSheet(ghostDeathSheet_U, "Ghost Death eyes Up");
        ghostDeathFrames_D = sliceSheet(ghostDeathSheet_D, "pinky Ghost Death eyes Down");
        ghostDeathFrames_L = sliceSheet(ghostDeathSheet_L, "Ghost Death eyes Left");
        ghostDeathFrames_R = sliceSheet(ghostDeathSheet_R, "Ghost Death eyes Right");
    }
    

    private Image[][] sliceSheet(Image sheet, String frame_type) {
        int cols = (int) Math.floor(sheet.getWidth() / sprite_frames);
        int rows = (int) Math.floor(sheet.getHeight() / sprite_frames);
    
        //System.out.println("(BoardAnimator.java): Sprite sheet dimensions: " + sheet.getWidth() + "x" + sheet.getHeight());
        //System.out.println("(BoardAnimator.java): Calculated rows: " + rows + ", cols: " + cols);
    
        Image[][] frames = new Image[rows][cols];
    
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                frames[row][col] = new WritableImage(
                    sheet.getPixelReader(),
                    col * sprite_frames,
                    row * sprite_frames,
                    sprite_frames,
                    sprite_frames
                );
                //System.out.println("(BoardAnimator.java): Sliced frame at row " + row + ", col " + col);
            }
        }
    
        System.out.println("(BoardAnimator.java): Sliced frames for: " + frame_type);
        return frames;
    }

    //                    v      Pellets/Powers      v                           //

    public Image animatePellet(int col, int row) {
        int clampedCol = Math.min(col, pelletFrames[0].length - 1);
        int clampedRow = Math.min(row, pelletFrames.length - 1);
        return pelletFrames[clampedRow][clampedCol];
    }

    public Image animatePower(int col, int row) {
        int clampedCol = Math.min(col, powerFrames[0].length - 1);
        int clampedRow = Math.min(row, powerFrames.length - 1);
        return powerFrames[clampedRow][clampedCol];
    }



    //                     v      Player Frames      v                           //

    public Image animatePacman_Idle(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return pacmanFrames_Idle[clampedRow][clampedCol];
    }

    public Image animatePacman_U(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return pacmanFrames_U[clampedRow][clampedCol];
    }

    public Image animatePacman_D(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return pacmanFrames_D[clampedRow][clampedCol];
    }

    public Image animatePacman_L(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return pacmanFrames_L[clampedRow][clampedCol];
    }

    public Image animatePacman_R(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return pacmanFrames_R[clampedRow][clampedCol];
    }

    public Image animatePacman_Death(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return pacmanDeathFrames [clampedRow][clampedCol];
    }


    //                     v      Ghost Frames      v                           //

    public Image animateTimeUpGhost(int col, int row) {
        int clampedCol = Math.min(col, timeUpGhostFrames[0].length - 1);
        int clampedRow = Math.min(row, timeUpGhostFrames.length - 1);
        return timeUpGhostFrames [clampedRow][clampedCol];
    }

    public Image animateGhostScatter(int col, int row) {
        int clampedCol = Math.min(col, timeUpGhostFrames[0].length - 1);
        int clampedRow = Math.min(row, timeUpGhostFrames.length - 1);
        return ghostScatterFrames [clampedRow][clampedCol];
    }

    public Image animateGhostDeath_U(int col, int row) {
        int clampedCol = Math.min(col, ghostDeathFrames_U[0].length - 1);
        int clampedRow = Math.min(row, timeUpGhostFrames.length - 1);
        return ghostDeathFrames_U [clampedRow][clampedCol];
    }

    public Image animateGhostDeath_D(int col, int row) {
        int clampedCol = Math.min(col, ghostDeathFrames_D[0].length - 1);
        int clampedRow = Math.min(row, timeUpGhostFrames.length - 1);
        return ghostDeathFrames_D [clampedRow][clampedCol];
    }

    public Image animateGhostDeath_L(int col, int row) {
        int clampedCol = Math.min(col, ghostDeathFrames_L[0].length - 1);
        int clampedRow = Math.min(row, timeUpGhostFrames.length - 1);
        return ghostDeathFrames_L [clampedRow][clampedCol];
    }

    public Image animateGhostDeath_R(int col, int row) {
        int clampedCol = Math.min(col, ghostDeathFrames_R[0].length - 1);
        int clampedRow = Math.min(row, timeUpGhostFrames.length - 1);
        return ghostDeathFrames_R [clampedRow][clampedCol];
    }


        // ------------------- Blinky ------------------- //

    public Image animateBlinky_Idle(int col, int row) {
        int clampedCol = Math.min(col, blinkyFrames_R[0].length - 1);
        int clampedRow = Math.min(row, blinkyFrames_R.length - 1);
        return blinkyFrames_Idle[clampedRow][clampedCol];
    }

    public Image animateBlinky_U(int col, int row) {
        int clampedCol = Math.min(col, blinkyFrames_R[0].length - 1);
        int clampedRow = Math.min(row, blinkyFrames_R.length - 1);
        return blinkyFrames_U[clampedRow][clampedCol];
    }

    public Image animateBlinky_D(int col, int row) {
        int clampedCol = Math.min(col, blinkyFrames_R[0].length - 1);
        int clampedRow = Math.min(row, blinkyFrames_R.length - 1);
        return blinkyFrames_D[clampedRow][clampedCol];
    }

    public Image animateBlinky_L(int col, int row) {
        int clampedCol = Math.min(col, pacmanFrames_R[0].length - 1);
        int clampedRow = Math.min(row, pacmanFrames_R.length - 1);
        return blinkyFrames_L[clampedRow][clampedCol];
    }

    public Image animateBlinky_R(int col, int row) {
        int clampedCol = Math.min(col, blinkyFrames_R[0].length - 1);
        int clampedRow = Math.min(row, blinkyFrames_R.length - 1);
        return blinkyFrames_R[clampedRow][clampedCol];
    }

            // ------------------- Clyde ------------------- //

        public Image animateClyde_Idle(int col, int row) {
            int clampedCol = Math.min(col, clydeFrames_R[0].length - 1);
            int clampedRow = Math.min(row, clydeFrames_R.length - 1);
            return clydeFrames_Idle[clampedRow][clampedCol];
        }
    
        public Image animateClyde_U(int col, int row) {
            int clampedCol = Math.min(col, clydeFrames_R[0].length - 1);
            int clampedRow = Math.min(row, clydeFrames_R.length - 1);
            return clydeFrames_U[clampedRow][clampedCol];
        }
    
        public Image animateClyde_D(int col, int row) {
            int clampedCol = Math.min(col, clydeFrames_R[0].length - 1);
            int clampedRow = Math.min(row, clydeFrames_R.length - 1);
            return clydeFrames_D[clampedRow][clampedCol];
        }
    
        public Image animateClyde_L(int col, int row) {
            int clampedCol = Math.min(col, clydeFrames_R[0].length - 1);
            int clampedRow = Math.min(row, clydeFrames_R.length - 1);
            return clydeFrames_L[clampedRow][clampedCol];
        }
    
        public Image animateClyde_R(int col, int row) {
            int clampedCol = Math.min(col, clydeFrames_R[0].length - 1);
            int clampedRow = Math.min(row, clydeFrames_R.length - 1);
            return clydeFrames_R[clampedRow][clampedCol];
        }
    
            // ------------------- Inky ------------------- //

        public Image animateInky_Idle(int col, int row) {
            int clampedCol = Math.min(col, inkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, inkyFrames_R.length - 1);
            return inkyFrames_Idle[clampedRow][clampedCol];
        }
    
        public Image animateInky_U(int col, int row) {
            int clampedCol = Math.min(col, inkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, inkyFrames_R.length - 1);
            return inkyFrames_U[clampedRow][clampedCol];
        }
    
        public Image animateInky_D(int col, int row) {
            int clampedCol = Math.min(col, inkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, inkyFrames_R.length - 1);
            return inkyFrames_D[clampedRow][clampedCol];
        }
    
        public Image animateInky_L(int col, int row) {
            int clampedCol = Math.min(col, inkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, inkyFrames_R.length - 1);
            return inkyFrames_L[clampedRow][clampedCol];
        }
    
        public Image animateInky_R(int col, int row) {
            int clampedCol = Math.min(col, inkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, inkyFrames_R.length - 1);
            return inkyFrames_R[clampedRow][clampedCol];
        }
    
            // ------------------- Pinky ------------------- //

        public Image animatePinky_Idle(int col, int row) {
            int clampedCol = Math.min(col, pinkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, pinkyFrames_R.length - 1);
            return pinkyFrames_Idle[clampedRow][clampedCol];
        }
    
        public Image animatePinky_U(int col, int row) {
            int clampedCol = Math.min(col, pinkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, pinkyFrames_R.length - 1);
            return pinkyFrames_U[clampedRow][clampedCol];
        }
    
        public Image animatePinky_D(int col, int row) {
            int clampedCol = Math.min(col, pinkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, pinkyFrames_R.length - 1);
            return pinkyFrames_D[clampedRow][clampedCol];
        }
    
        public Image animatePinky_L(int col, int row) {
            int clampedCol = Math.min(col, pinkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, pinkyFrames_R.length - 1);
            return pinkyFrames_L[clampedRow][clampedCol];
        }
    
        public Image animatePinky_R(int col, int row) {
            int clampedCol = Math.min(col, pinkyFrames_R[0].length - 1);
            int clampedRow = Math.min(row, pinkyFrames_R.length - 1);
            return pinkyFrames_R[clampedRow][clampedCol];
        }
    
    
}
