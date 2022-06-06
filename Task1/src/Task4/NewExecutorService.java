package Task4;

import java.util.concurrent.*;

public class NewExecutorService extends ThreadPoolExecutor {
    public NewExecutorService(int takeSize) {
        super(takeSize, takeSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }
}
