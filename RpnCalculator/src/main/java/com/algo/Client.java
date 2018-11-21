package com.algo;

import com.algo.command.AdditionCommand;
import com.algo.command.BaseCommand;
import com.algo.command.SqrtCommand;
import com.algo.command.UndoCommand;
import com.algo.store.DefaultStore;
import com.algo.store.Record;
import com.algo.store.Store;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Created by hui_stone on 2018/11/21 0021.
 */
public class Client {

    public static void main(String[] args) {

        Store store = new DefaultStore();
        Scanner scanner = new Scanner(System.in);/// 从键盘接收数据
        BaseCommand baseCommand = new BaseCommand(store);

//        boolean keepalive = true;
        while(scanner.hasNextLine()){
            String symbols = scanner.nextLine();
            String[] strValues =symbols.split("\\s");
            for(String str:strValues){
                if(str.matches("\\d+")){
                    Record record = new Record("base");
                    record.setParams(new Double[]{Double.parseDouble(str)});
                    baseCommand.execute(record);
                }
                if(StringUtils.equalsAnyIgnoreCase(str,"undo")){
                    Record record = new Record("undo");
                    new UndoCommand(store).execute(record);
                }
                if(StringUtils.equalsAnyIgnoreCase(str,"sqrt")){
                    Record record = new Record("sqrt");
                    new SqrtCommand(store).execute(record);
                }
                if(StringUtils.equalsAnyIgnoreCase(str,"+")){
                    Record record = new Record("add");
                    new AdditionCommand(store).execute(record);
                }
            }
            System.out.println(store);
        }
    }
}
