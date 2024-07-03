import java.io.*;
import java.util.*;
public class Edges {
	int vertices;
	Vector <Integer>[] adj;
  @SuppressWarnings("unchecked")
	Edges(int vertices)
	{
		this.vertices = vertices;
        this.adj = new Vector[vertices];
		for (int i = 0; i < vertices; i++)
		{
			adj[i] = new Vector<Integer> ();
		}
	}
	void addEdgeToGraph(int source, int destination)
	{
		adj[source].add(destination);
		adj[destination].add(source);
	}
	int countEdgesInGraph()
	{
		int sum = 0;
		for (int i = 0; i < vertices; i++)
		{
			sum += adj[i].size();
		}
		return sum / 2;
	}
    public static void main(String[] args) throws IOException
	{
		int vertices = 5;
        Edges edge = new Edges(vertices);
		edge.addEdgeToGraph(0, 2);
		edge.addEdgeToGraph(0, 3);
		edge.addEdgeToGraph(1, 0);
		edge.addEdgeToGraph(2, 1);
		edge.addEdgeToGraph(3, 4);
        System.out.println("edges are: ");
		System.out.println(edge.countEdgesInGraph());
	}
}

