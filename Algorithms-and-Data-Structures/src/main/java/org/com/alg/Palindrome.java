package org.com.alg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *	Check if a String is palindrome, with and without recursion.
 */
public class Palindrome {

    private final static Logger LOGGER = LoggerFactory.getLogger(Palindrome.class);

    static boolean isPalindrome(String str) {

        if(str.isEmpty() || str.length() == 1) {
            return true;
        }

        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    static boolean recursiveIsPalindrome(String str) {

        if(str.isEmpty() || str.length() == 1) {
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1)) {

            return recursiveIsPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }
	
	public static void main(String[] args) {

        LOGGER.info(String.valueOf(isPalindrome("asaadaasa")));
        LOGGER.info(String.valueOf(recursiveIsPalindrome("12321")));
    }
	
}