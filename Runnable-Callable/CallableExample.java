import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableExample implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello from Callable!";
    }

    public static void main(String[] args) throws Exception {
        CallableExample callableExample = new CallableExample();
        FutureTask<String> futureTask = new FutureTask<>(callableExample);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

