package org.algo;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1 {

    public static int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
//                    result[0] = i;
//                    result[1] = j;
//                    break;
                    return new int[]{i,j};
                }
            }
        }
        return  null;
    }

    public static int[] sum(int[] nums, int target){

        HashMap<Integer,Integer> map = new HashMap<>(nums.length-1);
        map.put(nums[0],0);
        for(int i = 1;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
     }
    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target = 6;
        int[] result  = sum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}