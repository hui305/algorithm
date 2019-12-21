package algo;

import java.util.Arrays;

/**
 * Created by hui_stone on 2019/12/21 0021.
 */
public class Sort {

    /**
     * 想象一下打扑克牌，发牌的时候，我们一张一张的插入到已经有序的牌队列中。
     * 排序算法：比较，交换位置。具体每种算法的实现不同。
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i <= arr.length - 1; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int[] array = {8, 6, 5, 9, 4, 2, 1};
        insertSort(array);
        Arrays.stream(array).forEach((i)-> System.out.print(" "+i));
    }
}
