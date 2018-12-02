package com.algo.command;

import com.algo.factory.Constant;
import com.algo.store.RpnStore;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class AdditionCommand extends BinaryCommand {

    public AdditionCommand(RpnStore store) {
        setStore(store);
    }

    @Override
    protected void doCalculation() {
        getStore().putValue(first.add(second, Constant.MC));
    }

    @Override
    public String toString() {
        return "+";
    }


}
