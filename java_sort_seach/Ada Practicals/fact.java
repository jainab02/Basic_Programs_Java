import java.util.*;
public class fact {
  static long cost = 0;
  public ArrayList<Integer> factorial(int N) {
    ArrayList<Integer> res = new ArrayList<>();
    res.add(1);
    int k = 2;
    int c = 0;
    while (k <= N) {
      cost++;
      for (int i = res.size() - 1; i >= 0; i--) {
        cost++;
        int temp = res.get(i) * k + c;
        res.set(i, temp % 10);
        c = temp / 10;
      }
      while (c != 0) {
        cost++;
        res.add(0, c % 10);
        c /= 10;
      }
      k++;
    }
    return res;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("enter the no :");
    int N = s.nextInt();
    fact ob = new fact();
    ArrayList<Integer> ans = ob.factorial(N);
    System.out.println("Factorial using iterative:");
    for (Integer val : ans) System.out.print(val);
    System.out.println();
    System.out.println("cost is "+cost);
    s.close();
  }
}
