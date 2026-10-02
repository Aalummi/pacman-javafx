package projectpacman.Animator;

/*
 * Animation settings has important information for ensuring the animations work properly, mainly frames_per_animation
 * 
 */
public class animationSettings {
    
    /* These static final ints represents the metadata sorrounding the sprite sheet system.
     * frames_per_animation is used in BoardAnimator. 
     * frames_per_animation & columns_per_spritesheet used in AnimatedLayerRenderer
     * 
     * These are uniform for all sprite sheets, and making new 
     * animate sprite sheets requires these are fufilled.
     * 
     * SHOULD NOT be changed. Unless the sprite sheet's are changed uniformly
     */
    private static final int frames_per_animation = 30, columns_per_spritesheet = 30, rows_per_spritesheet = 1;

    
    /* pellet_power_delay is used in AnimatedLayerRenderer.render() to give a extra delay for the
     * pellets and powers to make them animate more smoothly.
     * 
     * CAN be changed. Higher values cause slower animation, Default = 30
     */
    private static final int pellet_power_delay = 30;
    private static final int entity_delay = 23;


    //Getter to get the amount of frames in a sprite sheet for other animation classes 
    public static int Frames_per_spritesheet() {
        // System.out.println("(animationSettings.java) : frames_per_animation requested : " + frames_per_animation);
        return frames_per_animation;
    }

    public static int columns_per_spritesheet() {
        // System.out.println("(animationSettings.java) : columns_per_spritesheet requested : " + columns_per_spritesheet);
        return columns_per_spritesheet;
    }

    public static int rows_per_spritesheet() {
        // System.out.println("(animationSettings.java) : rows_per_spritesheet requested : " + rows_per_spritesheet);
        return rows_per_spritesheet;
    }

    public static int getPelletPowerFrameDelay() {
        System.out.println("(animationSettings.java) : pellet_power_delay requested : " + pellet_power_delay);
        return pellet_power_delay;
    }

    public static int getEntityFrameDelay() {
        // System.out.println("(animationSettings.java) : player_delay requested : " + player_delay);
        return entity_delay;
    }


}
