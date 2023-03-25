package com.multithreading.synchronization;

public class ThreadTester {

    public static void main(String[] args) {
        System.out.println("main is starting");

        Stack stack = new Stack(5);

        new Thread(() -> {
           int counter = 0;
           while( ++ counter < 10) {
               System.out.println("Pushed: " + stack.push(100));
           }
        }, "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while( ++ counter < 10) {
                System.out.println("Popped: " + stack.pop());
            }
        }, "Popped").start();

        System.out.println("main is exiting");

    }
}
