package com.dsd;

public class TestBuffer {
    int number;
    char name;

    TestBuffer (){

    }

    TestBuffer (int number, char name){
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBuffer{" +
                "number=" + number +
                ", name=" + name +
                '}';
    }
}
