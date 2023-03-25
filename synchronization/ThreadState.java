package com.multithreading.synchronization;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        /*
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                for(int i = 10; i >= 0; i--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "states");
        thread3.start();

        while (true) {
            Thread.State state = thread3.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED) break;
        }
        */

        Thread thread = new Thread(() ->
        {
            System.out.println(Thread.currentThread());
        }, "Our thread");

        thread.start();
        thread.join();

        System.out.println("main is exiting");
    }
}
