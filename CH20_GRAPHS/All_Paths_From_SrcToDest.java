package CH20_GRAPHS;   //P(v ^ v)
import java.util.*;
public class All_Paths_From_SrcToDest {
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
        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        for(int i =0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPaths(graph,e.dest,dest,path+src);
        }
    }

    public static void main(String[] args) {
        /*
                            5                       4
                            |  \                 /  |
                            |    \             /    |
                            |       \       /       |
                            |       \/    \ /       |
                            |           0           |
                            |           |           |
                           \ /         \/           \ /
                            2 -------> 3 ------- >  4
         */
        int V = 6;
        ArrayList<Edge> graph[] =new ArrayList[V];
        createGraph(graph);
        System.out.println("Possible paths from source to dest are :");
        printAllPaths(graph,5,1,"");
    }
}
//Possible paths from source to dest are :
//5031
//5231