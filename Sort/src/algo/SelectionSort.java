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

        int len = a.length;
        for(int i = 0;i<len-1;i++){//外层只负责交换，交换一次，排好序一次，靠左都是排好序的。
            int min = i;//首先，假设最小的值在首位
            for(int j = i+1;j<=len-1;j++){//内层循环从i+1开始
                if(a[j] < a[min])
                    min = j;
            }
            if(min != i){ //如果使用异或，不能地址相同
                exch(a,min,i);
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            for(int y = 0; y < a.length; y++){
                System.out.print(a[y] + "\t");
            }
            System.out.println("");
        }

        System.out.print("最终排序结果：");
        for(int i = 0; i< a.length; i++){
            System.out.print(a[i] + "\t");
        }
    }

    private static void exch(int[] a,int i,int j){
//        int temp;
//        temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//        if(a[i] == a[j])
//            return;
        a[i] = a[i]^a[j];
        a[j] = a[i]^a[j];
        a[i] = a[i]^a[j];
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,4,1,8,2,7};
        SelectionSort.sort(array);
//        Arrays.stream(a).forEach((i)-> System.out.print(" "+i));
    }
}
