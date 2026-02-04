public final class Mutex {

    public synchronized boolean acquire() {
        return true;
    }

    public synchronized void release() {
        return;
    }
}