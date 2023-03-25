package com.multithreading.synchronization;

public class Stack {

    private int[] stack;
    private int stackTop;
    Object lock;

    public Stack(int capacity) {
        stack = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= stack.length - 1;
    }

    // both synchronized blocks are bounded by same lock object
    public boolean push(int element) {
        synchronized(lock) {
            if(isFull()) { return false; }
            ++ stackTop;

            try { Thread.sleep(1000); } catch (Exception e) { }

            stack[stackTop] = element;
            return true;
        }
    }

    /*
        public synchronized boolean push(int element) {
            if(isFull()) { return false; }
            ++ stackTop;

            try { Thread.sleep(1000); } catch (Exception e) { }

            stack[stackTop] = element;
            return true;
        }

        public boolean push(int element) {
            synchronized(this) { // instance of this object
                if(isFull()) { return false; }
                ++ stackTop;

                try { Thread.sleep(1000); } catch (Exception e) { }

                stack[stackTop] = element;
                return true;
            }
        }
     */

    public int pop() {
        synchronized(lock) {
            if(isEmpty()) { return Integer.MIN_VALUE; }

            int obj = stack[stackTop];
            stack[stackTop] = Integer.MIN_VALUE;

            try { Thread.sleep(1000); } catch (Exception e) { }

            -- stackTop;
            return obj;
        }
    }

}
