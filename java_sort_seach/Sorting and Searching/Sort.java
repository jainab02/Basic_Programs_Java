
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Sort{
    public  void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {  
            int key = arr[i];  
            int j = i-1;  
            while ( (j >=0) && ( arr [j] > key ) ) {  
                arr [j+1] = arr [j];  
                j--;  
            }  
            arr[j+1] = key; 
        } 
         //printing array
    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i] + "\n") ;
    }
}
public  void selectionSort(int arr[]){
    for (int i = 0; i < arr.length - 1; i++)  
    {  
        int key = i;  
        for (int j = i + 1; j < arr.length; j++){  
            if (arr[j] < arr[key]){  
                key = j;//searching for lowest index  
            }  
        }  
        //swap with smallest one
        int smallerNumber = arr[key];   
        arr[key] = arr[i];  
        arr[i] = smallerNumber;  
    } 
     //printing array
for(int i=0;i<arr.length;i++){
    System.out.println(arr[i] + "\n") ;
}

}
public  void bubbleSort(int arr[]){
    for(int i=0;i<arr.length - 1;i++){
        for(int j=0;j<arr.length-i-1;j++){
            if (arr[j]>arr[j+1]) {
                int temp;
                temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]= temp;
            }
        }
    }
    //printing array
for(int i=0;i<arr.length;i++){
    System.out.println(arr[i] + "\n") ;
}
}
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
    int n;
    System.out.println("Enter the random no you want to sort : ");
    n = scan.nextInt();
    int[] arr= new  int[n];
    PrintWriter pwt = new PrintWriter(new File("input.txt"));
    Random r = new Random();
    for (int i = 0; i < n; i++) {
       pwt.println(r.nextInt(10000) + 1);
    }
    pwt.close();
    scan.close(); 
    // int arr[] = new int[n];
    Scanner s = new Scanner(new File("input.txt"));
    String str[] = s.nextLine().split(",");
    for (int i = 0; i < str.length; i++) {
      arr[i] = Integer.parseInt(str[i]);
    }
        System.out.println("Enter the name of sorting \n");
        System.out.println("1.Bubble sort \n");
        System.out.println("2.Selection Sort");
        System.out.println("3.Insertion Sort");
        int x = scan.nextInt();
        switch (x) {
            case 1:
                Sort ob = new Sort();
                ob.bubbleSort(arr);
                System.out.println("array sorted by bubble sort");
                break;
            case 2:
                Sort ob1 = new Sort();
                ob1.selectionSort(arr);
                System.out.println("array sorted by selection sort");
            case 3:
                Sort ob2 = new Sort();
                ob2.insertionSort(arr);
                System.out.println("array sorted by insertion sort");
            default:
                break;
        }
        PrintWriter pw2 = new PrintWriter(new File("Output.txt"));
        for (int i = 0; i < 100; i++) {
            pw2.println(arr[i] + " ");
        }
        pw2.close();
        s.close();

    }
}
// package java;

// class InsertionSort {
//     public  void insertionSort(int arr[]){
//         for (int i = 1; i < arr.length; i++) {  
//             int key = arr[i];  
//             int j = i-1;  
//             while ( (j >=0) && ( arr [j] > key ) ) {  
//                 arr [j+1] = arr [j];  
//                 j--;  
//             }  
//             arr[j+1] = key; 
//         } 
//          //printing array
//     for(int i=0;i<arr.length;i++){
//         System.out.println(arr[i] + "\n") ;
//     }

//     }
    
// }

// package java;

// class SelectionSort {
//     public  void selectionSort(int arr[]){
//         for (int i = 0; i < arr.length - 1; i++)  
//         {  
//             int key = i;  
//             for (int j = i + 1; j < arr.length; j++){  
//                 if (arr[j] < arr[key]){  
//                     key = j;//searching for lowest index  
//                 }  
//             }  
//             //swap with smallest one
//             int smallerNumber = arr[key];   
//             arr[key] = arr[i];  
//             arr[i] = smallerNumber;  
//         } 
//          //printing array
//     for(int i=0;i<arr.length;i++){
//         System.out.println(arr[i] + "\n") ;
//     }

//     }
    
// }
// package java;

// class BubbleSort {
//     public  void bubbleSort(int arr[]){
//         for(int i=0;i<arr.length - 1;i++){
//             for(int j=0;j<arr.length-i;j++){
//                 if (arr[j]>arr[j+1]) {
//                     int temp;
//                     temp = arr[j];
//                     arr[j]=arr[j+1];
//                     arr[j+1]= temp;
//                 }
//             }
//         }
//         //printing array
//     for(int i=0;i<arr.length;i++){
//         System.out.println(arr[i] + "\n") ;
//     }
//     }

// }
