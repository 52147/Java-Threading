public class Main {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // get reference to the main thread
        System.out.println("Current thread: " + t.getName()); // prints "Current thread: main"
    }
}
