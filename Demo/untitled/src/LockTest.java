public class LockTest {
    private static final Object lock = new Object();
    private static int count = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask());
        Thread t2 = new Thread(new PrintTask());
        t1.start();
        t2.start();
    }

    public static class PrintTask implements Runnable {
        @Override
        public void run() {
            while(true){
                synchronized (lock) {
                    if (count > 100) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(count));
                    count++;
                    lock.notify();
                    try {
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
