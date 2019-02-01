/**
 * Iteration
 * Created by hui_stone on 2019/2/1 0001.
 */
public class Factorial {

    public static long facRecursion(long num){

        if(num == 1)
            return 1;
        return num * facRecursion(num -1);
    }
    public static long facIteration(long num){

        long product = 1;
        long count = 1;
        for(;;){
            if(count>num)
                return product;
            product = product*count;
            count++;
        }
    }

    public static void main(String[] args) {

        /**
         * int 溢出 用long
         */
        long start = System.currentTimeMillis();

        System.out.println(Factorial.facRecursion(15));
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start));

//        System.out.println(Factorial.facIteration(15));
//        System.out.println("Elapsed time:"+ (System.currentTimeMillis()-start));
    }
}
