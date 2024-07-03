import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

// import javax.lang.model.element.Element;

public class Ada8 {

  static long cost = 0;

  //Linear search using recursion
  public int linearsearch(int arr[], int n, int key) {
    // cost++;
    if (n == 0) {
      cost++;
      return -1;
    } else if (arr[n - 1] == key) {
      cost++;
      return n - 1;
    } else {
      cost++;
      return linearsearch(arr, n - 1, key);
    }
  }

  //Binary Search
  public int binarysearch(int arr[], int key) {
    int left=0;
        int right=arr.length-1;
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(arr[mid]>key){
              cost++;
                right=mid-1;
            }
            else if(arr[mid]<key){
              cost++;
                left=mid+1;
            }
            else{
              cost++;
                return mid;
            }
        }
    return -1;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n;
    System.out.println("enter the random no you want to generate : ");
    n = s.nextInt();
    int n1 = 0;
    try {
      File file = new File("SearchInput.txt");
      FileWriter fileWriter = new FileWriter(file);
      BufferedWriter writer = new BufferedWriter(fileWriter);
      for (int i = 0; i < n; i++) {
        n1 = (int) (Math.random() * 1000 + 1);
        writer.write(n1 + "");
        writer.newLine();
      }
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      File f = new File("SearchInput.txt");
      FileReader fileReader = new FileReader(f);
      BufferedReader reader = new BufferedReader(fileReader);
      String x;
      int arr[] = new int[n];
      int i = 0;
      while ((x = reader.readLine()) != null) {
        arr[i] = Integer.parseInt(x);
        i++;
      }
      reader.close();
      System.out.println("enter the no you want to search");
      int key = s.nextInt();
      System.out.println(
        "Enter the no of search you want to perform from below: "
      );
      System.out.println("1.Linear Search");
      System.out.println("1.Binary Search");
      int x1 = s.nextInt();
      switch (x1) {
        case 1:
          Ada8 obj = new Ada8();
          int index = obj.linearsearch(arr, arr.length, key);
          if (index == -1) {
            System.out.println("element not found!");
          } else {
            index++;
            System.out.println("element found at " + index + " !");
          }
          System.out.println("cost of this algorithm  = " + cost);
          break;
        case 2:
          Ada8 obj1 = new Ada8();
          int index1 = obj1.binarysearch(arr, key);
          // index1++;
          if (index1 == -1) {
            System.out.println("element not found!");
          } else {
            index1++;
            System.out.println("element found at " + index1 + " !");
          }
          System.out.println("cost of this algorithm  = " + cost);
          break;
        default:
          break;
      }
      s.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
