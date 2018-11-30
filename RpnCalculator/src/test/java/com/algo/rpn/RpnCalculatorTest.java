package com.algo.rpn;

import com.algo.CalCulator;
import com.algo.excepiton.CalculatorException;
import com.algo.store.RpnStore;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hui_stone on 2018/11/30 0030.
 */
public class RpnCalculatorTest {

    CalCulator calCulator;
    RpnStore rpnStore;

    @Before
    public void setUp() throws Exception {
         rpnStore = new RpnStore();
         calCulator = new CalCulator(rpnStore);
    }

    @Test
    public void atomicOperatorTest() throws CalculatorException {

        calCulator.eval("5 2");
        System.out.println(rpnStore);
    }

    @Test
    public void sqrtTest() throws CalculatorException {
        calCulator.eval("2 sqrt");
        System.out.println(rpnStore);
        calCulator.eval("clear 9 sqrt");
        System.out.println(rpnStore);
    }

    @Test
    public void undoTest() throws CalculatorException{
        calCulator.eval("5 4 3 2");
        System.out.println(rpnStore);
        calCulator.eval("undo undo *");
        System.out.println(rpnStore);
        calCulator.eval("5 *");
        System.out.println(rpnStore);
        calCulator.eval("undo");
        System.out.println(rpnStore);
    }

    @Test
    public void divisionTest() throws CalculatorException{
        calCulator.eval("7 12 2 /");
        System.out.println(rpnStore);
        calCulator.eval("*");
        System.out.println(rpnStore);
        calCulator.eval("4 /");
        System.out.println(rpnStore);
    }

    @Test
    public void insufficientTest() throws CalculatorException{
        calCulator.eval("1 2 3 * 5 + * * 6 5");
        System.out.println(rpnStore);
    }
}
