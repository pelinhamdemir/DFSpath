import java.sql.Array;
import java.util.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner((System.in));
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int NumOfMuseum = keyboard.nextInt();
        int RoadNum = keyboard.nextInt();
        int[][] weight = new int[NumOfMuseum+1][NumOfMuseum+1];
        Graph graph = new Graph(NumOfMuseum+1);
        for (int o = 1; o <=RoadNum; o++) {
            int p, e, roadWeight;
            p = keyboard.nextInt();
            e = keyboard.nextInt();
            roadWeight = keyboard.nextInt();
            graph.addEdge(p , e );

            weight[p][e] = roadWeight;
            weight[e][p] = roadWeight;


            linkedList.add(p);
            linkedList.add(e);

        }

        DepthFirstPaths dfsPaths = new DepthFirstPaths(graph,graph.getSmallestPathNum(graph,weight), weight);
        System.out.println(dfsPaths.total + "\t");
        for (int i = 0; i < dfsPaths.mainlist.size(); i++) {
            System.out.print(dfsPaths.mainlist.get(i) + " ");
        }

    }







}
