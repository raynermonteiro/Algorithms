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

    public static void printArray(int[][] arr) {
        System.out.println("-------------------------");
        for(int row = 0;row<arr.length;row++) {
            for(int col=0;col<arr[0].length;col++) {
                if(row==0) {
                    System.out.print(col+"\t");
                } else {
                    System.out.print(arr[row][col] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void printArray(int[][] a, String s1, String s2) {
        for(int row=0;row<a.length;row++){
            for(int col=0;col<a.length;col++) {
                if(row==0 && col>0){
                    System.out.print(s2.charAt(col-1)+ " ");
                } else if(col==0 && row>0){
                    System.out.print(s1.charAt(row-1)+ " ");
                }else {
                    System.out.print(a[row][col]+ " ");
                }
            }
            System.out.println();
        }
    }
}
