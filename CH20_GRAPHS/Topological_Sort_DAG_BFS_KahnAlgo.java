package CH20_GRAPHS;
/* Topological Sorting
        Directed Acyclic Graph(DAG) is a directed graph with no cycles.
        Topological sorting is used only for DAGS (not for non-DAGs)
        It is a linear order of vertices such that every directed edge u v,
        the vertex u comes before v in the order.

 FACT : A DAG has at least one vertex with indegree 0 and one vertex with outdegree 0             */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort_DAG_BFS_KahnAlgo {
    public static class Edge{
        int src,dest;

        public Edge(int s,int d){
            this.src =s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void calcIndeg(ArrayList<Edge>[] graph,int indeg[]){
        //calculates the indegree
        for(int i=0;i< graph.length;i++){
            int vertex =i;
            for(int j =0;j<graph[vertex].size();j++){
                Edge e = graph[vertex].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calcIndeg(graph,indeg);
        Queue<Integer> q =new LinkedList<>();

        for(int i =0;i< indeg.length;i++){
            if(indeg[i] ==0 ){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr =q.remove();
            System.out.print(curr + " "); //topological sort print

            for(int i =0;i<graph[curr].size();i++){ //decrement its neighbour's indegree
                Edge e= graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] ==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
          /*
                            5                       4
                            |  \                 /  |
                            |    \             /    |
                            |       \       /       |
                            |       \/    \ /       |
                            |           0           |
                            |                       |
                           \ /                     \ /
                            2 -------> 3 ------- >  4
         */
        int V = 6;
        ArrayList<Edge> graph[] =new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
// The topological sorted DAG order is :
//4 5 0 2 3 1