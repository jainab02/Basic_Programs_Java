import java.util.*;
public class chain_matrix {

    static int[][] result = new int[100][100];
 
    // Function for matrix chain multiplicationw
    static int MatrixChain(int[] p, int i, int j)
    {
      if (i == j) 
      {
        return 0;
      }
      if (result[i][j] != -1) 
      {
        return result[i][j];
      }
      result[i][j] = Integer.MAX_VALUE;
      for (int k = i; k < j; k++) 
      {
        result[i][j] = Math.min(
          result[i][j], MatrixChain(p, i, k)
          + MatrixChain(p, k + 1, j)
          + p[i - 1] * p[k] * p[j]);
      }
      return result[i][j];
    }
    static int MatrixChainOrder(int[] p, int n)
    {
      int i = 1, j = n - 1;
      return MatrixChain(p, i, j);
    }
    public static void main (String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the no of value you want to fill");
        int n1= s.nextInt();
        int[] arr = new int[n1];
      System.out.println("enter the value for array: ");
      for(int i=0;i<n1;i++){
        arr[i]= s.nextInt();
      }
      int n= arr.length;
   
      for (int[] row : result)
        Arrays.fill(row, -1);
   
      System.out.println("Min number of operations: " + MatrixChainOrder(arr, n));
      s.close();
    }
  }
