package algo;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2025/8/6 15:47
 */
public class ShellSort {

    /*
    根据 h 分不同的组，逻辑上的组
    实际上还是一维数组，数据是逐个处理的，但属于不同的组。
     */
    public static void sort(int[] arr){

        //按升序排列
        int N = arr.length;
        int h = 1;//step 步长，或者叫间隔
        while(h<N/3) h = 3*h+1;//1,4,,13,40,121,364,1093,...
        while(h>=1){

            for(int i = h;i<N;i++){
                for(int j =i;j>=h;j-=h){
                    if(arr[j-h]>arr[j]){
                        int temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    }
                }
            }

            h = h/3;
        }
    }

    public static void main(String[] args) {
        int[] arr = {99, 55, 2, 3, 9, 10, 22, 34, 67, 89, 69, 92, 101, 102};
        ShellSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+ arr[i]);
        }
    }
}
