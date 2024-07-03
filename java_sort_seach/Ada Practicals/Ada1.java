import java.io.*;
import java.util.*;

//class of Bubble sort
class BubbleSort {

  //global variable for time
  long start_time, end_time;

  public void bubbleSort(int arr[], long cost) {
    start_time = System.nanoTime();
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        cost++;
        if (arr[j] > arr[j + 1]) {
          int temp;
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          cost++;
        }
      }
    }
    end_time = System.nanoTime();
    long totalTime = end_time - start_time;
    System.out.println("cost of the algorithm using bubble sort = " + cost);
    System.out.println("time in nanoseconds is " + totalTime);
  }
}

//class for selection sort
class SelectionSort {

  public void selectionSort(int arr[], long cost) {
    //global variable for time
    long start_time, end_time;
    cost = 0;
    start_time = System.nanoTime();
    for (int i = 0; i < arr.length - 1; i++) {
      int key = i;
      for (int j = i + 1; j < arr.length; j++) {
        cost++;
        if (arr[j] < arr[key]) {
          key = j; //searching for lowest index
          cost++;
        }
      }
      //swap with smallest one
      int smallerNumber = arr[key];
      arr[key] = arr[i];
      arr[i] = smallerNumber;
      cost++;
    }
    end_time = System.nanoTime();
    long totalTime = end_time - start_time;
    System.out.println("cost of the algorithm using selection sort = " + cost);
    System.out.println("time in nanoseconds is " + totalTime);
  }
}

//class for insertion sort
class InsertionSort {

  public void insertionSort(int arr[], long cost) {
    //global variable for time
    long start_time, end_time;
    cost = 0;
    start_time = System.nanoTime();
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      cost++;
      while ((j >= 0) && (arr[j] > key)) {
        arr[j + 1] = arr[j];
        j--;
        cost++;
      }
      arr[j + 1] = key;
    }
    end_time = System.nanoTime();
    long totalTime = end_time - start_time;
    System.out.println("cost of the algorithm using insertion sort = " + cost);
    System.out.println("time in nanoseconds is " + totalTime);
  }
}

//main class
public class Ada1 {

  public static void main(String[] args) throws FileNotFoundException {
    //cost variable
    long cost = 0;
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("enter the random no you want to generate :");
    n = scan.nextInt();
    int n1 = 0;
    try {
      File file = new File("input.txt");
      FileWriter filewriter = new FileWriter(file);
      BufferedWriter writer = new BufferedWriter(filewriter);

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
      File file1 = new File("input.txt");
      FileReader filereader = new FileReader(file1);
      BufferedReader reader = new BufferedReader(filereader);
      String y;
      int arr[] = new int[n];
      int i = 0;
      while ((y = reader.readLine()) != null) {
        arr[i] = Integer.parseInt(y);
        i++;
      }
      reader.close();
      System.out.println("Enter the name of sorting \n");
      System.out.println("1.Bubble sort \n");
      System.out.println("2.Selection Sort");
      System.out.println("3.Insertion Sort");
      int x1 = scan.nextInt();
      switch (x1) {
        case 1:
          BubbleSort ob = new BubbleSort();
          ob.bubbleSort(arr, cost);
          System.out.println("array sorted by bubble sort");
          break;
        case 2:
          SelectionSort ob1 = new SelectionSort();
          ob1.selectionSort(arr, cost);
          System.out.println("array sorted by selection sort");
          break;
        case 3:
          InsertionSort ob2 = new InsertionSort();
          ob2.insertionSort(arr, cost);
          System.out.println("array sorted by insertion sort");
          break;
        default:
          break;
      }
      File file2 = new File("output.txt");
      FileWriter filewriter2 = new FileWriter(file2);
      BufferedWriter writer = new BufferedWriter(filewriter2);
      for (int j = 0; j < n; j++) {
        writer.write(arr[j] + "");
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    scan.close();
  }
}
