public class Main {
    private volatile boolean flag = false;

    public static void main(String[] args) {
        Main main = new Main();

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            main.flag = true;
            System.out.println("Writer thread has updated the flag to true");
        });

        Thread readerThread = new Thread(() -> {
            while (!main.flag) {
                // Busy-wait until the flag becomes true
            }
            System.out.println("Reader thread has noticed the flag is true");
        });

        writerThread.start();
        readerThread.start();
    }
}
