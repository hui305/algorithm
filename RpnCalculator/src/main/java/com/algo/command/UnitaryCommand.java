package com.algo.command;

import com.algo.excepiton.CalculatorException;
import com.algo.factory.Constant;

import java.math.BigDecimal;

/**
 * Created by hui_stone on 2018/11/29 0029.
 */
public abstract class UnitaryCommand extends OperatorCommand {

    protected BigDecimal operand = BigDecimal.ZERO;
    @Override
    protected Integer requiredOperand() {
        return Constant.UNI_OPT_NUM;
    }

    @Override
    protected void operate() throws CalculatorException {
        operand = getStore().getValue();
        doCalculation();
    }
}
