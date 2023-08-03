class TestThread extends Thread {
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestThread t1 = new TestThread();
        System.out.println("State of thread " + t1.getName() + " : " + t1.getState()); // NEW

        t1.start();
        System.out.println("State of thread " + t1.getName() + " : " + t1.getState()); // RUNNABLE

        Thread.sleep(200);  // Main thread sleep
        System.out.println("State of thread " + t1.getName() + " : " + t1.getState()); // TIMED_WAITING

        Thread.sleep(1000); // Main thread sleep
        System.out.println("State of thread " + t1.getName() + " : " + t1.getState()); // TERMINATED
    }
}
