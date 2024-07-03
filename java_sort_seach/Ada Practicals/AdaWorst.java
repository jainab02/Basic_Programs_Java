import java.io.*;
import java.util.*;

public class AdaWorst {

  static long start_time, end_time;
  static long cost = 0;

  public void print_cost(long cost, long start_time, long end_time) {
    System.out.println("cost of the merge sort algorithm : " + cost);
    long totalTime = end_time - start_time;
    System.out.println("time in nanoseconds is " + totalTime);
  }

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
  public void bucketsort(int arr[], int n, int max) {
    cost=0;
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
  public static void main(String[] args) throws ClassNotFoundException {
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("enter the random no you want to generate : ");
    n = scan.nextInt();
    // int n1 = 0;
    scan.close();
    //best case
    try {
      // File f1 = new File("input.txt");
      PrintWriter file3 = new PrintWriter("worst.txt");
      for (int i = n; i > 0; i--) {
        file3.println(i);
      }
      file3.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      cost = 0;
      File file1 = new File("worst.txt");
      FileReader filereader = new FileReader(file1);
      BufferedReader reader = new BufferedReader(filereader);
      String y;
      int arr[] = new int[n];
      int i = 0;
      while ((y = reader.readLine()) != null) {
        arr[i] = Integer.parseInt(y);
        i++;
      }
      System.out.println("For Worst Case: ");
      AdaWorst obj = new AdaWorst();
      int max = maximumval(arr, n);
      obj.bucketsort(arr, n, max);
      obj.print_cost(cost, start_time, end_time);
      System.out.println("Array is Sorted Using Bubble Sort check the file");
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
// public void selectionSort(int arr[], long cost) {
  //   //global variable for time
  //   long start_time, end_time;
  //   cost = 0;
  //   start_time = System.nanoTime();
  //   for (int i = 0; i < arr.length - 1; i++) {
    //     int key = i;
    //     for (int j = i + 1; j < arr.length; j++) {
      //       cost++;
      //       if (arr[j] < arr[key]) {
        //         key = j; //searching for lowest index
        //         cost++;
        //       }
        //     }
        //     //swap with smallest one
        //     int smallerNumber = arr[key];
        //     arr[key] = arr[i];
        //     arr[i] = smallerNumber;
        //     cost++;
        //   }
        //   end_time = System.nanoTime();
        //   long totalTime = end_time - start_time;
        //   System.out.println("cost of the algorithm using selection sort = " + cost);
        //   System.out.println("time in nanoseconds is " + totalTime);
        // }
        //   public void bubbleSort(int arr[], long cost) {
          //     start_time = System.nanoTime();
          //     for (int i = 0; i < arr.length - 1; i++) {
  //       for (int j = 0; j < arr.length - i - 1; j++) {
    //         cost++;
    //         if (arr[j] > arr[j + 1]) {
      //           int temp;
      //           temp = arr[j];
      //           arr[j] = arr[j + 1];
      //           arr[j + 1] = temp;
      //           cost++;
      //         }
      //       }
      //     }
      //     end_time = System.nanoTime();
      //     long totalTime = end_time - start_time;
      //     System.out.println("cost of the algorithm using bubble sort = " + cost);
      //     System.out.println("time in nanoseconds is " + totalTime);
      //   }
      // public void insertionSort(int arr[], long cost) {
        //   //global variable for time
        //   long start_time, end_time;
        //   cost = 0;
        //   start_time = System.nanoTime();
        //   for (int i = 1; i < arr.length; i++) {
//     int key = arr[i];
//     int j = i - 1;
//     cost++;
//     while ((j >= 0) && (arr[j] > key)) {
  //       arr[j + 1] = arr[j];
  //       j--;
  //       cost++;
  //     }
  //     arr[j + 1] = key;
  //   }
  //   end_time = System.nanoTime();
  //   long totalTime = end_time - start_time;
  //   System.out.println("cost of the algorithm using insertion sort = " + cost);
  //   System.out.println("time in nanoseconds is " + totalTime);
// }
// public void divide(int arr[], int left, int right)
// {
  //   if (left < right)
  //   {
    //     int mid = left + (right - left) / 2;
    //     //recursive call to partition the array
    //     divide(arr, left, mid);
    //     divide(arr, mid + 1, right);
    //     conquer(arr, left, mid, right);
    //   }
    // }
    // //conquer method combines the array and assemble it in sorted manner
    // public void conquer(int arr[], int left, int mid, int right)
    // {
//   int newarr[] = new int[100000];
//   int n1 = left; //left pointer
//   int n2 = mid + 1; //right side  pointer
//   int x = left; //new array  pointer
//   start_time = System.nanoTime();
//   while (n1 <= mid && n2 <= right)
//   {
  //     cost++;
  //     if (arr[n1] < arr[n2])
  //     {
    //       newarr[x] = arr[n1];
    //       n1++;
    //       x++;
    //       cost++;
    //     }
//     else
//     {
  //       newarr[x] = arr[n2];
  //       n2++;
  //       x++;
  //       cost++;
  //     }
  //   }
  //   while (n1 <= mid)
  //   {
    //     cost++;
    //     newarr[x] = arr[n1];
    //     x++;
    //     n1++;
    //   }
    //   while (n2 <= mid)
    //   {
      //     cost++;
      //     newarr[x] = arr[n2];
      //     x++;
  //     n2++;
  //   }
  //   for (int i = left; i < x; i++)
  //   {
    //     arr[i] = newarr[i];
    //   }
//   end_time = System.nanoTime();
// }
// public void countsort(int arr[], int n, int max) {
  //   cost = 0;
//   int index[] = new int[max + 1]; //frequency count of any no
//   int main[] = new int[n + 1]; //output array
//   start_time = System.nanoTime();
//   //all the values becoming zeros
//   for (int i = 0; i <= max; i++) {
  //     index[i] = 0;
  //   }
  //   //count of the value in an array
  //   for (int i = 0; i < n; i++) {
    //     index[arr[i]]++;
//   }
//   for (int i = 1; i <= max; i++) {
  //     cost++;
  //     index[i] += index[i - 1];
  //   }
  //   //accurate position of the element and place it there
  //   for (int i = n - 1; i >= 0; i--) {
    //     main[index[arr[i]] - 1] = arr[i];
    //     index[arr[i]]--;
    //     cost++;
    //   }
    //   for (int i = 0; i < n; i++) {
      //     arr[i] = main[i];
      //   }
      //   end_time = System.nanoTime();
      // }
      
      
      //  public static int partition(int[] arr, int left, int right)
      //   {
      //     int pivot = arr[right];
      //     int i = (left - 1);
      //     for (int j = left; j < right; j++)
      //     {
        //       cost++;
        //       if (arr[j] <= pivot)
        //       {
          //         i++;
          //         //swapping
          //         int temp = arr[i];
      //         arr[i] = arr[j];
      //         arr[j] = temp;
      //         cost++;
      //       }
      //     }
      //     // swapping with pivot to sort the other side
      //     int temp = arr[i + 1];
      //     arr[i + 1] = arr[right];
      //     arr[right] = temp;
      //     cost++;
      //     return (i + 1);
      //   }
      //   public static void quicksort(int[] arr, int left, int right)
      //   {
        //     if (left < right) {
          //       cost++;
          //       int pivotIndex = partition(arr, left, right);
          //       quicksort(arr, left, pivotIndex - 1);
      //       quicksort(arr, pivotIndex + 1, right);
      //     }
      //   }
          // public void countradix(int arr[], int n, int max) {
          //   cost =0;
          //   int index[] = new int[max + 1]; //frequency count of any no
          //   int main[] = new int[n + 1]; //output array
          //   start_time = System.nanoTime();
          //   //all the values becoming zeros
          //   for (int i = 0; i <= max; i++) {
          //     index[i] = 0;
          //   }
          //   //count of the value in an array
          //   for (int i = 0; i < n; i++) {
          //     index[arr[i]]++;
          //   }
          //   for (int i = 1; i <= max; i++) {
          //     index[i] += index[i - 1];
          //     cost++;
          //   }
          //   //accurate position of the element and place it there
          //   for (int i = n - 1; i >= 0; i--) {
          //     main[index[arr[i]] - 1] = arr[i];
          //     index[arr[i]]--;
          //     cost++;
          //   }
          //   for (int i = 0; i < n; i++) {
          //     arr[i] = main[i];
          //   }
          //   end_time = System.nanoTime();
          // }
          
          
          // // radix sort using count sort(stable sort)
          // public void radixsort(int arr[], int n) {
          //   cost = 0;
          //   int max = maximumval(arr, n);
          //   start_time = System.nanoTime();
          //   for (int i = 1; max / i > 0; i++) {
          //     // cost++;
          //     countradix(arr, n, max);
          //   }
          //   end_time = System.nanoTime();
          // }