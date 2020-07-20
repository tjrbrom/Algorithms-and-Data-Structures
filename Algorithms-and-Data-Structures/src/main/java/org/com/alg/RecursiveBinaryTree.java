package org.com.alg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Recursive binary tree search
 * Array needs to be sorted before searching
 */
public class RecursiveBinaryTree {

    public static int find(int key, int[] a) {
        return find(key, a, 0, a.length - 1);
    }

    public static int find(int key, int[] a, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
		// if key is smaller than value in the middle, continue searching in the first half of the requested array
        if (key < a[mid]) return find(key, a, low, mid - 1);
		// if key is larger, continue searching in the second half
        else if (key > a[mid]) return find(key, a, mid + 1, high);
        else return mid;
    }

    public static void main(String args[]) {

        int[] arr = new int[]{2, 3, 6, 7, 9, 11, 14, 18, 20};

        System.out.printf("key found in position: %d", find(9, arr));
    }

}
