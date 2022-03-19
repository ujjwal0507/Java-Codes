package DSA2.Sorting;

public class QuickSort {

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high;

        while(i<j){
            while(arr[i]<=pivot) i++;
            while(arr[j]>pivot) j--;
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public static void main(String[] args){

        int[] arr = new int[]{3,2,1,5,6,4};

        quickSort(arr, 0, arr.length-1);

        for(int ele: arr) System.out.print(ele+"\t");

    }
    
}
