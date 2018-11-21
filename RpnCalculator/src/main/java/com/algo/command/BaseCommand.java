package com.algo.command;

import com.algo.store.Record;
import com.algo.store.Store;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class BaseCommand implements Command {

    private Store store;

    public BaseCommand(Store store) {
        this.store = store;
    }

    public void execute(Record record) {

        store.putValue(record.getParams()[0]);
        store.addOptRecord(record);
    }

//    private Record getRecord(String strValue){
//
//        List<Double> params = new ArrayList<Double>();
//        params.add(Double.parseDouble(strValue));
//        return new Record(params,"base");
//    }

}
