public class Demo {
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
            while (true) {
                synchronized (lock) {
                    if (count > 100) {
                        break; // 结束条件
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + count);
                    count++;
                    lock.notify(); // 唤醒另一个线程
                    try {
                        if (count <= 100) {
                            lock.wait(); // 当前线程等待
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
