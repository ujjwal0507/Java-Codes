import java.io.*;
import java.util.*;
 
public class Solution {
 
    static BufferedReader in;
    static StringTokenizer st;

    public static void test_cases() throws IOException{ 
        for (int i = 1; i <= 5; i++) {
            for (i = 1; i <= 3; i++) {
               System.out.println("Hello world!");
            }
         }
    }
 
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        //int  t = 1;
        int t = readInt();
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