package com.dsd;

import java.util.LinkedList;

public class BufferSynchronized {

    private LinkedList<Object> buffer;
    private int size;

    public BufferSynchronized (int size){
        this.size = size;
        this.buffer = new LinkedList<Object>();
    }

    synchronized boolean input (Object in){
        if(buffer.size()<size){
            buffer.add(in);
            return true;
            } else return false;
    }

    synchronized Object output (){
        return (buffer.size()>0) ? buffer.removeFirst() : null;
    }
}
