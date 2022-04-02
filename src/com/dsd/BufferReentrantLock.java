package com.dsd;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferReentrantLock {
    private LinkedList<Object> buffer;
    private int size;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();


    public BufferReentrantLock(int size) {
        this.size = size;
        this.buffer = new LinkedList<Object>();
    }

    public void input(Object in) throws InterruptedException {
        try {
            lock.lock();
            while (buffer.size() >= size)
                full.await();
            buffer.add(in);
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object output() throws InterruptedException {
        try {
            lock.lock();
            while (buffer.size() < 1)
                empty.await();
            full.signalAll();
            return buffer.removeFirst();
        } finally {
            lock.unlock();
        }
    }
}
