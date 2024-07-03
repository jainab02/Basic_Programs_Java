import java.util.*;

public class BucketSort {

  static int maximumval(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  // public void insertionSort(int arr[], int n) {
  //   for (int i = 1; i < n; i++) {
  //     int key = arr[i];
  //     int j = i - 1;
  //     while ((j >= 0) && (arr[j] > key)) {
  //       arr[j + 1] = arr[j];
  //       j--;
  //     }
  //     arr[j + 1] = key;
  //   }
  // }

  public void bucketsort(int arr[], int n, int max) {
    int bucket[] = new int[max+1];
    if (n<0) {
      return;
    }
    for (int i = 0; i <=max; i++) {
      bucket[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      bucket[arr[i]]++;
    }
    // for (int i = 0; i < n; i++) {
    //  / insertionSort(arr, n);
    // }
    for (int i = 0, j = 0; i <= max; i++) {
      while (bucket[i] > 0) {
        arr[j++] = i;
        bucket[i]--;
      }
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
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println();
    // int arr[] = {99,2,45,7,3,7,46,0};
    // float arr[] = {(float)0.23,(float)0.21,(float)0.78,(float)0.09,(float)0.67};
    // int n= arr.length;
    int max = maximumval(arr, n);
    BucketSort obj = new BucketSort();
    obj.bucketsort(arr, n, max);

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + ",");
    }
  }
}
