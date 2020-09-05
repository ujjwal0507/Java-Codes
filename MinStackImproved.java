import java.util.*;

class MinStackImproved{
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    
    public MinStackImproved(){
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }

    public void push(int data){
        if(stack.isEmpty()){
            stack.push(data);
            min_stack.push(data);
        }
        else{
            if(min_stack.peek()>data){
                min_stack.push(data);
                stack.push(data);
            }
            else{
                stack.push(data);
            }
        }
    }

    public int pop(){
        if(min_stack.peek()==stack.peek()){
            min_stack.pop();
            return stack.pop();
        }
        else{
            return stack.pop();
        }
    }

    public int getMin(){
        if(min_stack.isEmpty())
            return -10000;
        else{
            return min_stack.peek();
        }
    }
}

class MinStackImprovedMain{
    public static void main(String[] args){
        MinStackImproved minStack = new MinStackImproved();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(7);
        minStack.push(4);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(2);
        minStack.push(6);
        System.out.println(minStack.getMin());
    }
}