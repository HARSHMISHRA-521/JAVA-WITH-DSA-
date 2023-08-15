package CH20_GRAPHS;

//Bipartite Graph
//        A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V such that every edge
//        (u, v) either connects a vertex from U to V or a vertex from V to U. In other words, for every edge (u, v), either u
//        belongs to U and v to V, or u belongs to V and v to U. We can also say that there is no edge that connects vertices of
//        same set.

//tc: O(V+E)  && sc = O(V+V)=O(V) ,because of extra space used by queue and color array

import java.lang.reflect.Array;
import java.util.*;
public class Bipartite_Graph {
    public static class Edge{
        int src,dest;
        Edge(int src,int dest){
            this.src= src;
            this.dest =dest;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        for(int i = 0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
    }

    public static boolean isBipartite(ArrayList<Edge> []graph){
        //array for storing color of vertex
        int color[]  = new int[graph.length];
        //initialize them with -1(i.e,no color)
        for(int i =0;i<color.length;i++){
            color[i]= -1; // no color
        }

        Queue<Integer> q= new LinkedList<>();

        //For disjoint component case of graph
        for(int i = 0;i< graph.length;i++){

            if(color[i] == -1){ //BFS
                q.add(i);
                color[i] = 0;//yellow (say)

                while(!q.isEmpty()){
                    int curr =q.remove();
                    //Now check for its neighbours
                    for(int j = 0;j< graph[curr].size();j++){
                        Edge e = graph[curr].get(j); //e.dest
                        //case 1: if the neighbour is not colored
                        if(color[e.dest] == -1){
                            int nextCol = color[curr] == 0 ? 1:0;
                            color[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        //case 2 : if neighbour's color is same
                        else if(color[e.dest] == color[curr]){
                            return false; // Not Bipartite
                        }
                        //case 3: if color of neighbour is different ,then do nothing ,it's in safe case
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
                                0 --------- 2
                               /           /
                             /           /
                            1           4
                             \         /
                              \      /
                               \   /
                                 3
         */
        int V =5;
        ArrayList<Edge> []graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Is graph Bipartite : ");
        System.out.println(isBipartite(graph));
    }
}
///Is graph Bipartite :
//false