package org.com.alg.sort;

import java.util.Arrays;

/**
 * In-place
 * <p>
 * O(nlogn) - base 2. We're repeatedly partitioning the array into two halves.
 * <p>
 * Unstable
 */
public class QuickSort {

    public static void main(String args[]) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        quicksort(array, 0, array.length);

        Arrays.stream(array).forEach(System.out::println);

    }

    public static void quicksort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quicksort(input, start, pivotIndex);
        quicksort(input, pivotIndex + 1, end);

    }

    public static int partition(int[] array, int start, int end) {

        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop
            while (i < j && array[--j] >= pivot) ;
            if (i < j) {
                array[i] = array[j];
            }

            // NOTE: empty loop
            while (i < j && array[++i] <= pivot) ;
            if (i < j) {
                array[j] = array[i];
            }

        }

        array[j] = pivot;
        return j;

    }

}
