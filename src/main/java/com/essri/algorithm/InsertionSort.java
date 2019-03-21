package com.essri.algorithm;

public class InsertionSort {
    int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        int pivot = 1;

        while(pivot != array.length) {
            compare(pivot);
            pivot++;
        }

        return array;
    }

    public void compare(int pivot) {
        int thisPivot = array[pivot];
        int i;

        for(i = pivot-1; i >= 0 && thisPivot < array[i]; i--) {
            array[i+1] = array[i];
        }

        array[i+1] = thisPivot;

    }

    public void swap (int index, int index2) {
        int temp = array[index];
        array[index] = array[index2];
        array[index2] = temp;
    }
}
