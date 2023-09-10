public class ThreadExceptionExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("An exception from the thread");
        });

        // Set an UncaughtExceptionHandler
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Caught " + e + " from thread " + t.getName());
            }
        });

        // Start the thread
        thread.start();
    }
}
