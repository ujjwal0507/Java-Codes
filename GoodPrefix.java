import java.io.*;
import java.util.*;

class GoodPrefix1{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String str = in.readLine().trim();
            String kx[] = in.readLine().trim().split(" ");
            int k = Integer.parseInt(kx[0]);
            int x = Integer.parseInt(kx[1]);
            int ctr = 0, left = 0;
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(char ch: str.toCharArray()){
                if(map.containsKey(ch)){
                    if(map.get(ch)>=x){
                        map.put(ch, map.get(ch)+1);
                        left++;
                    }
                    else{
                        map.put(ch, map.get(ch)+1);
                        ctr++;
                    }
                }
                else{
                    map.put(ch, 1);
                    ctr++;
                }
                if(left>k)
                    break;
            }
            System.out.println(ctr);
        }
    }
}