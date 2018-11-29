package com.algo;

import com.algo.excepiton.CalculatorException;
import com.algo.store.RpnStore;

import java.util.Scanner;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RpnStore rpnStore = new RpnStore();
        CalCulator calCulator = new CalCulator(rpnStore);
        System.out.println("Enter your expression, or 'exit' to quit");
        while(scanner.hasNextLine()){
            String symbols = scanner.nextLine();
            if("exit".equals(symbols)){
                break;
            } else{
                try {
                    calCulator.eval(symbols);
                    System.out.println(rpnStore);
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
