package com.algo.store;

import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class DefaultStore implements Store {

    private final Stack<Double> numStack = new Stack<Double>();
//    private final Stack<List<Double>> undoStack = new Stack<List<Double>>();
    private final Stack<Record> recordStack = new Stack<Record>();

    public void putValue(Double num) {
        numStack.push(num);
    }

    public Double popValue() {
        return numStack.pop();
    }

    public void addOptRecord(Record record) {
        recordStack.push(record);
    }

    public Record getOptRecord() {
        return recordStack.pop();
    }

    @Override
    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();
        numStack.stream().forEach((e)-> stringBuilder.append(" "+e));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Store store = new DefaultStore();
        store.putValue(1.0);
        store.putValue(2.0);
        store.putValue(3.0);
        store.putValue(4.0);
        System.out.println(store);

        Double[] a ={1.0,2.0};
    }
}
