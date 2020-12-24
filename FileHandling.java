import java.io.*;


public class FileHandling {
    public static void main(String[] args)throws IOException, Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(in.readLine());
        System.out.println(i);
    }
}