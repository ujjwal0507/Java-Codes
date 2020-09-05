import java.io.Serializable;
import java.util.*;

class VertexComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        if(a<b)
            return 1;
        else if(a>b)
            return -1;
        else
            return 0;
    }
}

public class Priority{

    public static void increment(Integer a){
        a = a+3;
    }

    public static void main(String[] args){
        Integer a = 2;
        increment(a);
        System.out.println(a);
    }
}