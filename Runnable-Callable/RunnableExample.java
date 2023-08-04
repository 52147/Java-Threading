public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from Runnable!");
    }

    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample();
        Thread thread = new Thread(runnableExample);
        thread.start();
    }
}
