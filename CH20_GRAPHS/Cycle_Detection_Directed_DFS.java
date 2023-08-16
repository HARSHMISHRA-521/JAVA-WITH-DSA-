package CH20_GRAPHS;
import java.util.*;
public class Cycle_Detection_Directed_DFS {  //O(V+E)
    public static class Edge{
        int src,dest;
        public Edge(int src,int dest){
            this.src =src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }

    public static boolean isCycle(ArrayList<Edge> [] graph){
        boolean visit[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                if(isCycleUtil(graph,i,visit,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> [] graph,int curr,boolean []visit,boolean []stack){
        visit[curr] = true;
        stack[curr] =true;

        for(int  i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //if neighbour already exists in stack then cycle exists
            if(stack[e.dest]) {//cycle true
                return true;
            }
            //if neighbour is not visited then
            else if(!visit[e.dest] && isCycleUtil(graph,e.dest,visit,stack)){
                return true;
            }
            //if neighbour is visited and doesn't exists in stack than we need not require it ,i.e do nothing
        }
        stack[curr] =false;
        return false;
    }

    public static void main(String[] args) {
        /*
                  1 -----> 0 < ------ 3
                            \       /\
                             \     /
                             \/  /
                               2
         */
        int V = 4;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Do cycle exists in current graph ? ");
        System.out.println(isCycle(graph));
    }
}
//Do cycle exists in current graph ?
//true