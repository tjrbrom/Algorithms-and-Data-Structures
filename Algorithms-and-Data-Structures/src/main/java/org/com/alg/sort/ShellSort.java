package org.com.alg.sort;

import java.util.Arrays;

/**
 * Worst case: O(n squared)
 * <p>
 * Unstable, but doesn't require as much shifting as insertion sort
 *
 * Shellsort is much faster than insertion or selection sort, and its speed advantage increases with the input size
 */
public class ShellSort {

    public static void main(String args[]) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        for(int gap = array.length / 2; gap > 0; gap /= 2) {

            for(int i = gap; i < array.length; i++) {

                int newElement = array[i];

                int j = i;

                while(j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = newElement;

            }

        }

        Arrays.stream(array).forEach(System.out::println);

    }

}
