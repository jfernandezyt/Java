package com.company;

import java.util.stream.IntStream;

public class Array {
    private int length;
    private int[] array;
    private int count = 0;

    public Array(int length) {
        this.length = length;
        array = new int[this.length];
    }

    public void insert(int item){
        if (count == length)
            array = resize();

        array[count++] = item;
    }

    public void removeAt(int index){
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();
        else{
            array = IntStream.range(0, count)
                    .filter(i -> i != index)
                    .map(i -> array[i])
                    .toArray();
            count--;
        }
    }
    public int indexOf(int element){
        for (int i =0; i < count; i++)
            if(array[i] == element)
                return i;

        return -1;
    }

    private int[] resize(){
        int[] newArray = new int[count * 2];
        for (int i = 0; i < count; i++)
            newArray[i] = array[i];

        return newArray;
    }

    public void print(){
        for(int i = 0 ; i < count; i++)
            System.out.println(array[i]);
    }

}
