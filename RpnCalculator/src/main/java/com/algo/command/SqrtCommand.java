package com.algo.command;

import com.algo.factory.Constant;
import com.algo.store.RpnStore;

import java.math.BigDecimal;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class SqrtCommand extends UnitaryCommand {

    public SqrtCommand(RpnStore store) {
        setStore(store);
    }

    @Override
    protected void doCalculation() {
        if (operand.compareTo(BigDecimal.ZERO) < 0) {
//            getCalculator().getStack().push(operand);
        }
        Double sqrt = Math.sqrt(operand.doubleValue());
        getStore().putValue(new BigDecimal(sqrt, Constant.MC));
    }
}
