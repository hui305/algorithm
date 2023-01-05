package org.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2021/7/20 16:45
 */
public class LeetCode3 {

    public static int lenSubString(String s){

        int len = 0;//字串长度
        int start = 0;
        Map<Character,Integer> subMap = new HashMap<>(s.length());
        for(int i = 0;i<s.length();i++){
            //重置开始位置
            start = Math.max(start,subMap.getOrDefault(s.charAt(i),-1)+1);
            //计算和比较字串长度
            len = Math.max(len,i-start+1);
            //放入 字符：位置 映射 关系
            subMap.put(s.charAt(i),i);
        }
        return len;
    }

    public static void main(String[] args) {

        String s = "";
        System.out.println("substring len is:"+ lenSubString(s));
//        String s ="abcdef";
//        // 遍历字符串
//        for (int i = 0; i < s.length(); i++)
//        {
//            System.out.println(s.charAt(i)-0);
//        }
//
//        String s1 = "hello";
//        String s2 = "world";
//        String s3 = "hello" + "world";
//        String s4 = s1 + "world";
//        String s5 = s1 + s2;
//        String s6 = (s1 + s2).intern();
//        String s7 = "helloworld";
//
//        System.out.println(s3 == s4);//false
//        System.out.println(s3 == s5);//false
//        System.out.println(s4 == s5);//false
//        System.out.println(s3 == s6);//true
//        System.out.println(s3 == s7);//true

        //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
//        String s = "www.runoob.com";
//        System.out.println(s.charAt(6));
//        int i = s.charAt(6);
//        System.out.println(i);

//        String s = "abcabcbb";
//        int len  = lengthOfLongestSubstringbyHash(s);
//        System.out.println("the max substring length is :"+ len);
//
//        String s = "abcabcbb";
//        System.out.println("==========> "+ lengthOfLongestSubstring(s));
//        char c = 98;
//        System.out.println(c);
//        for(int i = 0;i<s.length();i++){
//            System.out.println(s.charAt(i));
//        }
//        String e = "JDK";
//        String f = new String("JDK");
//        System.out.println(e==f);
////        String s = "www.runoob.com";
////        char result = s.charAt(6);
////        System.out.println(result);
//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);//false
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);
    }
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符位置
        int[] last = new int[128];
        //初始化每个字符的位置
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            System.out.println("index==="+ index);

            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static  int lengthOfLongestSubstringbyHash(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int start = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            start = Math.max(start, index + 1);
            len = Math.max(len, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return len;
    }
}
