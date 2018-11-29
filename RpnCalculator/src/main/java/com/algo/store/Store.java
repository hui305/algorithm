package com.algo.store;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public interface Store {
    void putValue(BigDecimal num);
    BigDecimal getValue();
    Stack<BigDecimal> getStack();
    //    void addOptRecord(Record record);
//    Record getOptRecord();
}
