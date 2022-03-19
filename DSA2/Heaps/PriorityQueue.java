package DSA2.Heaps;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    
    List<Integer> _value;
    
    public PriorityQueue(){
        _value = new ArrayList<>();
        _value.add(-1);
    }

    public void insert(int element){
        int index = _value.size();
        _value.add(element);

        int i = index;
        while(i>1){
            int parent = i/2;
            if(_value.get(parent)<_value.get(i)){
                int temp  = _value.get(parent);
                _value.set(parent, _value.get(i));
                _value.set(i, temp);
            }
            else{
                return;
            }
            i = parent;
        }
    }

    public int delete(){

        if(_value.size()<=1){
            System.out.println("Not possible");
            return Integer.MIN_VALUE;
        }

        int element = _value.get(1);
        int n = _value.size();
        _value.set(1, _value.get(n-1));
        _value.remove(n-1);

        n--;

        int i = 1;

        while(i<n){
            int leftChildIndex = 2*i;
            int rightChildIndex = 2*i+1;

            if(leftChildIndex<n && rightChildIndex<n && (_value.get(leftChildIndex)>_value.get(i) || _value.get(rightChildIndex)>_value.get(i))){
                int maxChildIndex = _value.get(leftChildIndex)>_value.get(rightChildIndex)? leftChildIndex: rightChildIndex;
                int temp = _value.get(i);
                _value.set(i, _value.get(maxChildIndex));
                _value.set(maxChildIndex, temp);
                i = maxChildIndex;
            }
            else if(leftChildIndex<n && _value.get(leftChildIndex)>_value.get(i)){
                int temp = _value.get(i);
                _value.set(i, _value.get(leftChildIndex));
                _value.set(leftChildIndex, temp);
                break;
            }
            else{
                break;
            }
        }
        return element;
    }

    public static void main(String[] args){

        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.insert(10);
        priorityQueue.insert(23);
        priorityQueue.insert(7);
        priorityQueue.insert(92);
        priorityQueue.insert(31);
        priorityQueue.insert(6);
        priorityQueue.insert(34);

        List<Integer> deleted = new ArrayList<>();

        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());
        deleted.add(priorityQueue.delete());  

        System.out.println(priorityQueue._value);
        System.out.println(deleted);

    }
}
