public final class Mutex {

    private volatile boolean locked = false;

    public synchronized boolean acquire() {
        if (!locked) {
            locked = true;
            return true;
        }
        return false;
    }

    public synchronized void release() {
        locked = false;
    }
}