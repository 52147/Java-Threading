import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        System.out.println("Initial value: " + atomicInteger.get());

        atomicInteger.set(10);
        System.out.println("After set(10): " + atomicInteger.get());

        atomicInteger.incrementAndGet();
        System.out.println("After incrementAndGet(): " + atomicInteger.get());

        atomicInteger.addAndGet(5);
        System.out.println("After addAndGet(5): " + atomicInteger.get());

        boolean wasUpdated = atomicInteger.compareAndSet(10, 15);
        System.out.println("Was the value updated?: " + wasUpdated);
        System.out.println("Value after compareAndSet: " + atomicInteger.get());
    }
}
