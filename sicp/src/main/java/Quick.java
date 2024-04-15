import java.util.Arrays;

/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2022/11/7 20:05
 *
 *  快排，可以叫归位算法
 *  子序列：L<=pivot；  U ； piovt<G U：lo ， hi 两个指针
 *  两个指针不断向中间靠拢，最后找到位置。
 */

public class Quick {

    public static void main(String[] args) {

//        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
//        int[] data = {2,4,5,1,3};
        int[] data = {8,4,9,0,1,3,2,5,7,6};
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;
        // call quicksort() on array data
        sort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
//        int[] a ={8,4,9,0,1,3,2,5,7,6};
//        sort(a,0,a.length-1);
//        Arrays.stream(a).forEach(System.out::print);
    }
    private static void sort(int[] a,int lo,int hi){
        if(hi<=lo) return;
        int pivot = partition3(a,lo,hi);
        sort(a,lo,pivot-1);
        sort(a,pivot+1,hi);
    }

    private static int partition3(int[] a,int lo,int hi){
        int i = lo;
        int j = hi+1;
        int v = a[lo];
        while(true){
            while(a[++i]<v){
                if(i == hi)
                    break;//跳出循环
            }
            while(a[--j]>v){
                if(j == lo)
                    break;
            }
            if(i>=j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    private static int partition(int[] a,int lo,int hi){
        // 以最左边的数(left)为基准
        int v = a[lo];
        int start = lo;
        while(true){
            while(lo<hi && a[lo]<=v)
                lo++;
            while(lo<hi && a[hi]>=v)
                hi--;
            if(lo>=hi)
                break;
            exch(a,lo,hi);
        }
        exch(a,start,hi);
        return hi;
    }

        private static int partition2(int[] a,int lo,int hi){

        // 以最左边的数(left)为基准
        int v = a[lo];
        while (lo < hi) {
            // 从序列右端开始，向左遍历，直到找到小于pivot的数
            while (lo < hi && a[hi] >= v)
                hi--;
            // 找到了比base小的元素，将这个元素放到最左边的位置
            if(lo != hi)
               a[lo] = a[hi];

            // 从序列左端开始，向右遍历，直到找到大于pivot的数
            while (lo < hi && a[lo] <= v)
                lo++;
            // 找到了比pivot大的元素，将这个元素放到最右边的位置
            if(lo != hi)
                a[hi] = a[lo];
        }
        // 最后将pivot放到left位置。此时，left位置的左侧数值应该都比left小；
        // 而left位置的右侧数值应该都比left大。
        a[lo] = v;
        return lo;

//        int i = lo,j = hi+1;
//        int v = a[lo];
//        while(true){
//            while(a[++i]<v){
//                if(i == hi)
//                    break;
//            }
//            while (a[--j]>v){
//                if(j == lo)
//                    break;
//            }
//            if(i>=j)
//                break;
//            exch(a,i,j);
//        }
//        exch(a,lo,j);
//        return j;
    }

    private static void exch(int[] a,int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
////        if(a[i] == a[j])
////            return;
//        a[i] = a[i]^a[j];
//        a[j] = a[i]^a[j];
//        a[i] = a[i]^a[j];
    }
}
