public class App {

    public static void main(String[] args) {

        Thread  thread1 = new Thread(new Runner());
        thread1.start();

        Thread  thread2 = new Thread(new Runner());
        thread2.start();

    }

}
