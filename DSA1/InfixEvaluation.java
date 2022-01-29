import java.io.*;
import java.util.*;

class InfixEvaluation{

    public static int priority(char ch){
        if(ch=='^')
            return 3;
        else if(ch=='*' || ch=='/')
            return 2;
        else
            return 1;
    }

    public static int evaluate(int a, int b, char op){
        switch(op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return -1;
        }
    }

    public static void evaluateInfix(String exp){
        Stack<Integer> num_stack = new Stack<Integer>();
        Stack<Character> operator_stack = new Stack<Character>();
        for(char ch: exp.toCharArray()){
            if(Character.isDigit(ch))
                num_stack.push(Integer.parseInt(String.valueOf(ch)));
            else{
                while(!operator_stack.isEmpty()){
                    if(operator_stack.peek()=='('){
                        operator_stack.pop();
                        break;
                    }
                    else if(priority(operator_stack.peek())<priority(ch)){
                        break;
                    }
                    else{
                        int b = num_stack.pop();
                        int a = num_stack.pop();
                        char op = operator_stack.pop();
                        num_stack.push(evaluate(a, b, op));
                    }
                }
                operator_stack.push(ch);
            }
        }
        while(!operator_stack.isEmpty()){
            int b = num_stack.pop();
            int a = num_stack.pop();
            char op = operator_stack.pop();
            num_stack.push(evaluate(a, b, op));
        }
        System.out.println("The final evaluted vaue: "+num_stack.pop());
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String exp = in.readLine();
        evaluateInfix(exp);
    }
}