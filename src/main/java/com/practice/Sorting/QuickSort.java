package com.practice.Sorting;

public class QuickSort {

    /**
     * Setting the pivot as the starting element in the array
     * @param arr the input array
     * @param low the starting index of the array
     * @param high the last index of the array
     * @return the final pivot position
     */
    private static int partition(int arr[], int low, int high){
        int pivotPos = low + 1;
        int pivot = arr[low];
        for(int j = low + 1; j <=high; j++){
            if(arr[j]<pivot) {
                swap(pivotPos, j, arr);
                pivotPos++;
            }
        }
        swap(low, pivotPos - 1, arr);
        return pivotPos-1;
    }

    /**
     * Setting the pivot as the end of the array
     * @param arr the input array to be sorted
     * @param low the starting index of the array
     * @param high the ending index of the array
     * @return the pivot position after sorting
     */
    private static int partition_2(int arr[], int low, int high) {
        int pivot = arr[high];
        int rightPointer = high;
        int leftPointer = low-1;
        while(true){
            while(leftPointer < high && arr[++leftPointer] < pivot);

            while (rightPointer > 0 && arr[--rightPointer] > pivot);

            if(leftPointer >= rightPointer){
                break;
            } else {
                swap(leftPointer, rightPointer, arr);
            }
        }
        swap(leftPointer, high, arr);
        return leftPointer;
    }

    /**
     * Swapping elements
     * @param i the first index
     * @param j the second index
     * @param array the array in which the sorting needs to take place
     */
    private static void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Sort using the first element as pivot
     * @param input the array to be sorted
     * @param start the starting index of the array
     * @param end the last index of the array
     */
    public static void quickSort(int[] input, int start, int end){
        if(start < end){
            int pivotPos = partition(input, start, end);
            quickSort(input, start, pivotPos-1);
            quickSort(input, pivotPos+1, end);
        }
    }

    /**
     * Sort using the last element as pivot
     * @param input the array to be sorted
     * @param start the starting index of the array
     * @param end the last index of the array
     */
    public static void quickSort_2(int[] input, int start, int end){
        if(start < end){
            int pivotPos = partition_2(input, start, end);
            quickSort_2(input, start, pivotPos-1);
            quickSort_2(input, pivotPos+1, end);
        }
    }
}
