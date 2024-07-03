import java.util.*;
public class CountSort {
    static int maximumval(int arr[],int n){
        int max=arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i]>max) {
                max= arr[i];
            }
        }
        return max;
    }
    public void countsort(int arr[],int n,int max){
        // int max = maximumval(arr);
        int index[] = new int[max+1];
        int main[] = new int[n+1];

        //all the values becoming zeros
        for(int i=0;i<=max;i++){
            index[i]=0;
        }
        //count of the value in an array
        for(int i=0;i<n;i++){
            index[arr[i]]++;
        }
        for (int i = 1; i <=max; i++) {
            index[i] +=index[i-1];
        }
        for (int i = n-1; i < 0; i++) {
            
        }
        for (int i = n-1; i >=0; i--) {
            main[index[arr[i]]-1] = arr[i];
            index[arr[i]]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = main[i];
        }
        // int n1=0;  //count for index array
        // int n2=0; ///count for output array
        // while (n1<=max) {
        //     if(index[n1]>0){
        //         main[n2] = n1;
        //         index[n1]--;
        //         n2++;
        //     }
        //     else{
        //         n1++;
        //     }
        // }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
    
        System.out.println("enter the random no you want to generate ");
        n = s.nextInt();
        int arr[] = new int[n];
        // int len = arr.length;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
          arr[i] = r.nextInt(100);
        }
        s.close();
        // int arr[] ={3,1,0,8,4,7,33};
        // int n = arr.length;
        CountSort obj = new CountSort();
        int max = maximumval(arr,n);
        obj.countsort(arr,n,max);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
