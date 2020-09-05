import java.io.*;
import java.util.*;

class infixToPostfix{

    public static int priority(char ch){
        if(ch=='^')
            return 3;
        else if(ch=='*'||ch=='/')
            return 2;
        else if(ch=='+'||ch=='-')
            return 1;
        return 0;
    }

    public static void infixToPostfixConvert(String exp){
        Stack<Character> stack = new Stack<Character>();
        for(char ch: exp.toCharArray()){
            if(Character.isDigit(ch))
                System.out.print(ch);
            else if(ch=='(')
                stack.push(ch);
            else if(ch==')'){
                while(stack.peek()!='(')
                    System.out.print(stack.pop());
                stack.pop();
            }
            else{
                while(!stack.isEmpty()){
                    if(priority(stack.peek())<priority(ch))
                        break;
                    else{
                        System.out.print(stack.pop());
                    }
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String exp = in.readLine();
        infixToPostfixConvert(exp);
    }   
}