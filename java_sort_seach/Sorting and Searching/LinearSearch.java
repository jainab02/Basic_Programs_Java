import java.util.*;

public class LinearSearch {

  public static int search(int arr[], int n1, int key) {
    if (n1 == 0) {
      return -1;
    } else if (arr[n1 - 1] == key) {
      return n1 - 1;
    } else {
      return search(arr, n1 - 1, key);
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("enter the random you want to generate");
    int n = s.nextInt();
    int[] arr = new int[n];
    Random r = new Random();
    for (int i = 0; i < n; i++) {
      arr[i] = r.nextInt(100);
    }
    System.out.println("elements are:");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println();
    System.out.println("enter the no you want to search");
    int key = s.nextInt();
    int n1 = arr.length;
    // System.out.println(n1);
    int index = search(arr, n1, key);
    if (index == -1) {
      System.out.println("element not found!");
    } else {
      System.out.println("element found !");
    }
    s.close();
  }
}
