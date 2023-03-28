public class App {
    public static void main(String[] args) {

        Thread thread1 = new Runner();
        thread1.start();

        Thread thread2 = new Runner();
        thread2.start();

    }
}
