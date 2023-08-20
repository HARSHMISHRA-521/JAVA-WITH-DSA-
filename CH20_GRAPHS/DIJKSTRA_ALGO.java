package CH20_GRAPHS;
                          //O(V + E log V)
import java.util.*;
public class DIJKSTRA_ALGO {
    public static class Edge{
        int src,dest,wt;
        public Edge(int s,int d,int wt){
            this.src =s;
            this.dest=d;
            this.wt =wt;
        }
    }
    static void createGraph(ArrayList<Edge> []graph){
        for(int i =0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    static class pair implements Comparable<pair>{
        int n;
        int path;

        public pair(int n,int path){
            this.n = n;
            this.path =path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path - p2.path; //path based sorting for my pairs
        }
    }

    static void dijkstra(ArrayList<Edge> graph[],int src){
        int dist[] =new int[graph.length];
        for(int i =0;i< graph.length;i++){
            if(i!=src){
                dist[i] =Integer.MAX_VALUE;//+infinity
            }
        }

        boolean visit[] =new boolean[graph.length];
        PriorityQueue<pair> pq  =new PriorityQueue<>();
        pq.add(new pair(src,0));
        //loop
        while(!pq.isEmpty()){
            pair curr =pq.remove();
            if(!visit[curr.n]){
                visit[curr.n] =true;

                //neighbours
                for(int i =0;i<graph[curr.n].size();i++){
                    Edge e =graph[curr.n].get(i);
                    int u =e.src;
                    int v =e.dest;
                    int wt =e.wt;

                    if(dist[u] + wt < dist[v]){
                        //update distance of src to v
                        dist[v] =dist[u]+wt;
                        pq.add(new pair(v,dist[v]));
                    }
                }
            }
        }
            //print all source to vertices shortest distance
            System.out.println("All source to vertices shortest distance are : ");
            for(int i =0;i<dist.length;i++){
                System.out.println(src + " --> " + i + " ==> " + dist[i] + " ");
            }

            System.out.println();
    }

    public static void main(String[] args) {
        int v =6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        int src =0;
        dijkstra(graph,src);
    }
}
//output:
//All source to vertices shortest distance are :
//0 --> 0 ==> 0
//0 --> 1 ==> 2
//0 --> 2 ==> 3
//0 --> 3 ==> 8
//0 --> 4 ==> 6
//0 --> 5 ==> 9