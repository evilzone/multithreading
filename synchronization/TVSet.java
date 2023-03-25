package com.multithreading.synchronization;

public class TVSet {

    private static volatile TVSet instance = null;

    private TVSet() {
        System.out.println("TV set is instantiated");
    }

    public static TVSet getInstance() {
        if(instance == null) { // optimization
            synchronized (TVSet.class) { // t2
                if(instance == null) { // double checking
                    instance = new TVSet();
                }
            }
        }
        // heavy work done here
        return instance;
    }

}

// time0 - t1, t2
// time5 - t5, t6, t7, ....
