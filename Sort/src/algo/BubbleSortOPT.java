package algo;

import java.util.Arrays;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2025/7/25 16:06
 */
public class BubbleSortOPT {
    public static void sort(int[] a){
        int temp;
        boolean noswap;//是否比较flag
        for(int j = a.length-1;j>0;j--){
            noswap = true;
            for(int i = 0;i<j;i++){
                if(a[i]>a[i+1]){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    noswap = false;
                }
            }
            if(noswap){
                System.out.println("============>no swap");
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,8,6,7};
        BubbleSort.sort(array);
        Arrays.stream(array).forEach((i)-> System.out.print(i+" "));
    }
}
