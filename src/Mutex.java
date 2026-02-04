/**
 * A simple spinlock-style mutual exclusion (mutex) implementation.
 *
 * <p>This mutex allows only one thread at a time to acquire the lock.
 * Threads attempting to acquire the lock must repeatedly call
 * {@link #acquire()} until it returns {@code true}.
 *
 * <p>This implementation uses:
 * <ul>
 *   <li>{@code synchronized} to ensure mutual exclusion during lock
 *       acquisition and release</li>
 *   <li>{@code volatile} to guarantee visibility of the lock state
 *       across threads</li>
 *   <li>{@code final} to prevent subclassing, which could compromise
 *       thread safety</li>
 * </ul>
 *
 * <p>This mutex does not provide fairness guarantees and uses busy-waiting,
 * which may result in higher CPU usage. It is intended for educational
 * purposes rather than production use.
 */
public final class Mutex {

    /**
     * Indicates whether the mutex is currently held.
     *
     * <p>Declared {@code volatile} to ensure that changes to the lock state
     * are immediately visible to all threads.
     */
    private volatile boolean locked = false;

    /**
     * Attempts to acquire the mutex.
     *
     * <p>If the mutex is not currently locked, this method acquires the
     * lock and returns {@code true}. If the mutex is already locked,
     * this method returns {@code false} and the caller is expected
     * to retry.
     *
     * @return {@code true} if the lock was successfully acquired;
     *         {@code false} otherwise
     */
    public synchronized boolean acquire() {
        if (!locked) {
            locked = true;
            return true;
        }
        return false;
    }

    /**
     * Releases the mutex.
     *
     * <p>After calling this method, another thread may successfully
     * acquire the mutex.
     */
    public synchronized void release() {
        locked = false;
    }
}
