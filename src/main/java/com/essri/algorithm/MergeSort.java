package com.essri.algorithm;

public class MergeSort {
    public static int[] sort;

    public static int[] sort(int[] arr) {
        sort = new int[arr.length];
        mergeSort(0, arr.length-1,arr);
        return sort;
    }

    public static void mergeSort(int left, int right,int[] arr){
        int mid;
        if(left<right){
            mid = (left+right)/2;
            mergeSort(left, mid, arr);
            mergeSort(mid+1, right, arr);
            merge(left, mid, right, arr);
        }
    }

    public static void merge(int left, int mid, int right, int[] arr){
        int l = left;
        int m = mid+1;
        int k = left;

        while(l<=mid || m<=right){
            if(l<=mid && m<=right){
                if(arr[l]<=arr[m]){
                    sort[k] = arr[l++];
                }else{
                    sort[k] = arr[m++];
                }
            }else if(l<=mid && m>right){
                sort[k] = arr[l++];
            }else{
                sort[k] = arr[m++];
            }

            k++;
        }
        while(l<=mid || m<=right) {
            if(l<=mid && m<=right) {
                if(arr[l] <= arr[m]) {
                    sort[k] = arr[l++];
                } else {

                }
            }
        }

        for(int i=left; i<right+1; i++){
            arr[i] = sort[i];
        }
    }
}