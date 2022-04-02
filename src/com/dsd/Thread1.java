package com.dsd;

public class Thread1 implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i<4; i++){
            System.out.println("thread "+ Thread.currentThread().getName()+"  i="+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
