package com.essri.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortTest {
    int[] arr = {3,4,3,2,1,6,7,8,9};

    private SelectionSort selectionSort;
    private BubbleSort bubbleSort;
    private QuickSort quickSort;
    private MergeSort mergeSort;

    @Test
    public void quicksortTest() {
        assertEquals("[1, 2, 3, 3, 4, 6, 7, 8, 9]",Arrays.toString(quickSort.sort(arr,0,arr.length-1)));
    }
    @Test
    public void bubbleTest() {
        assertEquals("[1, 2, 3, 3, 4, 6, 7, 8, 9]",Arrays.toString(bubbleSort.sort(arr)));
    }

    @Test
    public void selectionTest() {
        assertEquals("[1, 2, 3, 3, 4, 6, 7, 8, 9]",Arrays.toString(selectionSort.sort(arr)));
    }

    @Test
    public void mergeTest() {
        assertEquals("[1, 2, 3, 3, 4, 6, 7, 8, 9]",Arrays.toString(mergeSort.sort(arr)));
    }
}
