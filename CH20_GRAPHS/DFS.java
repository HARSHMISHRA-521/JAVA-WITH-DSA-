package CH20_GRAPHS;
import java.util.*;

public class DFS {  // TC : O( V + E ) ,i.e linear time complexity
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src= src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        for(int i =0;i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }

    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean [] visit) {
        //visit
        System.out.print(curr + " ");
        visit[curr] = true;
        //check for the neighbours of curr
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visit[e.dest]) {           //if not visited
                dfs(graph, e.dest, visit);  // then visit
            }
        }
    }

    public static void main(String[] args) {
        /*
                     1 ---------- 3
                   /             |   \
                  0              |   5 ------ 6
                  \              |   /
                    2 ---------- 4
         */

        int V =7;
        ArrayList<Edge> graph[]  = new ArrayList[V];
        createGraph(graph);
        System.out.println("The DFS traversal of the graph is : ");
        dfs(graph,0,new boolean[V]);
    }
}
//The DFS traversal of the graph is :   ( it keeps going for the first neighbour )
//0 1 3 4 2 5 6
