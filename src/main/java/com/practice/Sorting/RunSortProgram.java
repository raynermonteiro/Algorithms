package com.practice.Sorting;

import com.practice.common.ArrayUtil;

public class RunSortProgram {
    public static void main(String args[]) {
        ArrayUtil inputArray = new ArrayUtil(10);

        System.out.println("------------Using Quick Sort method 1------------");
        System.out.println("Un-Sorted Array");
        inputArray.printArray();
        QuickSort.quickSort(inputArray.array, 0, inputArray.size-1);
        System.out.println("\nSorted Array using "+QuickSort.class.getSimpleName()+" technique 1 is:");
        inputArray.printArray();


        ArrayUtil inputArray2 = new ArrayUtil(10);
        System.out.println("\n\n------------Using Quick Sort method 2------------");
        System.out.println("Un-Sorted Array using");
        inputArray2.printArray();
        QuickSort.quickSort_2(inputArray2.array, 0, inputArray2.size - 1);
        System.out.println("\nSorted Array using "+QuickSort.class.getSimpleName()+" technique 2 is:");
        inputArray2.printArray();
    }
}
