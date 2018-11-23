package com.algo.rpn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/15 0015.
 */
public class ReversePolishNotationSeven {

    public static Double calc(String input) {
        Stack<Double> numbers = new Stack<>();
        for (String number : input.split(" ")) {
            Sign sign = Sign.find(number);
            if (sign != null) {
                calcSign(numbers, sign);
            } else {
                numbers.push(Double.parseDouble(number));
            }
        }
        return numbers.pop();
    }

    protected static Stack<Double> calcSign(Stack<Double> numbers, Sign sign) {
        numbers.push(sign.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }

    public static void main(String[] args) {

        String tokens = "2 1 3 + *";
        Double dd = ReversePolishNotationSeven.calc(tokens);
        System.out.println(dd);

    }
}
