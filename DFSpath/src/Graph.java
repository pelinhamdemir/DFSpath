import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class Graph
{
    private final int V;
    private Bag<Integer>[] adj;
    public Graph(int V)
    {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);


    }
    public int V(){
        return V;
    }

    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    public static <T> T getRandomValueFromQueue(LinkedList<T> list,Graph graph,int[][] weight) {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");


        }

        int size = list.size();
        int randomIndex = new Random().nextInt(size);
        Iterator<T> iterator = list.iterator();

        for (int i = 0; i < randomIndex; i++) {
            iterator.next();
        }


        return iterator.next();
    }

    public int getSmallestPathNum(Graph g,int[][] weight){
        int count=Integer.MAX_VALUE;
        int index = 0;
        for(int i=1;i<g.V();i++){
            DepthFirstPaths dfsPaths = new DepthFirstPaths(g,i , weight);
            if(dfsPaths.total<=count){
                count=dfsPaths.total;
                //  dfsPaths.total=count;
                index=i;
            }
        }
        return index;


    }


}