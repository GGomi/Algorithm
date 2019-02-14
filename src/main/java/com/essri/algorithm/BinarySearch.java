package com.essri.algorithm;

public class BinarySearch {
    private static int[] arr = {1,2,3,4,5,6,7};

    public static void main(String[] args) {
        System.out.println("index is : "+binarySearch(3,arr));
    }

    public static int binarySearch(int key, int[] arr) {
        int left = 0;
        int mid;
        int right = arr.length-1;
        int answer = -1;

        while(left <= right) {
            mid = (left+right) / 2;

            if(key == arr[mid]) {
                answer = mid;
                break;
            }

            if(arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
