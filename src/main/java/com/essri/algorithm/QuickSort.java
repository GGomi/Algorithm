package com.essri.algorithm;

public class QuickSort {
    public static int[] sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        while(left <= right){
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }

        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);

        return data;
    }

}
