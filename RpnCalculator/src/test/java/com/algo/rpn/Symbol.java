package com.algo.rpn;

/**
 * Created by hui_stone on 2018/11/15 0015.
 */
public enum Symbol {

    PLUS("+"),SUBSTRACT("-"),MULTI("*"),DIV("/");

    private String operator;

    private Symbol(String operator){

        this.operator = operator;
    }

    public static void main(String[] args) {

        String[] ss = new String[10];
        int[] nums = new int[10];
        System.out.println(ss[0]);

        Thread t = new Thread();
    }

}
