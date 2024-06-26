package algo;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * Created by hui_stone on 2020/10/24 0024.
 * 逐个比较，交换。
 * 优点：算法简单，易于理解。
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

//    public static void main(String[] args) {
//
////        int a[] ={9,5,8,7,4,6};
////        sort(a);
////        Arrays.stream(a).forEach((i)->System.out.print(" "+ i));
//
//    }

    public static void main(String[] args){
        int score[] = {67, 69, 75, 87, 89, 90, 99, 100};
        for (int i = 0; i < score.length -1; i++){    //最多做n-1趟排序
            for(int j = 0 ;j < score.length - i - 1; j++){    //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                if(score[j] < score[j + 1]){    //把小的值交换到后面
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
            System.out.print("第" + (i + 1) + "次排序结果：");
            for(int a = 0; a < score.length; a++){
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }
        System.out.print("最终排序结果：");
        for(int a = 0; a < score.length; a++){
            System.out.print(score[a] + "\t");
        }
    }
}
