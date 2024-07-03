import java.util.*;
import java.util.Scanner;

public class HeapSort {

  void heapsort(int arr[],int n) {
    // int n = arr.length;
    Build_mx_heapify(arr,n);
    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      Max_Heapify(arr, i, 0);
    }
  }

  void Build_mx_heapify(int arr[],int n) {
    // int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      Max_Heapify(arr, n, i);
    }
  }

  void Max_Heapify(int arr[], int n, int root) {
    int large = root; //largest is the root
    int left = 2 * root+1; //left hand side node is 2i+1
    int right = 2 * root + 2; //right hand side node is 2i+2
    // int n = arr.length;
    //if left node is greater then large would be = left node
    if (left < n && arr[left] > arr[large]) {
      large = left;
    }
    //if right node is greater then large would be = right node
    if (right < n && arr[right] > arr[large]) {
      large = right;
    }

    // now largest node is either left one or right one so we need to swap it to root
    //..so the largest element is at root
    //if the largest node is root then there is no problem so it will continue to the rest of the tree
    if (large != root) {
      int temp = arr[root];
      arr[root] = arr[large];
      arr[large] = temp;
      Max_Heapify(arr, n, large); //for the rest of the sub tree
    }
  }

  //   void printarr(int arr[]) {
  // }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n;

    System.out.println("enter the random no you want to generate ");
    n = s.nextInt();
    int arr[] = new int[n];
    // int len = arr.length;
    Random r = new Random();
    for (int i = 0; i < n; i++) {
      arr[i] = r.nextInt(100);
    }
    // System.out.print("Entries of array A are : ");
    // for (int i = 0; i < n; i = i + 1) {
    //   System.out.print(arr[i] + ", ");
    // }
    // System.out.println();
    s.close();
    // int[] arr = { 2, 4, 1, 3, 57, 83 };
    System.out.println("unsorted array is ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println();
    HeapSort obj = new HeapSort();
    // obj.printarr(arr);
    obj.heapsort(arr,n);
    System.out.print("sorted array is ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ",");
    }
    // obj.printarr(arr);
  }
}
