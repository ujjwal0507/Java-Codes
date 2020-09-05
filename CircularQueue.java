import java.io.*;

class CircularQueue{

    int arr[];
    int size, front, rear;

    
    public CircularQueue(int size){
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data){
        if(this.isFull())
            throw new IllegalArgumentException("Queue is full!!!");
        if(this.isEmpty()){
            front = 0;
            rear = 0;
            arr[front] = data;
        }
        else{
        rear = (rear+1)%size;
        arr[rear] = data;
        }
        System.out.println(data+" is inserted");

    }

    public int dequeue(){
        int data = 0;
        if(this.isEmpty())
            throw new IllegalArgumentException("Queue is Empty!!!");
        /*if(front==rear){
            data = arr[front];
            arr[front] = 0;
            front = -1;
            rear = -1;
        }
        else{
            data = arr[front];
            arr[front] = 0;
            front = (front+1)%size;
        }*/
        data = arr[front];
        arr[front] = 0;
        front = (front+1)%this.size;
        if(front==rear+1){
            front = -1;
            rear = -1;
        }
        return data;
    }

    public int front(){
        if(front!=rear)
            return arr[front];
        throw new IllegalArgumentException("Queue is empty!!");
    }

    public void print(){
        System.out.print("The queue: ");
        for(int i=0;i<size;i++){
            if(arr[i]==0)
                System.out.print("_ ");
            else
                System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public boolean isFull(){
        if(front==0 && rear==size-1 || front==rear+1)
            return true;
        return false;
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException{
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.print();
        queue.enqueue(2);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(3);
        queue.print();
        queue.enqueue(4);
        queue.print();
        queue.enqueue(5);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(6);
        queue.print();
        queue.enqueue(7);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(8);
        queue.print();
        queue.dequeue();
        queue.print();
        
    }
}