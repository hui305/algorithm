package com.algo;

import com.algo.command.BaseCommand;
import com.algo.command.Command;
import com.algo.excepiton.CalculatorException;
import com.algo.factory.CommandFactory;
import com.algo.factory.Constant;
import com.algo.store.RpnStore;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;


/**
 * Created by hui_stone on 2018/11/24 0024.
 */
public class CalCulator {

    private final RpnStore store;
    private int currentTokenIndex = 0;
    private static final String REG_NUM = "^[1-9]\\d*|0$";

    public CalCulator(RpnStore store) {
        this.store = store;
    }

    private void processToken(String token) throws CalculatorException {

        Command command;
        if(token.matches(REG_NUM)){
            command = new BaseCommand(new BigDecimal(token, Constant.MC),store);
            command.execute();
        } else if (StringUtils.equalsAnyIgnoreCase(token,"undo")){
            if (store.getLastTwo().size() > 0) {
                store.getLastTwo().pop().undo();
            } else {
               throw new CalculatorException("Only two undo are supported");
            }
        } else if(StringUtils.equalsAnyIgnoreCase(token,"clear")){
            store.getNumStack().clear();
        } else {
            try{
                command = CommandFactory.getCommandInstance(token,store);
                command.execute();
            } catch(CalculatorException e){
                throwInvalidOperand(e.getMessage());
            }

        }
    }
    public void eval(String input) throws CalculatorException {

        if (input == null) {
            throw new CalculatorException("Input cannot be null.");
        }
        currentTokenIndex = 0;
        String[] result = input.split("\\s");
        for (String aResult : result) {
            currentTokenIndex++;
            processToken(aResult);
        }
    }

    private void throwInvalidOperand(String operator) throws CalculatorException {
        throw new CalculatorException(
                String.format("operator %s (position: %d): insufficient parameters", operator, currentTokenIndex*2-1));
    }
}
