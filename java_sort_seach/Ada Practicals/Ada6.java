import java.io.*;
import java.util.*;

public class Ada6 {

  static int maximumval(int arr[], int n) {
    int max = arr[0];
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public void insertionSort(int arr[], int n) {
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
    for (int i = 1; max / i > 0; i++) {
      insertionSort(arr, n);
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("enter the random no you want to generate : ");
    n = scan.nextInt();
    int n1 = 0;
    scan.close();
    try {
      File file = new File("radixinput.txt");
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
      File f = new File("radixinput.txt");
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
      Ada6 obj = new Ada6();
      obj.radixsort(arr, n);
      File f1 = new File("radixoutput.txt");
      FileWriter fWriter = new FileWriter(f1);
      BufferedWriter writer = new BufferedWriter(fWriter);
      for (int j = 0; j < n; j++) {
        writer.write(arr[j] + " ");
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
