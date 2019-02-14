package com.essri.algorithm;

public class SelectionSort {
    public static int[] sort(int[] arr) {
        int index;
        int temp;

        for(int i = 0; i < arr.length-1; i++) {
            index = i;

            for(int j = i+1; j < arr.length; j++) {
                if(arr[index] > arr[j]) {
                    index = j;
                }
            }

            if(i != index) {
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        return arr;
    }
}
