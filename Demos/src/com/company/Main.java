package com.company;

public class Main {

    public static void main(String[] args){
        Array array = new Array(3);
        array.insert(1);
        array.insert(10);
        array.insert(12);
        //array.print();

        array.insert(100);
        array.print();
        //array.removeAt(3);
        //array.print();

        //System.out.println(array.indexOf(10));
    }
}


