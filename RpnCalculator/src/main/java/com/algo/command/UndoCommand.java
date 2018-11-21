package com.algo.command;

import com.algo.store.Record;
import com.algo.store.Store;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class UndoCommand implements Command{

    private Store store;

    public UndoCommand(Store store) {
        this.store = store;
    }

    @Override
    public void execute(Record record) {

        store.popValue();
        record = store.getOptRecord();
        System.out.println(record);
        if(StringUtils.equalsAny(record.getSymbol(),"sqrt","add")){
            Double[] values = record.getParams();
            Arrays.stream(values).forEach((e)->store.putValue(e));
        }
    }

}
