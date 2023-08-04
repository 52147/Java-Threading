public class Main implements Runnable {

    @Override
    public void run() {
        System.out.println("Executing thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // Creating an instance of the MyRunnable class
        Main myRunnable = new Main();

        // Creating a new thread with MyRunnable as its task
        Thread thread = new Thread(myRunnable, "MyThread");

        // Starting the new thread. This will call the run() method in the new thread context.
        System.out.println("Calling start() method:");
        thread.start();

        // Directly calling the run() method. This will execute in the current thread context.
        System.out.println("Calling run() method:");
        myRunnable.run();
    }
}
