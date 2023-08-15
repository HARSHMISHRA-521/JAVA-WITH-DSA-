package CH20_GRAPHS;

//Has Path ?
//        For given src & dest, tell if a path exists from src to dest
//        src = 0, dest = 5

import java.util.*;
public class Has_Path {   // TC : O( V + E ) ,i.e linear time complexity
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

    public static boolean hasPath(ArrayList<Edge>[] graph,int src , int dest,boolean [] visit){
        if(src == dest){
            return true;
        }
        //if not then
        visit[src] = true;

        //check for its neighbour that ,is there exists any unvisited neighbour which has a path to dest
        for(int i = 0;i< graph[src].size();i++){
            Edge e = graph[src].get(i);
            //e.dest = neighbour
            if(!visit[e.dest] && hasPath(graph,e.dest,dest,visit)){
                return true;
            }
        }
        return  false;
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
        System.out.println("The result of hasPath for  the src(0) and dest(5)  is : ");
        System.out.println(hasPath(graph,0,5,new boolean[V]));
        System.out.println("The result of hasPath for  the src(0) and dest(7)  is : ");
        System.out.println(hasPath(graph,0,7,new boolean[V]));
    }
}
//The result of hasPath for  the src(0) and dest(5)  is :
//true
//The result of hasPath for  the src(0) and dest(7)  is :
//false