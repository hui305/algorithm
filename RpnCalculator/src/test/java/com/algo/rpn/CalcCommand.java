package com.algo.rpn;

import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/16 0016.
 */
public class CalcCommand {

    private final Stack<Double> stack = new Stack();

    private void add(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(a+b);
    }

    private void substract(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(a-b);
    }

    private void multi(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(a*b);
    }

    private void divid(){
        double a = stack.pop();
        double b = stack.pop();
        stack.push(a/b);
    }

    private void sqrt(){
        double a = stack.pop();
        stack.push(Math.sqrt(a));
    }

    private void undo(){
//        stack.pop();
    }

    private void clear(){
        if(!stack.isEmpty())
        stack.clear();
    }
}
