package algo;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * Created by hui_stone on 2020/10/24 0024.
 */
public class BubbleSort {

    public static void sort(int[] a){
        int temp;
        for(int j = a.length-1;j>0;j--){//外层循环逐步递减
            for(int i = 0;i<j;i++){//内层循环，从0到J，比较，换位
                if(a[i]>a[i+1]){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int a[] ={9,5,8,7,4,6};
        sort(a);
        Arrays.stream(a).forEach((i)->System.out.print(" "+ i));
    }
}
