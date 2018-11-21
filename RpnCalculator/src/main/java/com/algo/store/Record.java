package com.algo.store;

import java.util.Arrays;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class Record {

    private Double[] params;
    private String symbol;

    public Record(Double[] params, String symbol) {
        this.params = params;
        this.symbol = symbol;
    }

    public Record(String symbol) {
        this.symbol = symbol;
    }

    public Double[] getParams() {
        return params;
    }

    public void setParams(Double[] params) {
        this.params = params;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Record{" +
                "params=" + Arrays.toString(params) +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
