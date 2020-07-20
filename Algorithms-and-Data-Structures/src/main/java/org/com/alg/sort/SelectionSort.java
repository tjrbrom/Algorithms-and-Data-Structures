package org.com.alg.sort;

import java.util.Arrays;

/**
 * O(n squared) time complexity, because for each element we traverse n elements.
 * <p>
 * Unstable, because original order of duplicates is not guaranteed to be preserved.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }

            swap(array, largest, lastUnsortedIndex);

        }

        Arrays.stream(array).forEach(System.out::println);

    }

    static void swap(int[] array, int i, int j) {

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}
