import java.io.*;
import java.util.*;

public class Ada5 {

  //declaring global variables
  static long cost = 0;
  static long start_time, end_time;

  //method for finding max value
  static int maximumval(int arr[], int n) {
    int max = arr[0];
    for (int i = 0; i < n; i++) {
      // cost++;
      if (arr[i] > max) {
        max = arr[i];
        cost++;
      }
    }
    return max;
  }

  //counting sort
  public void countsort(int arr[], int n, int max) {
    cost = 0;
    int index[] = new int[max + 1]; //frequency count of any no
    int main[] = new int[n + 1]; //output array
    start_time = System.nanoTime();
    //all the values becoming zeros
    for (int i = 0; i <= max; i++) {
      index[i] = 0;
    }
    //count of the value in an array
    for (int i = 0; i < n; i++) {
      index[arr[i]]++;
    }
    for (int i = 1; i <= max; i++) {
      cost++;
      index[i] += index[i - 1];
    }
    //accurate position of the element and place it there
    for (int i = n - 1; i >= 0; i--) {
      main[index[arr[i]] - 1] = arr[i];
      index[arr[i]]--;
      cost++;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = main[i];
    }
    end_time = System.nanoTime();
  }

  //radix sort using count sort(stable sort)
  public void radixsort(int arr[], int n) {
    cost = 0;
    int max = maximumval(arr, n);
    start_time = System.nanoTime();
    for (int i = 1; max / i > 0; i++) {
      cost++;
      countradix(arr, n, max);
    }
    end_time = System.nanoTime();
  }

  //count sort for radix
  public void countradix(int arr[], int n, int max) {
    cost = 0;
    int index[] = new int[max + 1]; //frequency count of any no
    int main[] = new int[n + 1]; //output array
    start_time = System.nanoTime();
    //all the values becoming zeros
    for (int i = 0; i <= max; i++) {
      index[i] = 0;
    }
    //count of the value in an array
    for (int i = 0; i < n; i++) {
      index[arr[i]]++;
    }
    for (int i = 1; i <= max; i++) {
      cost++;
      index[i] += index[i - 1];
    }
    //accurate position of the element and place it there
    for (int i = n - 1; i >= 0; i--) {
      main[index[arr[i]] - 1] = arr[i];
      index[arr[i]]--;
      cost++;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = main[i];
    }
    end_time = System.nanoTime();
  }

  //bucket sort
  public void bucketsort(int arr[], int n, int max) {
    cost = 0;
    int bucket[] = new int[max + 1];
    start_time = System.nanoTime();
    for (int i = 0; i <= max; i++) {
      bucket[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      cost++;
      bucket[arr[i]]++;
    }
    for (int i = 0, j = 0; i <= max; i++) {
      cost++;
      while (bucket[i] > 0) {
        arr[j++] = i;
        bucket[i]--;
        cost++;
      }
    }
    end_time = System.nanoTime();
  }

  //main method
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("enter the random no you want to generate : ");
    n = scan.nextInt();
    int n1 = 0;
    try {
      File file = new File("input.txt");
      FileWriter fileWriter = new FileWriter(file);
      BufferedWriter writer = new BufferedWriter(fileWriter);
      for (int i = 0; i < n; i++) {
        n1 = (int) (Math.random() * 100 + 1);
        writer.write(n1 + "");
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      File f = new File("input.txt");
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
      System.out.println("Enter the no of  sort you want to perform: \n");
      System.out.println("1.Counting sort \n");
      System.out.println("2.Radix Sort");
      System.out.println("3.Bucket Sort");
      int x1 = scan.nextInt();
      switch (x1) {
        case 1:
          Ada5 obj = new Ada5();
          int max = maximumval(arr, n);
          obj.countsort(arr, n, max);
          System.out.println("cost of the Counting sort algorithm : " + cost);
          long totalTime = end_time - start_time;
          System.out.println("time in nanoseconds is " + totalTime);
          System.out.println("array sorted by Counting sort");
          break;
        case 2:
          Ada5 obj1 = new Ada5();
          // int max1 = maximumval(arr, n);
          obj1.radixsort(arr, n);
          System.out.println("cost of the Radix sort algorithm : " + cost);
          long totalTime1 = end_time - start_time;
          System.out.println("time in nanoseconds is " + totalTime1);
          System.out.println("array sorted by Radix sort");
          break;
        case 3:
          Ada5 obj2 = new Ada5();
          int max2 = maximumval(arr, n);
          obj2.bucketsort(arr, n, max2);
          System.out.println("cost of the Bucket sort algorithm : " + cost);
          long totalTime2 = end_time - start_time;
          System.out.println("time in nanoseconds is " + totalTime2);
          System.out.println("array sorted by bucket sort");
          break;
        default:
          break;
      }
      File f1 = new File("output.txt");
      FileWriter fWriter = new FileWriter(f1);
      BufferedWriter writer = new BufferedWriter(fWriter);
      for (int j = 0; j < n; j++) {
        writer.write(arr[j] + " ");
        writer.newLine();
      }
      writer.close();
      scan.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
