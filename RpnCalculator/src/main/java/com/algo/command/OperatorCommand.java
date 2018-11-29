package com.algo.command;

import com.algo.excepiton.CalculatorException;

/**
 * Created by hui_stone on 2018/11/26 0026.
 */
public abstract class OperatorCommand extends AbstractCommand {

    /**
     * Return the number of required operands
     * @return
     */
    protected abstract Integer requiredOperand();

    protected void validateOperands() throws CalculatorException {
        if (getStore().getNumStack().size() < requiredOperand()) {
            throw new CalculatorException(this.toString());
        }
    }

    /**
     * Do the calculation here
     */
    protected abstract void doCalculation();

}
