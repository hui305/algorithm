package org.algo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 *
 * 注意：
 *
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
 * 示例1
 *
 * 输入
 * [-2,0,1,1,2]
 * 返回值
 * [[-2,0,2],[-2,1,1]]
 *
 * @author bobstone
 * @version 1.0
 * @date 2021/10/25 10:46
 */
public class Sumabc {

    public static void main(String[] args) {

        int[] nums ={-10,0,10,20,-10,-40};
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        res = threeSum(nums);
        System.out.println(res);

    }
    /**
     * 思路：
     * （1）首先对数组进行排序（从小到大）
     * （2）依次取出第 i 个数（i从0开始），并且不重复的选取（跳过重复的数）
     * （3）这样问题就转换为 2 个数求和的问题（可以用双指针解决方法）
     * ==》数求和问题
     * （4）定义两个指针：左指针（left） 和 右指针（right）
     * （5）找出固定 left， 此时left所指的位置为数组中最小数，再找到两个数和 不大于 target 的最大 right 的位置
     * （6）调整 left 的位置（后移），求解和是否为 target O(n)
     * ==》时间复杂度：O(nlogn) + O(n)
     * @param args
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        if(num==null || num.length<3){
            return res;
        }
        Arrays.sort(num);// 排序
        for(int i=0;i<num.length-2;i++){
            if(num[i]>0){
                break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if(i>0 && num[i]==num[i-1]){
                continue;// 去重
            }
            int L=i+1;
            int R=num.length-1;

            while(L<R){
                int sum=num[i]+num[L]+num[R];
                if(sum==0){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[L]);
                    list.add(num[R]);
                    res.add(list);

                    while(L<R && num[L]==num[L+1]){
                        L++;
                    }
                    while(L<R && num[R]==num[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }
                else if(sum>0){
                    R--;
                }
                else if(sum<0){
                    L++;
                }
            }
        }
        return res;
    }

    /**
     * 基本思想：我们需要在数组中选取三个相加等于0的数，有很多中解法。
     * 解法一：暴力破解，将该数组中三个元素的组合全部找出来（使用一个递归选取一个元素删除该元素再选）
     * 然后从从中筛选出满足我们条件的三元组。
     * 解法二：
     * 步骤如下：
     * ①对数组排序，这样方便我们利用数组中数的顺序来解决该问题
     * ②从数组的左边找到一个不大于0的数key，由于数组顺序排列，如果第一个数大于0后面两个数也大于0加起来不可能为0
     * ③定义两个变量left，right分别指向key的下一个元素和数组的最后一个变量
     * ④如果left、right和key的和大于0那么我们将right向左移动（变小），如果小于0我们就将left右移，直到找到符合我们条件的元素
     * 或者left和right指向同一个元素（不能找到满足条件的元素）
     * ⑤循环执行2,3,4步直到下一个元素大于0或者遍历到数组的最后两个元素
     * 注意：
     * ①我们找key时需要注意数组中元素可能重复每个数我们只取一遍所以我们只遍历一遍，我们只对第一个key做如上操作
     * 原因是（-2，-2,4）（0,0,0）这样的三元组可能由两个相同的元素组成key
     * ②一样的如果right有多个相同的元素我们也只处理第一个，为了避免漏算类似于（-10,5,5）这样的元素
     * */
//    public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
//        //排序，不喜欢用Arrays的可以自己写，可以顺带练习一下排序
//        Arrays.sort(num);
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        for(int i = 0;i < num.length - 2 && num[i] <= 0;i++) {
//            int point1 = num.length - 1;
//            //只遍历第一个key
//            while(0 < i && i < num.length && num[i] == num[i-1]) {
//                i++;
//            }
//            int point2 = i + 1;
//            while(point1 > point2) {
//                if(num[point1] + num[point2] > -num[i]) {
//                    point1--;
//                }else if(num[point1] + num[point2] < -num[i]) {
//                    point2++;
//                }else {
//                    ArrayList<Integer> item = new ArrayList<Integer>();
//                    item.add(num[i]);
//                    item.add(num[point2]);
//                    item.add(num[point1]);
//                    result.add(item);
//                    //只遍历第一个right
//                    while(num[point1] == num[point1 - 1] && point1 > point2){
//                        point1--;
//                    }
//                    point1--;
//                }
//            }
//        }
//        return result;
//    }
}
