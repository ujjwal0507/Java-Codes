import java.math.*;

class BeautifulString{

    public static BigInteger power(int x, int y){
        BigInteger res = new BigInteger("1");
        BigInteger base = BigInteger.valueOf(x);
        while(y>0){
            if(y%2==1){
                res = res.multiply(base);
            }
            base = base.multiply(base);
            y = y/2;
        }

        return res;
    }

    public static int catalan(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                arr[i] += arr[j]*arr[i-j-1];
            }
        }

        for(int i=0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        return arr[n];
    }

    public static void main(String[] args){
        BigInteger bigInteger = new BigInteger("1000000000000000000000000000000000000000000000000000000000000");
        System.out.println(bigInteger);
    }
}
