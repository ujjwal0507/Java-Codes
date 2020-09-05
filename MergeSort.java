import java.io.*;
import java.util.*;

public class MergeSort {

    public static void merge(int[] arr, int l, int mid, int r){
        Queue<Integer> queue = new LinkedList<>();
        int l1 = l, r1 = mid, l2 = mid+1, r2 = r;
        while(l1<=r1 && l2<=r2){
            if(arr[l1]<arr[l2]){
                queue.add(arr[l1++]);
            }
            else{
                queue.add(arr[l2++]);
            }
        }
        while(l1<=r1){
            queue.add(arr[l1++]);
        }
        while(l2<=r2){
            queue.add(arr[l2++]);
        }
        for(int i=l;i<=r;i++){
            arr[i] = queue.remove();
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] str = in.readLine().trim().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = Integer.parseInt(str[i]);
        mergeSort(arr, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}