class ThreadSleep extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500); // pauses for 500 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

class ThreadWait {
    public synchronized void waitForSignal() {
        try {
            wait(1000); // pauses for 1000 milliseconds or until notify()/notifyAll() is called
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        threadSleep.start(); // Starts the sleep thread

        ThreadWait threadWait = new ThreadWait();

        new Thread(() -> {
            try {
                Thread.sleep(1000);  // sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (threadWait) {
                System.out.println("About to call notify()");
                threadWait.notify();  // notify threadWait after 1 second
                System.out.println("Finished calling notify()");
            }
        }).start();

        synchronized (threadWait) {
            System.out.println("About to wait for signal");
            threadWait.waitForSignal(); // Wait for signal
            System.out.println("Finished waiting for signal");
        }
    }
}



