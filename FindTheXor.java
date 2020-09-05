import java.io.*;

public class FindTheXor{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        int q = Integer.parseInt(in.readLine());
        while(q-->0){
            String[] str = in.readLine().trim().split(" ");
            int c = Integer.parseInt(str[0]);
            int x = Integer.parseInt(str[1]);
            if(c==1){
                arr[x-1]++;
            } 
            else{
                int xor = 0;
                while(arr[x-1]!=0)
                    x++;
                for(int i=x;i<n;i++){
                    if(arr[i]==0){
                        xor = xor^(i+1);
                    }
                    else break;
                }
                if(arr[x-1]==0)
                    xor = xor^x;
                System.out.println(xor);
            }
        }
    }
}