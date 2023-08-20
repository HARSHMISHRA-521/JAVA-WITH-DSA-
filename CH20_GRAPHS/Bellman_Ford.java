package CH20_GRAPHS;
//O(V * E)
import java.util.*;
public class Bellman_Ford {
    public static class Edge{
        int src,dist,wt;
        public Edge(int src,int dist,int wt){
            this.src =src;
            this.dist =dist;
            this.wt =wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge> graph , int src,int V){
        int dist[]= new int[V];
        //initialization
        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //O(V * E)
        for(int i =0;i< V-1;i++){
            for(int j =0;j<graph.size();j++){
                //Edges - O(E)
                Edge e = graph.get(j);
                int u = e.src;
                int v =e.dist;
                int wt = e.wt;

                //relaxation
                if(dist[u]!= Integer.MAX_VALUE && dist[u] +wt < dist[v]){
                    dist[v] = dist[u] +wt;
                }
            }
        }

        //print
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V= 5;
        ArrayList<Edge>graph = new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph,0,V);
    }
}
// 0 2 -2 0 4