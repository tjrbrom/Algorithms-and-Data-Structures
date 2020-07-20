package org.com.alg.sort;

import java.util.Arrays;

/**
 * Not an in-place algorithm
 * <p>
 * O(n) - can achieve linear time because we are making assumptions about the data we're sorting
 * <p>
 * Unstable
 */
public class CountingSort {


    public static void main(String args[]) {

        int[] intArray = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(intArray, Arrays.stream(intArray).min().getAsInt(), Arrays.stream(intArray).max().getAsInt());

        Arrays.stream(intArray).forEach(System.out::println);
    }


    public static void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {

            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }

        }

    }

}
