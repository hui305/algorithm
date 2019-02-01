/**
 * change amount
 * recursion version
 * Created by hui_stone on 2019/1/31 0031.
 */
public class AmountChange {

    private static int[] CoinType ={1,5,10,25,50};

    public static int changeAmount(int amount,int n){

        if(amount < 0 || n ==0){
            return 0;
        }
        if(amount ==0)
            return 1;
        return changeAmount(amount,n-1)+changeAmount(amount-CoinType[n-1],n);
    }
    public static void main(String[] args) {

        long startTime  = System.currentTimeMillis();
        System.out.println("coin type = "+changeAmount(1000,5));
        System.out.println("elapsed time： " + ( System.currentTimeMillis() - startTime ));
    }
}
