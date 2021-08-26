import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lianxi {
    public static volatile int flag = 0;
    public static volatile ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
    public static void printABC(){
        Lock lk = new ReentrantLock();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true){
                    if (flag == 0) {
                        lk.lock();
                        System.out.println('A');
                        flag = 1;
                        lk.unlock();
                    }
                }

            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true){
                    if (flag == 1) {
                        lk.lock();
                        System.out.println('B');
                        flag = 2;
                        lk.unlock();
                    }
                }

            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true){
                    if (flag == 2) {
                        lk.lock();
                        System.out.println('C');
                        flag = 0;
                        lk.unlock();
                    }
                }

            }
        });
        A.start();
        B.start();
        C.start();
    }

    public static void main(String[] args) {
        proCon();
    }
    public static void proCon(){
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag <= 100){
                    try {
                        Thread.sleep(10);
                        queue.put(flag);
                        flag++;
                        System.out.println("offer: + " + flag);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag <= 100){
                    try {
                        Thread.sleep(40);

                        System.out.println("consume: + " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
