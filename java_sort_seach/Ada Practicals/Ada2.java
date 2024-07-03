import java.io.*;
import java.util.*;
public class Ada2 {
  //declaring cost and time as global variables
  static long cost = 0;
  static long start_time, end_time;
  //divide method partitions the array the last node
  public void divide(int arr[], int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;
      //recursive call to partition the array
      divide(arr, left, mid);
      divide(arr, mid + 1, right);
      conquer(arr, left, mid, right);
    }
  }
  //to print cost at the end of the program
  public void print_cost(long cost, long start_time, long end_time) {
    System.out.println("cost of the merge sort algorithm : " + cost);
    long totalTime = end_time - start_time;
    System.out.println("time in nanoseconds is " + totalTime);
  }
  //conquer method combines the array and assemble it in sorted manner
  public void conquer(int arr[], int left, int mid, int right) {
    int newarr[] = new int[100000];
    int n1 = left; //left pointer
    int n2 = mid + 1; //right side  pointer
    int x = left; //new array  pointer
    start_time = System.nanoTime();
    while (n1 <= mid && n2 <= right) {
      cost++;
      if (arr[n1] < arr[n2]) {
        newarr[x] = arr[n1];
        n1++;
        x++;
        cost++;
      } else {
        newarr[x] = arr[n2];
        n2++;
        x++;
        cost++;
      }
    }
    while (n1 <= mid) {
      cost++;
      newarr[x] = arr[n1];
      x++;
      n1++;
    }
    while (n2 <= mid) {
      cost++;
      newarr[x] = arr[n2];
      x++;
      n2++;
    }
    for (int i = left; i < x; i++) {
      arr[i] = newarr[i];
    }
    end_time = System.nanoTime();
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
      File file = new File("mergeinput.txt");
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
      File f = new File("mergeinput.txt");
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
      Ada2 obj = new Ada2();
      obj.divide(arr, 0, n - 1);
      File f1 = new File("mergeoutput.txt");
      FileWriter fWriter = new FileWriter(f1);
      BufferedWriter writer = new BufferedWriter(fWriter);
      for (int j = 0; j < n; j++) {
        writer.write(arr[j] + " ");
        writer.newLine();
      }
      Ada2 obj1 = new Ada2();
      obj1.print_cost(cost, start_time, end_time);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
