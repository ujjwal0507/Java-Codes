import java.util.*;

class StackQueue{
    Queue<Integer> queue1, queue2;

    public StackQueue(){
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
    }

    public void push(int data){
        if(queue1.isEmpty() && queue2.isEmpty())
            queue1.add(data);
        if(queue2.isEmpty())
            queue1.add(data);
        else
            queue2.add(data);
    }

    public int pop(){
        if(queue1.isEmpty()){
            while(!(queue2.size()==1)){
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }   
        else{
            while(queue1.size()!=1){
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        }
    }

    public static void main(String[] args){
        StackQueue stack = new StackQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}