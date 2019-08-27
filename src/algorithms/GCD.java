package algorithms;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Euclid's greatest common divisor computation
 * Two ways, first the loop way, then recursively
 *
 */
public class GCD {

    private static int gcd_recursive(int x, int y) {

        if (y == 0) {
            return x;
        }

        return gcd_recursive(y, x % y);
    }

    private static int gcd_simple_loop(int x, int y) {

        int result = 0;

        if(x == y) {
            return x;
        }

        if(x < y) {
            for(int i = x; i > 0; i--) {
                if(x % i == 0 && y % i == 0) {
                    return i;
                }
            }
        }

        for(int i = y; i > 0; i--) {
            if(x % i == 0 && y % i == 0) {
                return i;
            }
        }

        return result;
    }

    public static void main(String args[]) throws InterruptedException {

        long start = 0l;
        long elapsed = 0l;

        System.out.println("Begin simple loop to compute gcd: ");
        start = System.nanoTime();
        System.out.println("gcd = " + gcd_simple_loop(24, 20));
        elapsed = System.nanoTime() - start;
        System.out.println("elapsed time: " + elapsed);

        Thread.sleep(1000l);

        System.out.println("\nBegin recursive computation: ");
        start = System.nanoTime();
        System.out.println("gcd = " + gcd_recursive(24, 20));
        elapsed = System.nanoTime() - start;
        System.out.println("elapsed time: " + elapsed);
    }

}
