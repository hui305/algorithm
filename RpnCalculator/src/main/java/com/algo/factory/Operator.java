package com.algo.factory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hui_stone on 2018/11/29 0029.
 */
public enum Operator {

    ADD("+"),
    SUBTRACT("-"),
    MULTI("*"),
    DIV("/"),
    SQRT("sqrt");

    private String token;
    private Operator(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }
    public static Map<String,Operator> operatorMap = new HashMap<>();
    static{
        Arrays.stream(Operator.values()).forEach(o -> operatorMap.put(o.getToken(),o));
    }

    @Override
    public String toString() {
        return "Operator{" +
                "token='" + token + '\'' +
                '}';
    }

}
