package org.algo;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2024/4/15 19:39
 */
public class LeetCode14 {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
//        for (String string : strs) { //遍历字符串数组中的每一个元素
//            while(!string.startsWith(s)){
//                if(s.length()==0)return "";
//                //公共前缀不匹配就让它变短！
//                s=s.substring(0,s.length()-1);
//            }
//        }
        for(int i = 1;i<strs.length;i++){
            while(!strs[i].startsWith(s)){//不断利用String的startsWith做判断
                if(s.length()==0)return "";
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }
//    public static  String longestCommonPrefix(String[] strs) {
//
//        String common = strs[0];
//        for(String string:strs){
//            if(!string.startsWith(common)){
//                common = common.substring(0,common.length()-1);
//            }
//        }
//        return common;
//    }

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);

    }
}
