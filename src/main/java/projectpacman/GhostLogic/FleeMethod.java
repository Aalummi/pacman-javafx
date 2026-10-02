package projectpacman.GhostLogic;

/**
 * Abstract Method for the different ghosts to inherit and implement their own flee method
 */
public abstract class FleeMethod {
    protected GhostEntity ghostEntity;

    public void setEntity(GhostEntity ghostEntity) {
        this.ghostEntity = ghostEntity;
    }

    public abstract void flee();
}
