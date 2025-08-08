import java.util.Arrays;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2025/7/26 11:23
 */
public class SelectSort {

    public static void sort(int[] a){
        int min,temp;
        int len = a.length;
        for(int i = 0;i<len-1;i++){
            min = i;
            for(int j = i+1;j<=len-1;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,4,1,8,2,7};
        SelectSort.sort(array);
        Arrays.stream(array).forEach((i)-> System.out.print(i+" "));
    }
}
