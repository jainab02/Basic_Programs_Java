import java.util.Random;
import java.util.Scanner;

// package Sorting_algo;

public class BubbleSort {
//recursive method
  public void bubbleSort(int arr[], int n) {
    int count=0;
    if (n == 1) {
      return;
    }
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        int temp;
        temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        count++;
      }
    }
    if (count==0) {
        return;
    }
    bubbleSort(arr, n-1);
    
}
//iterative method
// public void bubbleSort(int arr[]){
    //     for(int i=0;i<arr.length - 1;i++){
        // for (int i = 0; i < arr.length -i- 1; i++) {
        //   if (arr[i] > arr[i + 1]) {
        //     int temp;
        //     temp = arr[i];
        //     arr[i] = arr[i + 1];
        //     arr[i + 1] = temp;
        //     count++;
        //   }
        // }
        //         }
  //     }
  //     //printing array
  // for(int i=0;i<arr.length;i++){
  //     System.out.println(arr[i] + " ") ;
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
    BubbleSort obj = new BubbleSort();
    obj.bubbleSort(arr, n);
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+",");
    }
    s.close();
  }
}
