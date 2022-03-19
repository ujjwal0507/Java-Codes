import java.io.*;
import java.util.*;

import javax.swing.plaf.ToolBarUI;
 
public class Solution {
 
    static BufferedReader in;
    static StringTokenizer st;

    public static void test_cases() throws IOException{ 
        Set<List<Integer>> set = new HashSet<>();

        set.add(Arrays.asList(1,2));
        set.add(Arrays.asList(1,2));
        
        System.out.println(set);
    }

    public static long nc2(long n){
        return n*(n-1)/2;
    }
 
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        int  t = 1;
        // int t = readInt();
        while(t-->0){
            test_cases();
        }
    }
 
    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(in.readLine().trim());
        return st.nextToken();
    }
 
    public static long readLong() throws IOException {
        return Long.parseLong(next());
    }
 
    public static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
 
    public static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
 
    public static char readCharacter() throws IOException {
        return next().charAt(0);
    }
 
    public static String readLine() throws IOException {
        return in.readLine().trim();
    }
 
    public static String[] readLineArray() throws IOException{
        return readLine().split(" ");
    }
}