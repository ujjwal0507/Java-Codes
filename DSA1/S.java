import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S{
    public static void main(String[] args)throws IOException{
        
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        temp.add(1);
        temp.add(2);

        ans.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);

        ans.add(temp);

        System.out.println(ans);

    }
}