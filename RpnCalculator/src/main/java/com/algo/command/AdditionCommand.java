package com.algo.command;

import com.algo.store.Record;
import com.algo.store.Store;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class AdditionCommand extends BinaryCommand {

    private final Store store;

    public AdditionCommand(Store store) {
        this.store = store;
    }

    @Override
    public void execute(Record record) {

       Double second = store.popValue();
       Double first = store.popValue();
       Double result = Double.sum(first,second);
       record.setParams(new Double[]{first,second});
       System.out.println(record);
       store.putValue(result);
       store.addOptRecord(record);
    }
}
