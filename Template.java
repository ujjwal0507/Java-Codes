import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Template {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void test_cases() throws IOException{
        
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = readInt();
        while(t-->0){
            test_cases();
        }
        out.close();
    }

    public static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine().trim());
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
        return br.readLine().trim();
    }

    public static String[] readLineArray() throws IOException{
        return readLine().split(" ");
    }

    public static int[] readIntArray() throws IOException{
        String[] str = readLineArray();
        int[] arr = new int[str.length];
        for(int i=0;i<arr.length;i++)
            arr[i] = Integer.parseInt(str[i]);
        return arr;
    }

    public static long[] readLongArray() throws IOException{
        String[] str = readLineArray();
        long[] arr = new long[str.length];
        for(int i=0;i<str.length;i++)
            arr[i] = Long.parseLong(str[i]);
        return arr;
    }

}