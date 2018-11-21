package com.algo.command;

import com.algo.store.Record;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public interface Command {

    void execute(Record record);
}
