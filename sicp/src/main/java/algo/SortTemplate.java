package algo;

import java.util.Arrays;

/**
 * Created by hui_stone on 2020/10/24 0024.
 */
public class SortTemplate {

    /*
        1.find the smallest item in the array
        2.exchange it with the first entry

     */
    public static void selectionSort(Comparable[] a){

        int N = a.length;
        for(int i = 0;i < N; i++){//外层循环从左到右  左边序列都是有序的 例如 2 3 | 8 5 6
            int min = i;
            for(int j = i+1;j < N;j++){
                if(less(a[j],a[min]))
                    min = j;
            }
            exch(a,min,i);
        }
    }

    /*
       1.假设左边有序，右边元素插入左边有序队列中
       2.比较大小，右移元素，找到自己位置。
       i，j标记之间的关系，取相对位置
     */
    public static void insertionSort(Comparable[] a){

        int len = a.length;
        for(int i = 1;i<len;i++){
            Comparable p = a[i];
            int j = i-1;
            while(j>=0 && less(p,a[j])){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = p;
        }
    }

    /**
     * 插入排序gap = 1；
     * shell排序gap是有讲究的
     * @param a
     */
    public static void shellSort(Comparable[] a){
        int len = a.length;
        for(int gap = len/2;gap>0;gap /= 2){
            for(int i = gap;i<len;i++){
                int j = i-gap;
                Comparable current = a[i];
                while(j>=0 && less(current,a[j])){
                    a[j+gap] = a[j];
                    j = j-gap;
                }
                a[j+gap] = current;
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]= t;
    }

    private static void show(Comparable[] a){
        Arrays.stream(a).forEach((i)-> System.out.print(" "+i));
        System.out.println();
    }

    public static boolean isSroted(Comparable[] a){
        for(int i = 1;i<a.length;i++){
            if(less(a[i],a[i-1])) return  false;
        }
        return true;
    }

    public static void main(String[] args) {

        String example[] ={"s","o","r","t","e","x","a","m","p","l","e"};
        selectionSort(example);
        show(example);
        String example2[] ={"s","o","r","t","e","x","a","m","p","l","e"};
        insertionSort(example2);
        show(example2);
        String example3[] ={"s","o","r","t","e","x","a","m","p","l","e"};
        shellSort(example3);
        show(example3);
    }
}
