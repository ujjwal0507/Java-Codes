import java.io.*;
import java.util.*;

class SpanOfArray{

    public static int[] getSpanArray(int[] arr){
        int[] span = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        span[0] = 1;
        stack.push(-1);
        for(int i=0;i<arr.length;i++){
            if(stack.peek()>arr[i]){
                while(stack.peek()!=-1)
                    stack.pop();
            }
            stack.push(arr[i]);
            span[i] = stack.size()-1;
        }
        return span;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().trim().split(" ");
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(str[i]);
        int span[] = getSpanArray(arr);
        for(int i=0;i<n;i++)
            System.out.print(span[i]+"\t");
    }   
}