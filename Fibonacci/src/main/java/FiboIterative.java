/**
 * Created by hui_stone on 2018/12/2 0002.
 */
public class FiboIterative {

    static int fib(int n){

        if(n ==0 || n ==1)
            return n;
        int a = 0,b=1,c=0;
        for(int i = 2;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {

        int n = 9;
        System.out.println(fib(9));
    }
}
