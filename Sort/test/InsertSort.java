import java.util.Arrays;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2025/7/26 15:01
 */
public class InsertSort {

    public static void sort(int[] a){

        int len = a.length;
        int key;
        int i;
        for(int j = 1;j<len;j++){
            key = a[j];
            i = j-1;
            while(i>=0 && a[i]>key){
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] array = {5,6,3,4,1,8,2,7};
        InsertSort.sort(array);
        Arrays.stream(array).forEach((i)-> System.out.print(i+" "));
    }
}
