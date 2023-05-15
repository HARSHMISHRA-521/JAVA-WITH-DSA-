public class Inverted_star {
    public static void main(String[] args) {
    for(int i = 5;i>0;i--){
        for(int j = 1;j<=i;j++){  //or else we could have done, j<=n-i+1 with i=1;i<=n;i++
            System.out.print("* ");
        }
        System.out.println();
    }
}
}
