package com.algo.command;

import com.algo.excepiton.CalculatorException;
import com.algo.factory.Constant;
import com.algo.store.RpnStore;

import java.math.BigDecimal;

/**
 * Created by hui_stone on 2018/11/29 0029.
 */
public class MultiCommand extends BinaryCommand{

    public MultiCommand(RpnStore store) {
        setStore(store);
    }

    @Override
    protected void doCalculation() {
        getStore().putValue(first.multiply(second, Constant.MC));
    }

    @Override
    public String toString() {
        return "*";
    }

    public static void main(String[] args) {

        RpnStore rpnStore = new RpnStore();
        rpnStore.putValue(new BigDecimal(3));
//        rpnStore.putValue(new BigDecimal(5));
        Command command = new MultiCommand(rpnStore);
        try {
            command.execute();
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }
}
