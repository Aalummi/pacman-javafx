package projectpacman.GhostLogic;

/**
 * Builder class that uses interface chaining to require a uniform way of setting up a ghost
 * ensures that the ghost must be configured in this way
 * 
 * Check blinky.java to see how its used
 */
public class Ghost {
    private final String ghostname;
    private final ChaseMethod chaseMethod;
    private final FleeMethod fleeMethod;
    private final int delay;

    private Ghost(String name, ChaseMethod chaseMethod, FleeMethod fleeMethod, int delayTime) {
        this.ghostname = name;
        this.chaseMethod = chaseMethod;
        this.fleeMethod = fleeMethod;
        this.delay = delayTime;
    }

    public static GhostName Builder() {
        return new Builder();
    }

    public interface GhostName {
        GhostChaseMethod setGhostName(String ghostName);
    }

    public interface GhostChaseMethod {
        GhostFleeMethod setChaseMethod(ChaseMethod chaseMethod);
    }

    public interface GhostFleeMethod {
        GhostDelay setFleeMethod(FleeMethod fleeMethod);
    }

    public interface GhostDelay {
        GhostBuilder setGhostDelay(int delay);
    }

    public interface GhostBuilder {
        Ghost build();
    }

    static class Builder implements
            GhostName, GhostChaseMethod, GhostFleeMethod, GhostDelay, GhostBuilder {

        private String ghostname;
        private ChaseMethod chaseMethod;
        private FleeMethod fleeMethod;
        private int delayTime;

        @Override
        public GhostChaseMethod setGhostName(String ghostName) {
            this.ghostname = ghostName;
            return this;
        }

        @Override
        public GhostFleeMethod setChaseMethod(ChaseMethod chaseMethod) {
            this.chaseMethod = chaseMethod;
            return this;
        }

        @Override
        public GhostDelay setFleeMethod(FleeMethod fleeMethod) {
            this.fleeMethod = fleeMethod;
            return this;
        }

        @Override
        public GhostBuilder setGhostDelay(int delay) {
            this.delayTime = delay;
            return this;
        }

        @Override
        public Ghost build() {
            System.out.println("(Ghost.java): Final ghost delay for " + ghostname + " is " + delayTime);
            Ghost builtGhost = new Ghost(ghostname, chaseMethod, fleeMethod, delayTime);
            return builtGhost;
        }
    }

    public String getGhostname() {
        return ghostname;
    }

    public ChaseMethod getChaseMethod() {
        return chaseMethod;
    }

    public FleeMethod getFleeMethod() {
        return fleeMethod;
    }

    public int getGhostDelay() {
        return delay;
    }
}
