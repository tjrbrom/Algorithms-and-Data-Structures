package algorithms;

import java.util.Stack;

/**
 * Taking advantage of the Stack LIFO principle, to check if a string of characters is balanced.
 * (ex. If a brace opens, the equivalent needs to close)
 * <p>
 * In this example, we iterate on the characters of a String
 * When we find an opening brace, it is pushed on the Stack
 * When we find a closing brace, the equivalent opening brace needs to be at the top of the stack, otherwise the String is not balanced
 */
public class Parentheses {

    private static final char LEFT_PAREN = '(';
    private static final char LEFT_BRACE = '{';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_PAREN = ')';
    private static final char RIGHT_BRACE = '}';
    private static final char RIGHT_BRACKET = ']';

    public static boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == LEFT_PAREN) stack.push(LEFT_PAREN);
            if (c == LEFT_BRACE) stack.push(LEFT_BRACE);
            if (c == LEFT_BRACKET) stack.push(LEFT_BRACKET);

            if (c == RIGHT_PAREN) {

                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_PAREN)
                    return false;

            } else if (c == RIGHT_BRACE) {

                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_BRACE)
                    return false;

            } else if (c == RIGHT_BRACKET) {

                if (stack.isEmpty())
                    return false;
                if (stack.pop() != LEFT_BRACKET)
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String b = "[()]{}{[()()]()}";
        System.out.println(b + " is balanced: " + isBalanced(b));

        System.out.println("===============");

        String nb = "[)]{]}";
        System.out.println(nb + " is balanced: " + isBalanced(nb));
    }
    
    /**
     * It could also be implemented without a Stack structure
     *
     * // NOTE: not very optimized ^^ lot's of similar ifs, but I'm bored right now...
     *
     * @param input
     * @return if it's balanced
     */
    public static boolean isBalancedWithoutStack(String input) {
        int countParentheses = 0;
        int countBrackets = 0;
        int countSquareBrackets = 0;

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            char ch = chars[i];
            if ( ch == '(' ) {
                ++countParentheses;
            } else if ( ch == ')' ) {
                --countParentheses;
                if (countParentheses < 0) return false;
            }
            if ( ch == '[' ) {
                ++countBrackets;
            } else if ( ch == ']' ) {
                --countBrackets;
                if (countBrackets < 0) return false;
            }
            if ( ch == '{' ) {
                ++countSquareBrackets;
            } else if ( ch == '}' ) {
                --countSquareBrackets;
                if (countSquareBrackets < 0) return false;
            }
        }
        return (countParentheses + countBrackets + countSquareBrackets == 0);
    }

}
