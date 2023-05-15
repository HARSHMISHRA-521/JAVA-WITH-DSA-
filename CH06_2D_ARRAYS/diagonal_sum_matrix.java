public class diagonal_sum_matrix {
    public static int sumdig(int matrix[][]){
        int sum =0;//it can only be possible for n=m,i.e,nxn

        //the below code enot optimised O(n^2)
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                //primary dig
//                if(i==j){
//                    sum+=matrix[i][j];
//                }
//                                                 // this solves the overlapping problem
//                //secondary dig
//               else if(i+j==matrix.length-1){
//                    sum+=matrix[i][j];
//                }
//            }
//        }

        //or the optimised one with O(n)
        for(int i=0;i<matrix.length;i++){
            //pd
            sum+=matrix[i][i];
            //sd
            if(i!=matrix.length-i-1){//this condition is for the overlapping problem , as i+j =n-1 , therefor j =n-1-i
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int sum =sumdig(matrix);
        System.out.println("sum :" + sum);
    }
}
