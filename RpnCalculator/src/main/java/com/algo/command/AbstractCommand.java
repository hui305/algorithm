package com.algo.command;


import com.algo.excepiton.CalculatorException;
import com.algo.store.RpnStore;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public abstract  class AbstractCommand implements Command {

    private RpnStore store;
    private Stack<BigDecimal> before = new Stack<BigDecimal>();

    @Override
    public void execute() throws CalculatorException {
        before = (Stack<BigDecimal>)store.getNumStack().clone();
        operate();
        if(store.getLastTwo().size() == 2){
            store.getLastTwo().remove(0);
        }
        store.getLastTwo().push(this);
    }

    protected abstract void operate() throws  CalculatorException;

    @Override
    public void undo() {
        store.setNumStack((Stack<BigDecimal>)before.clone());
    }

    public RpnStore getStore() {
        return store;
    }

    public void setStore(RpnStore store) {
        this.store = store;
    }
}
