import java.io.*;

public class Divisibility{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String[] str = in.readLine().trim().split(" ");
            long a = Long.parseLong(str[0]);
            long b = Long.parseLong(str[1]);
            System.out.println((b-(a%b))%b);
        }
    }
}