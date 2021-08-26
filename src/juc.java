import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class juc {
    public static void main(String[] args) {
        ab test1 = new ab();
        //abc test2 = new abc();
        test1.printAB();
        //abc.printABC();
        //proCon test3 = new proCon();
        //test3.printPC();
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
//        new Thread(new producer(queue)).start();
//        new Thread(new consumer(queue)).start();
//        new Thread(new consumer(queue)).start();
//        new Thread(new consumer(queue)).start();
//        deadLock dd = new deadLock();
//        dd.DL();
    }
}
class ab{
    static int cnt = 0;
    static boolean flag = false;
    static void printAB(){
        final Lock lock = new ReentrantLock();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while(cnt<100){
                    lock.lock();
                    if(flag){
                        System.out.println(Thread.currentThread().getName() + ' ' + cnt++);
                        flag = false;
                    }
                    lock.unlock();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while(cnt<100){
                    lock.lock();
                    if(!flag){
                        System.out.println(Thread.currentThread().getName() + ' ' + cnt++);
                        flag = true;
                    }
                    lock.unlock();
                }
            }
        });
        threadA.start();
        threadB.start();

    }
}
class abc{
    static int num = 0;
    volatile  static int cnt = 0;
    static void printABC(){
        final Lock lock = new ReentrantLock();
        Thread A = new Thread(new Runnable() {
            @Override

            public void run() {
                while(cnt < 100){
                    lock.lock();
                    if(cnt % 3 == 0){
                        System.out.println(Thread.currentThread().getName() + " : A");
                        cnt++;

                    }
                    lock.unlock();
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override

            public void run() {
                while(cnt < 100){
                    lock.lock();
                    if(cnt % 3 == 1){
                        System.out.println(Thread.currentThread().getName() + " : B");
                        cnt++;

                    }
                    lock.unlock();
                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override

            public void run() {
                while(cnt < 100){
                    lock.lock();
                    if(cnt % 3 == 2){
                        System.out.println(Thread.currentThread().getName() + " : C");
                       cnt++;

                    }
                    lock.unlock();
                }
            }
        });
        A.start();
        B.start();
        C.start();
    }
}
class proCon{
    static int num = 0;
    static int cnt = 0;
    static void printPC(){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread con = new Thread(new Runnable() {
            @Override
            public void run() {
                while(cnt < 100){
                    lock.lock();
                    try{
                        if(num == 0){
                            condition.await();
                        }
                        cnt++;
                        num--;
                        System.out.println(Thread.currentThread().getName() + " consume one");
                        condition.signalAll();

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }

                }
            }
        });
        Thread pro = new Thread(new Runnable() {
            @Override
            public void run() {
                while(cnt<100){
                    lock.lock();
                    try {
                        if(num > 5){
                            condition.await();
                        }
                        cnt++;
                        num++;
                        System.out.println(Thread.currentThread().getName() + " produce one");
                        condition.signalAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        pro.start();
        con.start();
    }
}
class consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    public consumer(BlockingQueue<Integer> queue){this.queue = queue;}

    @Override
    public void run() {
        try {
            while(true){
                Thread.sleep(50);
                int i = queue.take();
                System.out.println("consume " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class producer implements Runnable{
private BlockingQueue<Integer> queue;
public producer(BlockingQueue<Integer> queue){this.queue = queue;}
    @Override
    public void run() {
        try {
            for(int i = 0;i<100;i++){
                Thread.sleep(50);
                queue.put(i);
                System.out.println("produce + " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class deadLock{
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void DL(){
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    System.out.println("获得锁A");

                try {
                   Thread.sleep(1);
                    System.out.println("尝试获得锁B");
                    synchronized (object2) {
                        System.out.println("B");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}

            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2) {
                    System.out.println("获得锁B");

                try {
                    Thread.sleep(1);
                    System.out.println("尝试获得锁A");
                    synchronized (object1) {
                        System.out.println("A");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}

            }
        });
        threadA.start();
        threadB.start();
    }



}
class tp{
    public static void method_01() throws InterruptedException
    {    ExecutorService executor = Executors.newFixedThreadPool(1);
    for (int i = 0; i < 10; i++) {
        Thread.sleep(1000);
        final int index = i;
        executor.execute(() -> {
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e)
            { e.printStackTrace();}
            System.out.println(Thread.currentThread().getName() + "  " + index);
        });    }
    executor.shutdown();}

    public static void main(String[] args) throws InterruptedException {
        tp.method_01();
    }

}