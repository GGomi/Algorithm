package com.essri.algorithm;

public class MergeSort {

    private int[] arr;
    private int[] tmparr;

    public MergeSort(int[] arr) {
        this.arr = arr;
        this.tmparr = new int[arr.length];
    }

    public int[] sort(int start, int end) {
        if(end > start) {
            sort(start, (start + end) / 2);
            sort((start + end) / 2 + 1, end);
        }

        merge(start, end);

        return arr;
    }

    public void merge(int start, int end) {
        int i = start, j = (start + end) / 2 + 1;
        int mid = (start + end) / 2;
        int count = start;

        while(i <= (start + end) / 2 && j <= end)
        {
            if(arr[i] > arr[j])
                tmparr[count++] = arr[j++];
            else
                tmparr[count++] = arr[i++];
        }
        while(i <= (start + end) / 2) {
            tmparr[count++] = arr[i++];
        }

        while(j <= end) {
            tmparr[count++] = arr[j++];
        }

        for(i = start; i <= end; i++) {
            arr[i] = tmparr[i];
        }
    }
}