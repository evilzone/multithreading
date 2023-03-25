package com.multithreading.synchronization;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int item) {
        synchronized (queue) {
            while(queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {

                }
            }
            queue.add(item);
            queue.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (queue) {
            while(queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {

                }
            }
            int element = queue.remove();
            queue.notifyAll();
            return element;
        }
    }
}
