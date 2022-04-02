package com.dsd;

public class BufferThread1 implements Runnable{
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

        for (int i = 0; i<10; i++){
            if (!buffer.input(new TestBuffer(i+1, ((char)(i+65))))) i--;
        }
        System.out.println("поток 1 след задание");

        for (int i = 0; i<10; i++){
            try {
                buffer2.input(new TestBuffer(i+1, ((char)(i+65))));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
