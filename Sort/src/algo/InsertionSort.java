package algo;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2024/9/14 9:40
 * 1) 桥牌
 * 2）左边有序，右边的元素插入到左边
 * 3）比key大，则右移动 a[j+1] = a[j]
 *      j --;
 * 形象思维！逻辑上怎么个流程，想清楚。
 * https://www.bilibili.com/video/BV1TD4y1Q751/?spm_id_from=333.788&vd_source=73f94dcd284349c0c82cd0295166834f
 */
public class InsertionSort {

    public static void sort(int[] a){
        printArray(a);
        int N = a.length;
        for(int i = 1;i<N;i++){
            int key = a[i];
            int j = i - 1;
            while(j>=0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
            printArray(a);
        }
    }

    public static void printArray(int[] a){
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] a = {10,8,11,7,4,12,9,6,5,3};
        sort(a);
    }
}
