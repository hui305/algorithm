package org.algo;

import java.util.HashMap;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2021/7/20 16:45
 */
public class LeetCode3 {

    public static void main(String[] args) {
//
        String s = "abcabcbb";
        System.out.println("==========> "+ lengthOfLongestSubstring(s));

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
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);

            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static  int lengthOfLongestSubstringbyHash(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int l = 0, maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            l = Math.max(l, index + 1);
            maxL = Math.max(maxL, i - l + 1);
            map.put(s.charAt(i), i);
        }
        return maxL;
    }
}
