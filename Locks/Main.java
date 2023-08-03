import java.util.concurrent.locks.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Example for Mutex Lock
        SharedResourceMutex sharedResourceMutex = new SharedResourceMutex();
        Thread thread1 = new Thread(sharedResourceMutex::accessResource);
        Thread thread2 = new Thread(sharedResourceMutex::accessResource);
        thread1.start();
        thread2.start();

        // Ensure both threads have finished execution
        thread1.join();
        thread2.join();

        // Example for Condition Locks
        SharedResourceCondition sharedResourceCondition = new SharedResourceCondition();
        Thread thread3 = new Thread(() -> {
            try {
                sharedResourceCondition.waitForCondition();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread4 = new Thread(sharedResourceCondition::changeCondition);
        thread3.start(); // will wait because condition is not met
        Thread.sleep(2000); // simulate some delay
        thread4.start(); // will change the condition

        // Example for Read-Write Locks
        SharedResourceRW sharedResourceRW = new SharedResourceRW();
        Thread thread5 = new Thread(sharedResourceRW::readResource);
        Thread thread6 = new Thread(sharedResourceRW::writeResource);
        thread5.start(); // can proceed concurrently with other read threads
        thread6.start(); // will wait for reading threads to finish
    }
}

// Mutex lock class
class SharedResourceMutex {
    private final Lock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is accessing the resource.");
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

// Condition lock class
class SharedResourceCondition {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean conditionMet = false;

    public void waitForCondition() throws InterruptedException {
        lock.lock();
        try {
            while (!conditionMet) {
                System.out.println(Thread.currentThread().getName() + " is waiting.");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + " has continued execution.");
        } finally {
            lock.unlock();
        }
    }

    public void changeCondition() {
        lock.lock();
        try {
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " has changed the condition.");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

// Read-Write lock class
class SharedResourceRW {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void readResource() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is reading.");
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void writeResource() {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is writing.");
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
