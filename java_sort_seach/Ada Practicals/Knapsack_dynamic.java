import java.util.Scanner;
public class Knapsack_dynamic {
  //it would find the maximum value of two cases
  //i.e 1)inclusion of the weight 2) exclusion of the weight
  public static int maxvalue(int a, int b) {
    return (a > b) ? a : b;
  }
  //it will return the max profit earned by putting the weight into knapsack
  public static int knapsack(int wknapsack, int w[], int value[], int n) {
    int j, wt;
    int dp[][] = new int[n + 1][wknapsack + 1];
    //table for calculating the value
    for (j = 0; j <= n; j++) {
      for (wt = 0; wt <= wknapsack; wt++) {
        //initial condition if the sack is 0 or value length is 0
        if (j == 0 || wt == 0) {
          dp[j][wt] = 0;
        }
        //else it would return the best of the two cases
        else if (w[j - 1] <= wt) {
          dp[j][wt] =
            maxvalue(value[j - 1] + dp[j - 1][wt - w[j - 1]], dp[j - 1][wt]);
        }
        //if the current capacity of the sack does not allow object to inseert then it would be equal to previous one
        else {
          dp[j][wt] = dp[j - 1][wt];
        }
      }
    }
    return dp[j - 1][wknapsack];
  }
  //main method
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n1;
    System.out.println("enter the no of items you want to enter:");
    n1 = s.nextInt();
    int[] w = new int[n1];
    int[] value = new int[n1];
    for (int i = 0; i < n1; i++) {
      System.out.print("weight of " + (i + 1) + " item is ");
      w[i] = s.nextInt();
    }
    for (int i = 0; i < n1; i++) {
      System.out.print("value of " + (i + 1) + " item is ");
      value[i] = s.nextInt();
    }
    int wknapsack;
    System.out.print("weight of knapsack is ");
    wknapsack = s.nextInt();
    int n = value.length;
    System.out.println("for the weights and value :");
    for (int i = 0; i < n1; i++) {
      System.out.println(w[i] + " " + value[i]);
    }
    System.out.println("total profit would be " + knapsack(wknapsack, w, value, n));
    s.close();
  }
}
