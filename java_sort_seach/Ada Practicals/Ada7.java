import java.util.*;
import java.io.*;
public class Ada7 {
    static int maximumval(int arr[], int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
          if (arr[i] > max) {
            max = arr[i];
          }
        }
        return max;
      }
    
      
      public void bucketsort(int arr[], int n, int max) {
        int bucket[] = new int[max+1];
        for (int i = 0; i <=max; i++) {
          bucket[i] = 0;
        }
        for (int i = 0; i < n; i++) {
          bucket[arr[i]]++;
        }
        // for (int i = 0; i < n; i++) {
        //   insertionSort(arr, n);
        // }
        for (int i = 0, j = 0; i <= max; i++) {
          while (bucket[i] > 0) {
            arr[j++] = i;
            bucket[i]--;
          }
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
          File file = new File("bucketinput.txt");
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
          File f = new File("bucketinput.txt");
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
          int max = maximumval(arr,n);
          Ada7 obj = new Ada7();
          // BucketSort obj = new BucketSort();
          obj.bucketsort(arr, n, max);
          File f1 = new File("bucketoutput.txt");
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
