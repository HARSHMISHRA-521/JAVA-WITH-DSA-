package CH20_GRAPHS;
import java.util.*;
/*
               5
          0 ---------  1
                     /  \
                  3 /    \ 1
                   /  1   \      2
                  3 ------ 2 --------- 4
 */

public class Graph_Creation {
    public static class Edge{
        int source,dest,weight;

        public Edge(int s,int d,int w){
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void main(String[] args) {
        int V = 5; //no of vertex
        ArrayList<Edge> []graph = new ArrayList[V]; // null ,i.e only array is created but nothing is defined in it

        for(int i =0;i<V;i++){
            graph[i] = new ArrayList<>();              // here, null (is converted into )  --> Empty ArrayList
        }

        //0 vertex
        graph[0].add(new Edge(0,1,5));

        //1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // 2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,4));

        //3 vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        //4 vertex
        graph[4].add(new Edge(4,2,2));

        // 2's neighbours
        System.out.println("The neighbours of vertex 2 are: ");
        for(int i =0;i<graph[2].size();i++){
            Edge e = graph[2].get(i); //src,dest,wt
            System.out.println(e.dest);
        }
    }  // This all happens in almost constant time
}
/*The neighbours of vertex 2 are:
1
3
4
*/
