package com.algo.rpn;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.*;

/**
 * Created by hui_stone on 2018/11/15 0015.
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
//        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
//        System.out.println(evalRPN(tokens));
        System.out.println(calc("2 1 3 + *"));
    }
    public static Double calc(String input) {
        Stack<Double> numbers = new Stack<>();
        Arrays.asList(input.split(" ")).stream().forEach(number -> {
            switch(number) {
                case "+":
                    calcSign(numbers, (n1, n2) -> n2 + n1);
                    break;
                case "-":
                    calcSign(numbers, (n1, n2) -> n2 - n1);
                    break;
                case "*":
                    calcSign(numbers, (n1, n2) -> n2 * n1);
                    break;
                case "/":
                    calcSign(numbers, (n1, n2) -> n2 / n1);
                    break;
                default:
                    numbers.push(Double.parseDouble(number));
            }
        });
        return numbers.pop();
    }

    protected static Stack<Double> calcSign(Stack<Double> numbers, BiFunction<Double, Double, Double> operation) {
        numbers.push(operation.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }
}
