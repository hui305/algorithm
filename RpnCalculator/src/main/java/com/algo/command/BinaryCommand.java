package com.algo.command;

import com.algo.excepiton.CalculatorException;
import com.algo.factory.Constant;

import java.math.BigDecimal;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public abstract class BinaryCommand extends OperatorCommand {

    protected BigDecimal first = BigDecimal.ZERO;
    protected BigDecimal second = BigDecimal.ZERO;

    @Override
    protected Integer requiredOperand() {
        return Constant.BINARY_OPT_NUM;
    }

    @Override
    protected void operate() throws CalculatorException {
        validateOperands();
        first = getStore().getValue();
        second = getStore().getValue();
        doCalculation();
    }
}
