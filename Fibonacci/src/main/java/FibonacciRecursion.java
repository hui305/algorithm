/**
 * Created by hui_stone on 2018/12/2 0002.
 */
public class FibonacciRecursion {

    /**
     * n 从0开始
     * 0 1 1 2 3 5 8 13
     * @param n
     * @return
     */
    public static int fib(int n){

        if(n==0 || n ==1)
            return n;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(fib(n));
    }
}
