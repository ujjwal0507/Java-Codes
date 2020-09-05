import java.io.*;

class CatWalk{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String[] str = in.readLine().trim().split(" ");
            long a = Integer.parseInt(str[0]);
            long b = Integer.parseInt(str[1]);
            long c = Integer.parseInt(str[2]);
            long d = Integer.parseInt(str[3]);
            str = in.readLine().trim().split(" ");
            long x = Integer.parseInt(str[0]);
            long y = Integer.parseInt(str[1]);
            long x1 = Integer.parseInt(str[2]);
            long y1 = Integer.parseInt(str[3]);
            long x2 = Integer.parseInt(str[4]);
            long y2 = Integer.parseInt(str[5]);
            if(x1==x2 && y1==y2)
                System.out.println("No");
            else if(x1==x2){
                if(a!=0 || b!=0)
                    System.out.println("No");
                else{
                    long m = c-d;
                    if(m>0){
                        if(Math.abs(m)<=Math.abs(y-y1))
                            System.out.println("Yes");
                        else System.out.println("No");
                    }
                    else{
                        if(Math.abs(m)<=Math.abs(y2-y))
                            System.out.println("Yes");
                        else System.out.println("No");
                    }
                }
            }
            else if(y1==y2){
                if(c!=0 || d!=0)
                    System.out.println("No");
                else{
                    long n = a-b;
                    if(n>0){
                        if(Math.abs(n)<=Math.abs(x-x1))
                            System.out.println("Yes");
                        else System.out.println("No");
                    }
                    else{
                        if(Math.abs(n)<=Math.abs(x-x2))
                            System.out.println("Yes");
                        else System.out.println("No");
                    }
                }
            }
            else{
                long m = a-b;
                long n = c-d;
                boolean result = true;
                if(m>0 && Math.abs(m)>Math.abs(y-y1)){
                        result = false;
                }
                else if(m<0 && Math.abs(m)>Math.abs(y-y2))
                    result = false;
                else if(n>0 && Math.abs(n)>Math.abs(x-x1))
                    result = false;
                else if(n<0 && Math.abs(n)>Math.abs(x-x2))
                    result = false;
                if(result)
                    System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}