package com.algo.command;

import com.algo.store.Record;
import com.algo.store.Store;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class SqrtCommand implements Command {

    private Store store;

    public SqrtCommand(Store store) {
        this.store = store;
    }

    @Override
    public void execute(Record record) {

        Double value = store.popValue();
        record.setParams(new Double[]{value});
        Double result = Math.sqrt(value);
        store.putValue(result);
        System.out.println(record);
        store.addOptRecord(record);
    }
}
