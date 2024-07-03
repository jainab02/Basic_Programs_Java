import java.util.Scanner;

public class table {
    public static void main(String[] args) {
        // int n=5;
        Scanner s= new Scanner(System.in);
        System.out.println("enter value of n:");
        int n = s.nextInt();
        System.out.println("enter value of n1:");
        int n1 = s.nextInt();
        // for(int i=1;i<=10;i++){
        //     System.out.println(n+" * "+i+" = "+n*i);
        // }
        System.out.println("ADDITION IS "+(n1+n));
        s.close();
    }
}
