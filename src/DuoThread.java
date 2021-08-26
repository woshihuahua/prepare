import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DuoThread {
    public volatile static boolean flag = true;
    public volatile static int i = 1;
    public volatile static char cc = 'a';
    public volatile static int container = 5;
    public volatile static int food = 0;
    public volatile static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);

    public Object object1 = new Object();
    public Object object2 = new Object();
    public void printAB() {
        final Lock lock = new ReentrantLock();


        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {

                while (i < 100) {
                    lock.lock();
                    if (flag) {
                        System.out.println(i + " from: " + Thread.currentThread());
                        i++;
                        flag = !flag;
                    }
                    lock.unlock();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {

                while (i < 100) {
                    lock.lock();
                    if (!flag) {
                        System.out.println(i + " from: " + Thread.currentThread());
                        i++;
                        flag = !flag;
                    }
                    lock.unlock();
                }
            }
        });
        a.start();
        b.start();

    }

    public void printABC() {
        Lock lk1 = new ReentrantLock();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 10) {
                    lk1.lock();
                    if (cc == 'a') {
                        i++;
                        System.out.println(cc);
                        cc = 'b';
                    }
                    lk1.unlock();
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 10) {
                    lk1.lock();
                    if (cc == 'b') {
                        i++;
                        System.out.println(cc);
                        cc = 'c';
                    }
                    lk1.unlock();
                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 10) {
                    lk1.lock();
                    if (cc == 'c') {
                        i++;
                        System.out.println(cc);
                        cc = 'a';
                    }
                    lk1.unlock();
                }
            }
        });
        A.start();
        B.start();
        C.start();
    }

    public void eatThing() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 10) {
                    lock.lock();
                    if (food == 0) {
                        try {
                            System.out.println("nothing to eat");
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    food--;
                    condition.signalAll();
                    System.out.println("eat,food remains: " + food + " " + Thread.currentThread());
                    i++;
                    lock.unlock();
                }
            }
        });
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (i < 10) {
                    lock.lock();
                    if (food >= container) {
                        try {
                            System.out.println("food enough");
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    food++;
                    condition.signalAll();
                    System.out.println("produce food: " + food + " " + Thread.currentThread());
                    i++;
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();

    }

    public void block() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int aa = 0; aa < 6; aa++) {
                    try {
                        Thread.sleep(10);
                        queue.offer("food");
                        System.out.println("produce one food and now food is :" + queue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int aa = 0; aa < 6; aa++) {
                    try {
                        Thread.sleep(100);
                        System.out.println(queue.take() + " now food is :" + queue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        A.start();
        B.start();
    }

    public void DeadLock(){
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1){
                    System.out.println(Thread.currentThread() + "get obj1");
                    try {

                        Thread.sleep(100);
                        System.out.println(Thread.currentThread() + "try to get obj2");
                        synchronized (object2){
                            System.out.println(Thread.currentThread() + "get obj2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2){
                    System.out.println(Thread.currentThread() + "get obj2");
                    try {

                        Thread.sleep(100);
                        System.out.println(Thread.currentThread() + "try to get obj1");
                        synchronized (object1){
                            System.out.println(Thread.currentThread() + "get obj1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        });
        A.start();
        B.start();
    }

    public static void main(String[] args) {
        DuoThread D = new DuoThread();
        D.DeadLock();

    }

}
