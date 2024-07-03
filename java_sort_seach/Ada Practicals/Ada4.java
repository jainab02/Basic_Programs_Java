import java.io.*;
import java.util.*;

public class Ada4 {

  static long cost;

  void Build_mx_heapify(int arr[], int n) {
    // int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      cost++;
      Max_Heapify(arr, n, i);
    }
  }

  void heapsort(int arr[], int n) {
    // int n = arr.length;
    Build_mx_heapify(arr, n);
    for (int i = n - 1; i > 0; i--) {
      cost++;
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      Max_Heapify(arr, i, 0);
    }
  }

  void Max_Heapify(int arr[], int n, int root) {
    int large = root; //largest is the root
    int left = 2 * root + 1; //left hand side node is 2i+1
    int right = 2 * root + 2; //right hand side node is 2i+2
    // int n = arr.length;
    //if left node is greater then large would be = left node
    if (left < n && arr[left] > arr[large]) {
      large = left;
      cost++;
    }
    //if right node is greater then large would be = right node
    if (right < n && arr[right] > arr[large]) {
      large = right;
      cost++;
    }

    // now largest node is either left one or right one so we need to swap it to root
    //..so the largest element is at root
    //if the largest node is root then there is no problem so it will continue to the rest of the tree
    if (large != root) {
      int temp = arr[root];
      arr[root] = arr[large];
      arr[large] = temp;
      Max_Heapify(arr, n, large); //for the rest of the sub tree
      cost++;
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
      File file = new File("heapinput.txt");
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
      File f = new File("heapinput.txt");
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
      Ada4 obj = new Ada4();
      obj.heapsort(arr, n);
      File f1 = new File("heapoutput.txt");
      FileWriter fWriter = new FileWriter(f1);
      BufferedWriter writer = new BufferedWriter(fWriter);
      for (int j = 0; j < n; j++) {
        writer.write(arr[j] + " ");
        writer.newLine();
      }
      System.out.println("cost  = " + cost);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
