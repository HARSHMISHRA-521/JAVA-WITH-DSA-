package CH20_GRAPHS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {   // TC : O( V + E ) ,i.e linear time complexity

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

    public static void bfs(ArrayList<Edge> [] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[]  = new boolean[graph.length];

        q.add(0); // source = 0

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visit[curr]){ // visit

                //step 1 : print the curr
                System.out.print(curr+" ");

                //step 2 mark visited for curr
                visit[curr] =true;

                //step 3 add curr's neighbors in the queue
                for(int i = 0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
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
        System.out.println("The BFS traversal of the graph is : ");
        bfs(graph);
    }
}
//The BFS traversal of the graph is :  (it is similar to level order traversal in trees)
//0 1 2 3 4 5 6