package com.algo.store;

import com.algo.command.Command;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class RpnStore {

    private Stack<BigDecimal> numStack = new Stack<BigDecimal>();
    private Stack<Command> lastTwo = new Stack<>();
    //    private final Stack<Record> recordStack = new Stack<Record>();

    public void putValue(BigDecimal num) {
        numStack.push(num);
    }

    public BigDecimal getValue() {
        return numStack.pop();
    }

    public Stack<BigDecimal> getNumStack() {
        return numStack;
    }

    public void setNumStack(Stack<BigDecimal> numStack) {
        this.numStack = numStack;
    }

    public Stack<Command> getLastTwo() {
        return lastTwo;
    }

    public void setLastTwo(Stack<Command> lastTwo) {
        this.lastTwo = lastTwo;
    }
//    public void addOptRecord(Record record) {
//        recordStack.push(record);
//    }
//
//    public Record getOptRecord() {
//        return recordStack.pop();
//    }

    @Override
    public String toString(){

        DecimalFormat fmt = new DecimalFormat("0.##########");
        StringBuilder stringBuilder = new StringBuilder("Stack: ");
        numStack.stream().forEach((e)-> stringBuilder.append(fmt.format(e)+" "));
        return stringBuilder.toString();
    }

}
