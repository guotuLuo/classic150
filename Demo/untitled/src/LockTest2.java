public class LockTest2 {

    public final static Object lock = new Object();
    public static int count = 0;
    public static int ThreadId = 0;


    public static class PrintStack implements Runnable {
        public int id = (int) Thread.currentThread().getId();
        public PrintStack(int id){
            this.id = id;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while(ThreadId != this.id){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (count > 100) {
                        lock.notifyAll();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + String.valueOf(count));
                    count++;
                    ThreadId = (ThreadId + 1) % 3;
                    lock.notifyAll();
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

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintStack(0));
        Thread t2 = new Thread(new PrintStack(1));
        Thread t3 = new Thread(new PrintStack(2));

        t1.start();
        t2.start();
        t3.start();
    }
}


