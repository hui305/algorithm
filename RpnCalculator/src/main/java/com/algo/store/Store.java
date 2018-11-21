package com.algo.store;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public interface Store {
    void putValue(Double num);
    Double popValue();
    void addOptRecord(Record record);
    Record getOptRecord();
}
