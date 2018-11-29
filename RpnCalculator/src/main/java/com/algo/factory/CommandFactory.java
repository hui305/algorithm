package com.algo.factory;

import com.algo.command.*;
import com.algo.excepiton.CalculatorException;
import com.algo.store.RpnStore;

/**
 * Created by hui_stone on 2018/11/29 0029.
 */
public class CommandFactory {

    public static Command getCommandInstance(String token, RpnStore store) throws CalculatorException {

        Operator operator = Operator.operatorMap.get(token);
        if(operator == null)
            throw new CalculatorException("input invalid");
        switch (operator){
            case ADD:
                return new AdditionCommand(store);
            case SUBTRACT:
                return new SubtractCommand(store);
            case MULTI:
                return new MultiCommand(store);
            case DIV:
                return new DivCommand(store);
            case SQRT:
                return new SqrtCommand(store);
            default:
                throw new CalculatorException("input invalid");
        }
    }

}

