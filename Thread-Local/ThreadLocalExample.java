public class ThreadLocalExample {

    // Create a ThreadLocal instance
    private static ThreadLocal<Integer> threadLocalCount = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0; // initial value for each thread
        }
    };

    public static void main(String[] args) {

        // create first thread
        Thread thread1 = new Thread(() -> {
            incrementCount();
            printCount("Thread-1");
        });

        // create second thread
        Thread thread2 = new Thread(() -> {
            incrementCount();
            incrementCount();
            printCount("Thread-2");
        });

        // start both threads
        thread1.start();
        thread2.start();
    }

    private static void incrementCount() {
        threadLocalCount.set(threadLocalCount.get() + 1);
    }

    private static void printCount(String threadName) {
        System.out.println(threadName + ": " + threadLocalCount.get());
    }
}
