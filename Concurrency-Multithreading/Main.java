public class Main {
    public static void main(String[] args) {
        MultithreadedConcurrency.example();
    }

    public static class MultithreadedConcurrency {
        public static void example() {
            Runnable task1 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Multi-threaded Task 1 - Count: " + i);
                }
            };
            
            Runnable task2 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Multi-threaded Task 2 - Count: " + i);
                }
            };
            
            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);
            
            thread1.start();
            thread2.start();
        }
    }
}

