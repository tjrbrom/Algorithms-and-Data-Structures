package org.com.alg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Euclid's greatest common divisor computation
 * Two ways, first the loop way, then recursively
 *
 */
public class GCD {

    private final static Logger LOGGER = LoggerFactory.getLogger(GCD.class);

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

        LOGGER.info("Begin simple loop to compute gcd: ");
        start = System.nanoTime();
        LOGGER.info("gcd = " + gcd_simple_loop(24, 20));
        elapsed = System.nanoTime() - start;
        LOGGER.info("elapsed time: " + elapsed);

        Thread.sleep(1000l);

        LOGGER.info("\nBegin recursive computation: ");
        start = System.nanoTime();
        LOGGER.info("gcd = " + gcd_recursive(24, 20));
        elapsed = System.nanoTime() - start;
        LOGGER.info("elapsed time: " + elapsed);
    }

}
