import java.io.*;

class ChefGift{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            int n = Integer.parseInt(in.readLine());
            String ins = in.readLine();
            ins = "X"+ins;
            int x = 0,y = 0;
            for(int i=1;i<n;i++){
                switch(ins.charAt(i)){
                    case 'L':
                        if(ins.charAt(i-1)!='L' || ins.charAt(i)!='R'){
                            x--;
                        }
                        break;
                    case 'R':
                        if(ins.charAt(i-1)!='L' || ins.charAt(i)!='R'){
                            x++;
                        }
                        break;
                    case 'U':
                        if(ins.charAt(i-1)!='U' || ins.charAt(i-1)!='D'){
                            y++;
                        }
                        break;
                    case 'D':
                        if(ins.charAt(i-1)!='U' || ins.charAt(i-1)!='D'){
                            y--;
                        }
                        break;
                }
            }
            System.out.println(x+" "+y);
        }
    }
}