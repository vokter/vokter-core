package argus.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class that generates and returns a unique id from an incrementer, meaning that
 * every newly generated id will be the previously generated id + 1.
 * Note: This method differs from a simple static integer counter by being
 * thread-safe.
 *
 * @author Eduardo Duarte (<a href="mailto:eduardo.miguel.duarte@gmail.com">eduardo.miguel.duarte@gmail.com</a>)
 * @version 1.0
 */
public final class SynchronizedCounter {
    private final AtomicInteger sNextGeneratedId;

    public SynchronizedCounter() {
        sNextGeneratedId = new AtomicInteger(1);
    }


    public int getAndIncrement() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            int newValue = result + 1;

            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}