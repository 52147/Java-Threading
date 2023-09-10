public class Main {
    public static void main(String[] args) {
        SingleThreadedConcurrency.example();
    }

    public static class SingleThreadedConcurrency {
        public static void example() {
            Runnable task1 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Single-threaded Task 1 - Count: " + i);
                }
            };
            
            Runnable task2 = () -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Single-threaded Task 2 - Count: " + i);
                }
            };
            
            task1.run();
            task2.run();
        }
    }
    
}
