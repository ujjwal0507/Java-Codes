public class DynamicStack{
    int CAPACITY;
    int top = 0;
    int stack[];
    public DynamicStack(){
        this.CAPACITY = 8;
        stack = new int[CAPACITY];
    }
    public DynamicStack(int n){
        this.CAPACITY = n;
        stack = new int[CAPACITY];
    }

    public void push(int data){
        if(top==CAPACITY-1){
            expand();
        }

    }
    public void expand(){
        int temp[] = new int[CAPACITY];
        for(int i=0;i<CAPACITY;i++)
            temp[i] = stack[i];
        stack = new int[CAPACITY*2];
        for(int i=0;i<CAPACITY;i++)
            stack[i] = temp[i];
    }

    public void shrink(){
        int temp[] = new int[CAPACITY];
        temp[0] = 1;
    }
}