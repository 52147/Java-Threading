// "static void main" must be defined in a public class.
class MyThread extends Thread {
    public void run() {
      for(int i=0; i<10; i++){
        System.out.println(Thread.currentThread().getId() +" Value "+ i);
      }
    }
  }
  
  public class Main {
    public static void main(String args[]) {
      MyThread t1 = new MyThread();
      t1.start();
      
      MyThread t2 = new MyThread();
      t2.start();
    } 
  }
  