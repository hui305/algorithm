package com.algo.command;

import com.algo.excepiton.CalculatorException;
import com.algo.store.RpnStore;

import java.math.BigDecimal;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class BaseCommand extends AbstractCommand {

    private BigDecimal element = BigDecimal.ZERO;

    public BaseCommand(BigDecimal element, RpnStore store) {
        this.element = element;
        setStore(store);
    }

    @Override
    protected void operate() {
        getStore().getNumStack().push(element);
    }
}
