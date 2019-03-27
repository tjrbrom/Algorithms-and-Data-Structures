package algorithms.sort;

import java.util.Arrays;

/**
 * Counting Sort is often used as a sort algorithm for Radix Sort - must be stable counting sort
 * <p>
 * O(n) - can achieve linear time because we assume the data
 * Even so, it often runs slower that O(nlogn) algorithms, because of the overhead involved
 * <p>
 * Can be in-place.
 * <p>
 * Must be stable!
 */
public class RadixSort {

    public static void main(String args[]) {

        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(radixArray, 10, 4);

        Arrays.stream(radixArray).forEach(System.out::println);
    }

    public static void radixSort(int[] input, int radix, int width) {

        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }

    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;

        int[] countArray = new int[radix];

        for (int value : input) {
            countArray[getDigit(position, value, radix)]++;
        }

        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    // <3
    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }

}
