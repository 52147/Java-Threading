class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
            System.out.println("Running " + getName() + " : " + i);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.setName("Thread 1");
        thread1.start(); // starts thread1 execution

        MyThread thread2 = new MyThread();
        thread2.setName("Thread 2");
        thread2.start(); // starts thread2 execution

        Thread mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainThread.interrupt();  // interrupt main thread after 2 seconds
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted!");
        }
    }
}
