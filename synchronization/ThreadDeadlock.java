package com.multithreading.synchronization;

public class ThreadDeadlock {

    public static void main(String[] args) {

        System.out.println("inside main");

        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread thread1 = new Thread(() -> {
            synchronized(lock1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized(lock2) {
                System.out.println("acquired lock2");
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            synchronized(lock2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized(lock1) {
                System.out.println("acquired lock1");
            }
        }, "thread2");


        thread1.start();
        thread2.start();

    }
}
