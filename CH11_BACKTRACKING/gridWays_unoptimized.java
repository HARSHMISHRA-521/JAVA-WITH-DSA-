package CH11_BACKTRACKING;
//question: find the no of ways to reach from (0,0) to (n-1,m-1) in a nXm matrix
//         allowed moves:- right or down

public class gridWays_unoptimized { //O(2^(n+m))
    public static int gridWays(int i,int j,int n,int m){
        //base case
        if(i==n-1 && j==m-1){//cond for last cell
            return 1;
        }
        else if(i==n || j== m){ //cond for going out of bound
            return 0;
        }

        int w1= gridWays(i+1,j,n,m);
        int w2= gridWays(i,j+1,n,m);
        return w1+w2;
    }

    public static void main(String[] args) {
        System.out.print("No of ways are :  ");
        System.out.print(gridWays(0,0,3,4));
    }
}
