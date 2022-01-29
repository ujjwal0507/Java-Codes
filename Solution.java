import java.io.*;
import java.util.*;

import javax.swing.plaf.ToolBarUI;
 
public class Solution {
 
    static BufferedReader in;
    static StringTokenizer st;

    public static void test_cases() throws IOException{ 
        String word = readLine().toLowerCase();
        String ans = "";
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        vowelsSet.add('y');
        for(char ch: word.toCharArray()){
            if(vowelsSet.contains(ch)){
                continue;
            }
            ans = ans+'.'+ch;
        }
        System.out.println(ans);
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