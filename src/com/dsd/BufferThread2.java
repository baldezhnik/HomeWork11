package com.dsd;

import java.util.LinkedList;

public class BufferThread2 implements Runnable{
    BufferSynchronized buffer;
    BufferReentrantLock buffer2;

    public void setBuffer(BufferSynchronized buffer) {
        this.buffer = buffer;
    }

    public void setBuffer2(BufferReentrantLock buffer2) {
        this.buffer2 = buffer2;
    }

    @Override
    public void run() {

        for (int i=0; i<10; i++){ // Synchronized
            TestBuffer t = new TestBuffer();
            t = (TestBuffer) buffer.output();
            if (t==null) {
                i--;
            }
            else System.out.println(t.toString());
        }
        System.out.println(" поток 2 след задание");

        for (int i=0; i<10; i++){ //reentrant
            TestBuffer t = new TestBuffer();
            try {
                t = (TestBuffer) buffer2.output();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.toString());
        }

    }
}
