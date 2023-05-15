//       Friends Pairing Problem:
//        Given n friends, each one can remain single or can be paired up with some other
//        friend. Each friend can be paired only once. Find out the total number of ways in
//        which friends can remain single or can be paired up.


package CH09_RECURSION;

public class friends_pairing_problem {
    public static int pairFriends(int noOfFrnd){
        //base case
        if(noOfFrnd == 1 || noOfFrnd==2){
            return noOfFrnd;
        }
        //choices

        //single
        int fnm1 = pairFriends(noOfFrnd - 1);

        //pair
        int fnm2 = pairFriends(noOfFrnd - 2);
        int pairWays = (noOfFrnd - 1)* fnm2;

        //total no of ways
        int totalWays = fnm1 + pairWays;
        return totalWays;
    }

    public static void main(String[] args) {
        int noOfFrnd = 10;
        System.out.println("In " + pairFriends(noOfFrnd) + " ways ");
    }
}
