import java.io.*;
import java.util.*;
public class Ada3 {
  //declaring global variable
  static long cost = 0;
  //partition method divides array in sorted and unsorted array
  public static int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int i = (left - 1);
    for (int j = left; j < right; j++) {
      cost++;
      if (arr[j] <= pivot) {
        i++;
        //swapping
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        cost++;
      }
    }
    // swapping with pivot to sort the other side
    int temp = arr[i + 1];
    arr[i + 1] = arr[right];
    arr[right] = temp;
    cost++;
    return (i + 1);
  }
  //quicksort recursively calls itself and sort the array
  public static void quicksort(int[] arr, int left, int right) {
    if (left < right) {
      cost++;
      int pivotIndex = partition(arr, left, right);
      quicksort(arr, left, pivotIndex - 1);
      quicksort(arr, pivotIndex + 1, right);
    }
  }
  //main method
  public static void main(String[] args) throws ClassNotFoundException {
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("enter the random no you want to generate : ");
    n = scan.nextInt();
    int n1 = 0;
    scan.close();
    try {
      File file = new File("Quickinput.txt");
      FileWriter fileWriter = new FileWriter(file);
      BufferedWriter writer = new BufferedWriter(fileWriter);
      for (int i = 0; i < n; i++) {
        n1 = (int) (Math.random() * 10000 + 1);
        writer.write(n1 + "");
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      File f = new File("Quickinput.txt");
      FileReader filereader = new FileReader(f);
      BufferedReader reader = new BufferedReader(filereader);
      String x;
      int arr[] = new int[n];
      int i = 0;
      while ((x = reader.readLine()) != null) {
        arr[i] = Integer.parseInt(x);
        i++;
      }
      reader.close();
      quicksort(arr, 0, n - 1);
      File f1 = new File("Quickoutput.txt");
      FileWriter fWriter = new FileWriter(f1);
      BufferedWriter writer = new BufferedWriter(fWriter);
      for (int j = 0; j < n; j++) {
        writer.write(arr[j] + " ");
        writer.newLine();
      }
      System.out.println("cost of the quick sort algorithm  = " + cost);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
