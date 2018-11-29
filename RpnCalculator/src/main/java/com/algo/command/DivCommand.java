package com.algo.command;

import com.algo.factory.Constant;
import com.algo.store.RpnStore;

/**
 * Created by hui_stone on 2018/11/29 0029.
 */
public class DivCommand extends BinaryCommand {

    public DivCommand(RpnStore store) {
        setStore(store);
    }

    @Override
    protected void doCalculation() {
        getStore().putValue(second.divide(first, Constant.MC));
    }

    @Override
    public String toString() {
        return "/";
    }
}
