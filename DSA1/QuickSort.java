import java.io.*;

public class QuickSort {

    public static int partition(int[] arr, int l, int r){
        int pivot = arr[l];
        int i = l, j = r+1;
        while(i<j){
            do{
                i++;
            }while(arr[i]<=pivot);
            do{
                j--;
            }while(arr[j]>=pivot);
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        System.out.println(j);
        return j;
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l<r){
            int j = partition(arr, l, r);
            quickSort(arr, l, j);
            quickSort(arr, j+1, r);
        }
    }

    public static void main(String[] args) throws IOException{
        int[] arr = new int[]{12,5,7,8,3,8,2,7,2,5};
        quickSort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}