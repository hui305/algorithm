/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/2/23 22:02
 */
public class FibDynamic {

    public static int fib(int n){
        if(n == 1 || n == 2)
          return 1;
        else{
            int a = 1;
            int b = 1;
            int c = 0;
            for(int i = 3;i<= n;i++){
                c = a +b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {

        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
    }
}
