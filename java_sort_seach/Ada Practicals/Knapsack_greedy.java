import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack_greedy {
  static class Item {
    int weight, value;
    double valueperweight;
    //constructor
    Item(int weight, int value) {
      this.weight = weight;
      this.value = value;
      valueperweight = (double) (value) / (weight);
    }
  }
  static double maxvalue(int weight[], int value[], int capacity) {
    int n = weight.length;
    List<Item> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Item(weight[i], value[i]));
    }
    //sorting
    Collections.sort(
      list,
      new Comparator<Item>() {
        public int compare(Item item1, Item item2) {
          if (item1.valueperweight > item2.valueperweight) {
            return -1;
          }
          return 1;
        }
      }
    );
    double ans = 0;
    for (int i = 0; i < n; i++) {
      int wt = list.get(i).weight;
      int val = list.get(i).value;
      double valuePerUnitWeight = list.get(i).valueperweight;
      if (capacity >= wt) {
        // Adding value of current item
        ans += val;

        // Reducing capacity by wt
        capacity -= wt;
      } else {
        // Adding the value
        ans += valuePerUnitWeight * capacity;

        // Now no space so
        //  terminate the loop.
        capacity = 0;
        break;
      }
    }
    // Returning the answer
    return ans;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n1;
    System.out.println("enter the no of items you want to enter:");
    n1 = s.nextInt();
    int[] weight = new int[n1];
    int[] value = new int[n1];
    for (int i = 0; i < n1; i++) {
      System.out.print("weight of " + (i + 1) + " item is ");
      weight[i] = s.nextInt();
    }
    for (int i = 0; i < n1; i++) {
      System.out.print("value of " + (i + 1) + " item is ");
      value[i] = s.nextInt();
    }
    int capacity;
    System.out.print("weight of knapsack is ");
    capacity = s.nextInt();
    System.out.println("for the weights and value :");
    for (int i = 0; i < n1; i++) {
      System.out.println(weight[i] + " " + value[i]);
    }
    System.out.println("total profit would be " + maxvalue(weight, value, capacity));
    s.close();
  }
}
