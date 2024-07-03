import java.util.*;

public class BinarySearch {

  public int search(int arr[], int left, int right, int key) {
      // System.out.println(mid);
      int mid;
      if (right >= left) {
          mid = (left + right) / 2;
      if(arr[mid]<key){
        left=mid+1;
      }
      else if(arr[mid]>key){
        right=mid-1;
      }
      else{
        return mid;
      }
      return left;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("enter the random no you want to generate");
    int n = s.nextInt();
    int[] arr = new int[n];
    Random r = new Random();
    // int n1=arr.length;
    for (int i = 0; i < n; i++) {
      arr[i] = r.nextInt(100);
    }
    System.out.println("elements of array is");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println();
    System.out.println("enter the element you want to search:");
    int key = s.nextInt();
    BinarySearch ob = new BinarySearch();
    int n1=arr.length;
    int index = ob.search(arr, 0, n1 - 1, key);
    if (index == -1) {
      System.out.println("element not found!");
    } else {
      System.out.println("element found at "+ index);
    }
    s.close();
  }
}
