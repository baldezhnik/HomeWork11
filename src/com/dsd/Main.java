package com.dsd;

public class Main {

    public static void main(String[] args) {

//        Thread1 Thread1 = new Thread1();
//        Thread t1 = new Thread(Thread1);
//        t1.setName("T2");
//        Thread t2 = new Thread(Thread1);
//        t2.setName("T2");
//        Thread t3 = new Thread(Thread1);
//        t3.setName("T3");
//        t3.start();
//        try {
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t2.start();
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t1.start();

        // 2 домашка
        // суть: поток Т1 генерирует 10 объектов BufferThread и оправляет в буфер вместимостью 3;
        // поток 2 достает из ,буфера и выводит на печать.
        //делает 2 раза , сначала синх, потом рин.

        BufferSynchronized buffer = new BufferSynchronized(3);
        BufferReentrantLock buffer2 = new BufferReentrantLock(3);
        BufferThread1 T1 = new BufferThread1();
        BufferThread2 T2 = new BufferThread2();
        T1.setBuffer(buffer);
        T2.setBuffer(buffer);
        T1.setBuffer2(buffer2);
        T2.setBuffer2(buffer2);
        Thread t1 = new Thread(T1);
        Thread t2 = new Thread(T2);
        t1.start();
        t2.start();


    }

}
