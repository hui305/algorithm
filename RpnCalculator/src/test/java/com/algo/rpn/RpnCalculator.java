package com.algo.rpn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hui_stone on 2018/11/15 0015.
 */
public class RpnCalculator {

    private static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.add("hello");
        stack.add("world");
        stack.stream().forEach(number-> System.out.println(number));
        stack.clear();
        System.out.println(stack.size());

//        String[] tokens = new String[] { "2", "1", "+", "3", "*" };

//        double x = 4.0;
//
//        System.out.println(Math.sqrt(x));

        // 在默认情况下，Scanner使用空白（包括空格、Tab空白、回车）作为多个输入项之间的分隔符。
        // 看下面的程序使用Scanner来获得用户的键盘输入。
//        System.out.println("Welcome to the RPN Calculator program!");
//
//        Stack<String> numbers  = new Stack();
//        Scanner scan = new Scanner(System.in) ; // 从键盘接收数据
//        System.out.print("输入数据：") ;
//        String str =  scan.next();  // 接收数据
//        System.out.println(str);
//        while(true){
//            str = scan.next();
//
//        }
    }
}
