import java.io.*;

public class Moon{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String[] str = in.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int x = Integer.parseInt(str[2]);
            int y = Integer.parseInt(str[3]);
            if((n*x+m*y)%x!=0 && (n*x+m*y)%y!=0)
                System.out.println("NO");
            else{
                System.out.println("YES");
            }
        }
    }
}