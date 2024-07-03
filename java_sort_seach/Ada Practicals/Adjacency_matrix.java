import java.util.Scanner;
public class Adjacency_matrix {
  private final int vertex;
  private int[][] matrix;
  public Adjacency_matrix(int v) {
    vertex = v;
    matrix = new int[vertex + 1][vertex + 1];
  }
  public void makeEdge(int start, int end, int edge) {
    try {
      matrix[start][end] = edge;
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertex does not exists");
    }
  }
  public int getEdge(int start, int end) {
    try {
      return matrix[start][end];
    } catch (ArrayIndexOutOfBoundsException index) {
      System.out.println("The vertex does not exists");
    }
    return -1;
  }
  public static void main(String args[]) {
    int v, e, count = 1, start = 0, end = 0;
    Scanner sc = new Scanner(System.in);
    Adjacency_matrix graph;
    try {
      System.out.println("Enter the number of vertex: ");
      v = sc.nextInt();
      System.out.println("Enter the number of edges: ");
      e = sc.nextInt();
      graph = new Adjacency_matrix(v);
      System.out.println("Enter the edges: (start) (end)");
      while (count <= e) {
        start = sc.nextInt();
        end = sc.nextInt();

        graph.makeEdge(start, end, 1);
        count++;
      }
      System.out.println("The adjacency matrix for the  graph: ");
      System.out.print("  ");
      for (int i = 1; i <= v; i++) System.out.print(i + " ");
      System.out.println();
      for (int i = 1; i <= v; i++) {
        System.out.print(i + " ");
        for (int j = 1; j <= v; j++) System.out.print(
          graph.getEdge(i, j) + " "
        );
        System.out.println();
      }
    } catch (Exception E) {
      System.out.println("Somthing went wrong");
    }
    sc.close();
  }
}
