import java.util.*;
public class InsertionSort {
//recursive method
    public void insertionSort(int arr[],int n){
        if (n==1) {
            return;
        }
            for (int i = 1; i < arr.length; i++) {  
                int key = arr[i];  
                int j = i-1;  
                while ( (j >=0) && ( arr [j] > key ) ) {  
                    arr [j+1] = arr [j];  
                    j--;  
                }  
                arr[j+1] = key; 
            } 
            insertionSort(arr, n-1);
    }
//iterative method
    // public  void insertionSort(int arr[],int n){
    //     for (int i = 1; i < arr.length; i++) {  
    //         int key = arr[i];  
    //         int j = i-1;  
    //         while ( (j >=0) && ( arr [j] > key ) ) {  
    //             arr [j+1] = arr [j];  
    //             j--;  
    //         }  
    //         arr[j+1] = key; 
    //     } 
    //      //printing array
    // for(int i=0;i<arr.length;i++){
    //     System.out.println(arr[i] + "\n") ;
    // }
    // }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("enter a no ");
        n = s.nextInt();
        int[] arr = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
          arr[i] = r.nextInt(1000) + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    
        System.out.println("sorted array is ");
        InsertionSort obj = new InsertionSort();
        obj.insertionSort(arr,n);;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        s.close();
      }
    }
    

