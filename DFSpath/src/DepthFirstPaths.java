import java.util.*;
import java.util.Queue;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    public List<Integer> mainlist;

    public DepthFirstPaths(Graph G, int s, int[][] weight) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;

        mainlist= dfs(G,s,weight);

    }


    int k = Integer.MAX_VALUE;
    int total=0;
    List<Integer> list2= new LinkedList<>();
    List<Integer> path= new LinkedList<>();
    List<Integer> path2= new LinkedList<>();
    private List<Integer> dfs(Graph g, int v, int[][] weight) {
        List<Integer> list = new LinkedList<>();

        int a = 0;
        marked[v] = true;
        list2.add(v);

        for (int w : g.adj(v)) {
            list.add(w);
        }

        for (int i = 0; i < list.size(); i++) {

            a = list.get(i);
            int num = weight[v][a];


            if(marked[a]&&list.size()>1)
                continue;;
            boolean check= true;
            for(int k=1;k<marked.length;k++){
                if(!marked[k])
                    check=false;
            }
            if(check== true){
                return list2;
            }

            if (!marked[a]) {

                total = total + num;
                //   list2.add(v);
                dfs(g, a, weight);
                edgeTo[a] = v;

            }
            else {

                k = weight[v][a];
                list2.add(a);
                //   if (list2.size() != marked.length)
                total = total + k;

            }

        }

        return list2;

    }
    public void Print(List<Integer> list){
        System.out.println(total + "\t"); // Print the total weight
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " "); // Print the path
        }


    }
}