package projectpacman.GhostLogic;

/**
 * Abstract Method for the different ghosts to inherit and implement their own chase method
 */
public abstract class ChaseMethod {
    protected GhostEntity ghostEntity;

    public void setEntity(GhostEntity ghostEntity) {
        this.ghostEntity = ghostEntity;
    }

    public abstract void chase();
}
