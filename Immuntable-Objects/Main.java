public class Main {

    public static void main(String[] args) {
        ImmutableValue myValue = new ImmutableValue(5);

        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1 - Value: " + myValue.getValue());
            }
        };
        
        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2 - Value: " + myValue.getValue());
            }
        };
        
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        
        thread1.start();
        thread2.start();
    }
}

final class ImmutableValue {
    private final int value;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // No setter method to modify the value
}
