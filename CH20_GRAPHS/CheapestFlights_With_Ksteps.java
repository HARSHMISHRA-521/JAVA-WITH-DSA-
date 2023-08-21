package CH20_GRAPHS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Cheapest Flights within K Stops
There are n cities connected by some number of flights. You are given an array flights where
flights[il : [from, to, price] indicates that there is a flight.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
If there is no such route, return -1.
all values are positive

flights [ [0,1,100],[1,2,100],[0,2,500]]
src 0, dst= 2, k: 1
ans = 200
 */
public class CheapestFlights_With_Ksteps {
    public static class Edge{
        int src,dest,wt;

        public Edge(int src,int dest,int wt){
            this.src =src;
            this.dest =dest;
            this.wt =wt;
        }
    }
    public static class Info{
        int vert,cost,stop;
        public Info(int vert,int cost,int stop){
            this.vert =vert;
            this.cost =cost;
            this.stop =stop;
        }
    }

    public static void  createGraph(int[][]flight, ArrayList<Edge>[]graph){
        for(int  i= 0;i< graph.length;i++){
            graph[i] =new ArrayList<>();
        }

        for(int i =0;i<flight.length;i++){
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }

    public static int cheapestFlight(int n,int [][]flight,int src,int dest,int k){
        ArrayList<Edge> graph [] = new ArrayList[n];
        createGraph(flight,graph);

        int dist[] =new int[n];
        for(int i =0;i< n;i++){
            if(i!=src){
                dist[i]= Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr =q.remove();
            if(curr.stop>k){
                break;
            }

            for(int i =0;i<graph[curr.vert].size();i++){
                Edge e = graph[curr.vert].get(i);
                int u = e.src;
                int v =e.dest;
                int wt =e.wt;

                if(curr.cost+wt < dist[v] && curr.stop<=k){
                    dist[v] = curr.cost+wt;
                    q.add(new Info(v,dist[v], curr.stop+1));
                }
            }
        }

        //dist [dest]
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        /*
                                 0
                              /   / \
                         100/       \ 100
                          \/ 100     \
                          1---------> 2
                          \           /
                       600 \        / 200
                           \ /    \/
                               3
         */
        int n =4;
        int flight[][] ={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src =0,dest =3,k=1;
        System.out.println(cheapestFlight(n,flight,src,dest,k));
    }
}
//700