import java.io.*;
import java.util.*;

class PermutationStack{

    public static void permutation(String inp, String out){
        Stack<Character> stack = new Stack<Character>();
        StringBuilder perm = new StringBuilder();
        StringBuilder seq = new StringBuilder();
        int i = 0;
        for(char ch: inp.toCharArray()){
            stack.push(ch);
            seq.append("S");
            while(!stack.isEmpty()){
                if(stack.peek()!=out.charAt(i))
                    break;
                else{
                    perm.append(stack.pop());
                    seq.append("X");
                    i++;
                }
            }
        }
        System.out.println("The generated sequence: "+perm.toString());
        System.out.println("Series of steps: "+seq.toString());
        System.out.print(stack);
    }

    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inp = in.readLine();
        String op = in.readLine();
        permutation(inp,op);
    }
}