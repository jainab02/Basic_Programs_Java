import java.util.*;

public class Mergesort {
    public void divide(int arr[], int left, int right) {
        int mid;
        if (left<right) {
            
            mid = (left+right)/2;
            divide(arr, left, mid);
            divide(arr, mid+1, right);//??
            conquer(arr, left, right, mid);
        }
        
    }
    public void conquer(int arr[], int left, int right, int mid) {
        int newarr[] = new int[500];
        int n1=left;
        int n2=mid+1;
        int x=left;
        while (n1<=mid && n2<=right) {
            if (arr[n1]<arr[n2]) {
                newarr[x]=arr[n1];
                n1++;
                x++;
            }
            else{
                newarr[x]=arr[n2];
                n2++;
                x++;
            }
        }
        while (n1<=mid) {
            newarr[x]=arr[n1];
            x++;
            n1++;
        }
        while (n2<=mid) {
            newarr[x]=arr[n2];
            x++;
            n2++;
        }
        for (int i=left; i <x; i++) {
            arr[i]=newarr[i];
            
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("enter the random no you want to generate : ");
        n=scan.nextInt();
        int[] arr = new int[100000];
        Random r = new Random();
        for(int i=0;i<n;i++){
            arr[i] = r.nextInt(100);
        }
        System.out.print("Entries of array A are : ");
        for(int i = 0; i<n;i=i+1)
        {
            System.out.print(arr[i] +", ");
        }
        System.out.println();
        // int arr[];
        // System.out.println("Given array");
        // System.out.println(arr);
        Mergesort obj = new Mergesort();
        obj.divide(arr, 0, n-1);
        System.out.println("sorted array is ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" , ");

        }
        scan.close();

    }
}

