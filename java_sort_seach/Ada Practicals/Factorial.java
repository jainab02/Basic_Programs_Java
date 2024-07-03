import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

  static long cost = 0;
  
  public BigInteger fact(int n) {
    BigInteger fact = new BigInteger("1");
    for (int i = 1; i <= n; i++) {
      fact = fact.multiply(BigInteger.valueOf(i));
      cost++;
    }
    return fact;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n;
    System.out.println("enter the no :");
    n = s.nextInt();
    Factorial obj = new Factorial();
    BigInteger ans = obj.fact(n);
    System.out.println("factorial using recursion " + ans);
    System.out.println("cost in recursion " + cost);
    s.close();
  }
}
