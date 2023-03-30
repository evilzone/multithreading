import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    private Random random = new Random();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();

    public void stageOne() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {

        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for(int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {

        App app = new App();

        System.out.println("starting ...");
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                app.process();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                app.process();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("time spend: " + (end - start));
        System.out.println("list1 size " + list1.size());
        System.out.println("list2 size " + list2.size());
    }
}
