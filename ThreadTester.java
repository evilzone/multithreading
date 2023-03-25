package com.multithreading;

public class ThreadTester {

    public static void main(String[] args) {

        System.out.println("main is starting");

        Thread thread1 = new Thread1("thread1");
        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "thread2");
        thread2.start();

        System.out.println("main is exiting");

        Thread thread3 = new Thread(() -> {System.out.println("abhinav");});
        // compiler generates the boilerplate code
        thread3.start();
    }
}
