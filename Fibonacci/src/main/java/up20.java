/**
 * TODO
 *
 * @author bobstone
 * @version 1.0
 * @date 2023/11/12 21:55
 */
public class up20{

    public static  int up(int n){
        if(n <=0){
            throw new IllegalArgumentException("argument is wrong");
        }
        if(n == 1){
            return 1;
        } else if(n ==2){
            return 2;
        } else{
            return up(n-1)+up(n-2);
        }
    }

    public static int updy(int n){
        //自底向上
        int a = 1;
        int b = 2;
        int c = 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        for(int i = 3 ;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {

//        System.out.println(up20.up(1));
//        System.out.println(up20.up(2));//2
//        System.out.println(up20.up(3));//3
//        System.out.println(up20.up(4));//5
        System.out.println(up20.up(10));//8
        System.out.println(up20.updy(10));//8

    }
}
