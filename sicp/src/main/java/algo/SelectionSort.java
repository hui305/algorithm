package algo;

import java.util.Arrays;

/**
 * Created by hui_stone on 2020/10/24 0024.
 * 1.find the smallest item in the array
 * 2.then exchange it with the first entry
 * 选择排序，数据移动是最少的，交换次数和数组长度是线性关系，
 * 其他算法，一般是对数，平方
 */
public class SelectionSort {

    public static void sort(int[] a){

        for(int j = 0;j<a.length;j++){
            int min = j;
            for(int i = j+1;i<a.length;i++){//内层循环从j+1开始
                if(a[i] < a[min])
                    min = i;
            }
            exch(a,min,j);
        }
    }

    private static void exch(int[] a,int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int a[] ={9,5,8,7,4};
        SelectionSort.sort(a);
        Arrays.stream(a).forEach((i)-> System.out.print(" "+i));
    }
}
