import java.util.concurrent.CountDownLatch;

public class cld {
    public static void count() throws InterruptedException {
        CountDownLatch cld = new CountDownLatch(3);

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A is awaiting");
                try {
                    Thread.sleep(10);
                    cld.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B is awaiting");
                try {
                    Thread.sleep(10);
                    cld.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("C is awaiting");
                try {
                    Thread.sleep(10);
                    cld.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        A.start();
        B.start();
        C.start();
        cld.await();
        System.out.println("finish");
    }

    public static void main(String[] args) throws InterruptedException {
        cld.count();
    }

}
