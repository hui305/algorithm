package com.algo.rpn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hui_stone on 2018/11/15 0015.
 */
public enum Sign {

    ADD("+") {
        public double apply(double num1, double num2) {
            return num2 + num1;
        }
    },
    REMOVE("-") {
        public double apply(double num1, double num2) {
            return num2 - num1;
        }
    },
    MULTIPLY("*") {
        public double apply(double num1, double num2) {
            return num2 * num1;
        }
    },
    DIVIDE("/") {
        public double apply(double num1, double num2) {
            return num2 / num1;
        }
    };
//    SQRT("sqrt") {
//        public double apply(double num1){
//            return Math.sqrt(num1);
//        }
//    };

    private final String operatorText;

    private Sign(String operatorText) {
        this.operatorText = operatorText;
    }

    public abstract double apply(double x1, double x2);

    private static final Map<String, Sign> map;

    static {
        map = new HashMap<>();
        for (Sign sign : Sign.values()) {
            map.put(sign.operatorText, sign);
        }
    }

    public static Sign find(String sign) {
        return map.get(sign);
    }
}
