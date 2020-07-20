package org.com.alg.sort;

import java.util.Arrays;

/**
 * Implementing Insertion Sort using recursion :p
 */
public class InsertionSortRecursive {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        recursiveInsertionSort(array, array.length);

        Arrays.stream(array).forEach(System.out::println);

    }

    // <3
    public static void recursiveInsertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        recursiveInsertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

    }

}
