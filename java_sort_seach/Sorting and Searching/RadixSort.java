import java.util.*;
public class RadixSort {

  static int maximumval(int arr[], int n) {
    int max = arr[0];
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public void insertionSort(int arr[],int n) {
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while ((j >= 0) && (arr[j] > key)) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public void radixsort(int arr[], int n) {
    int max = maximumval(arr, n);
    for (int i = 1; max/i >0; i++) {
        insertionSort(arr,n);
    }
  }

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
    s.close();
    // int arr[] = { 88, 0, 35, 335, 56, 77, 88 };
    // int n = arr.length;
    RadixSort obj = new RadixSort();
    obj.radixsort(arr, n);
    for (int i = 0; i < n; i++) {
        System.out.print(arr[i]+",");
    }
  }
}
