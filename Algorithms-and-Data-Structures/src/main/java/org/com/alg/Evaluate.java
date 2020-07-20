package org.com.alg;

import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Similar to Dijkstra's way of evaluating arithmetic expressions
 *
 * (Notice the benefit of using the Stack data structure)
 */
public class Evaluate {

    private final static Logger LOGGER = LoggerFactory.getLogger(Evaluate.class);

    public static void main(String[] args) {

        evaluateExpression("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )");
    }

    static void evaluateExpression(String expression) {

		// this one holds operators and parentheses
        Stack<String> ops = new Stack<String>();
		
		// and this one holds the numbers
        Stack<Double> numbers = new Stack<Double>();

        // though probably more efficient with a char array
        String[] chars = expression.split(" ");

        for (String s : chars) {

            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = numbers.pop();
                if (op.equals("+")) v = numbers.pop() + v;
                else if (op.equals("-")) v = numbers.pop() - v;
                else if (op.equals("*")) v = numbers.pop() * v;
                else if (op.equals("/")) v = numbers.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                numbers.push(v);
            }
            else numbers.push(Double.parseDouble(s));
        }

        LOGGER.info("expression evaluation result: " + numbers.pop());
    }

}
