import java.util.*;

class RevStack{

    public static Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> reversed = new Stack<>();
        while(!stack.isEmpty())
            reversed.push(stack.pop());
        return reversed;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(reverse(stack));
    }
}