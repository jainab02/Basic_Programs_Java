// import java.util.*;
public class QuickSort {
    public static int partition(int[] arr,int left,int right){
        int pivot = arr[right];
        int i = (left-1);     
        for (int j = left; j < right; j++) {
            if (arr[j]<=pivot) {
                i++;
                //swapping
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
            // i++;
            // swapping with pivot to sort the other side
            int temp = arr[i+1];
            arr[i+1]= arr[right];
            arr[right]=temp;
            return (i+1);
        }
    
    
    public static void quicksort(int[] arr,int left,int right){
        if (left<right) {
            int pivotIndex = partition(arr,left,right);
            quicksort(arr, left, pivotIndex-1);
            quicksort(arr, pivotIndex+1, right);
        }
    }

    public static void printarr(int[] arr,int n){
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]+",");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr ={5,6,72,1,3,5,7,8};
        int n=arr.length;
        quicksort(arr,0,n-1);
        System.out.println("sorted array is ");
        printarr(arr,n);
    }
}
