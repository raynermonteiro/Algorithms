package com.practice.common;

public class ArrayUtil {
    public int array[];
    public int size;

    /**
     * @param size size of the array to be generated
     */
    public ArrayUtil(int size){
        this.size = size;
        array = new int[size];
        for(int i=0; i<this.size; i++){
            array[i] = (int)(Math.random()*99)+10;
        }
    }

    /**
     * Prints the array.
     */
    public void printArray(){
        for(int i=0; i< size; i++){
            System.out.print(array[i] + " ");
        }
    }
}
