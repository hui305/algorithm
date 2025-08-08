import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2025/8/1 15:35
 */
public class ShellSort  {

    //这个算法实现是元素分组处理的。
    public static void sort(int[] arr) {
// 确定新一轮分组的增量

        //按升序排列
        int N = arr.length;
        int gap = 1;//step 步长，或者叫间隔
        while(gap<N/3) gap = 3*gap+1;//1,4,,13,40,121,364,1093,...

        while(gap>=1){
            // 对数组进行分组
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    // 获取当前元素，然后在本组内部向前比较并排序
                    int current = arr[j];
                    for (int k = j - gap; k >= i; k -= gap) {
                        if (arr[k] > current) {
                            // 插入
                            arr[k + gap] = arr[k];
                            arr[k] = current;
                        }
                    }
                }
            }

            gap = gap/3;
        }
    }

//    int[] array = {1,3,5,7};

//    List<Integer> shellStepSequence() {
//        List<Integer> stepSequence = new ArrayList<>();
//        int step = array.length;
//        while ((step >>= 1) > 0) {
//            stepSequence.add(step);
//        }
//        return stepSequence;
//    }

    public static void main(String[] args) {
// 定义数组
        int[] arr = {99, 55, 2, 3, 9, 10, 22, 34, 67, 89, 69, 92, 101, 102};
// 增量
        int gap = arr.length;
// 排序
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
    }
}
