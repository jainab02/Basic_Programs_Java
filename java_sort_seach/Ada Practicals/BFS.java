import java.util.*;    
public class BFS    
{    
    private int vertex;      
    private LinkedList<Integer> adj[]; 
    private Queue<Integer> que;             
  @SuppressWarnings("unchecked")
   BFS(int v)    
    {    
        vertex = v;    
        adj = new LinkedList[vertex];    
        for (int i=0; i<v; i++)    
        {    
            adj[i] = new LinkedList<>();    
        }    
        que = new LinkedList<Integer>();    
    }    
    void insertEdge(int v,int w)    
    {    
        adj[v].add(w);     
    }    
    void BFS(int n)    
    {    
        boolean nodes[] = new boolean[vertex];       
        int a = 0;    
        nodes[n]=true;                      
        que.add(n);     
        while (que.size() != 0)    
        {    
            n = que.poll();        
            System.out.print(n+" ");        
            for (int i = 0; i < adj[n].size(); i++)   
            {    
                a = adj[n].get(i);    
                if (!nodes[a])      
                {    
                    nodes[a] = true;    
                    que.add(a);    
                }    
            }      
        }    
    }    
    public static void main(String args[])    
    {    
       BFS graph = new BFS(10);    
        graph.insertEdge(0, 1);    
        graph.insertEdge(0, 2);    
        graph.insertEdge(0, 3);    
        graph.insertEdge(1, 2);    
        graph.insertEdge(2, 4);  
        graph.insertEdge(3, 5);       
        graph.insertEdge(3, 6);    
        graph.insertEdge(4, 7);    
        graph.insertEdge(4, 5);    
        graph.insertEdge(5, 2);    
        graph.insertEdge(6, 4);    
        graph.insertEdge(7, 3);  
        graph.insertEdge(7, 8);   
        System.out.println("Breadth First Traversal:");    
        graph.BFS(1);    
    }    
}    