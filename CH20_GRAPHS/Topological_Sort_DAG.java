package CH20_GRAPHS;
/* Topological Sorting
        Directed Acyclic Graph(DAG) is a directed graph with no cycles.
        Topological sorting is used only for DAGS (not for non-DAGs)
        It is a linear order of vertices such that every directed edge u v,
        the vertex u comes before v in the order. */

import  java.util.*;
public class Topological_Sort_DAG {  // TC :O( V+E )  && SC : ( V )-> because of extra space used by stack
    public static class Edge{
        int src,dest;

        public Edge(int src,int dest){
            this.src =src;
            this.dest =dest;
        }
    }

    public static void createGraph(ArrayList<Edge> []graph){
        for(int i =0;i<graph.length;i++)
        {
            graph[i] =new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topSort(ArrayList<Edge> []graph){
        boolean visit[] =new boolean[graph.length];
        Stack<Integer> st =new Stack<>();

        for(int i =0;i< graph.length;i++){
            if(!visit[i]){ //Modified DFS
                topSortUtil(graph,i,visit,st);
            }
        }
        System.out.println("The topological sorted DAG order is :");
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> []graph, int curr,boolean visit[],Stack<Integer> st){
        visit[curr] =true;

        for(int i = 0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                topSortUtil(graph,e.dest,visit,st);
            }
        }
        st.push(curr);
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
// 5 4 2 3 1 0