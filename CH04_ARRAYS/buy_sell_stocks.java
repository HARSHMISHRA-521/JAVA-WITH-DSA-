//       You are given an array prices where prices[il is the price of a given stock
//        on the ith day. You want to maximize your profit by choosing a single day to
//        buy one stock and choosing a different day in the future to sell that stock.
//        Return the maximum profit you can achieve from this transaction. If you
//        cannot achieve any profit, return 0.

public class buy_sell_stocks {
    public static int besttime(int prices[]){ //O(n)
        int buyingprice=Integer.MAX_VALUE;
        int maxprofit =0;
        int buydate=0;
        int selldate=0;

        for(int i=0;i<prices.length;i++){
            if(buyingprice<prices[i]){
                int profit= prices[i]-buyingprice;
                maxprofit = Math.max(maxprofit,profit);
                if(maxprofit == profit){
                     selldate = i+1;
                }
            }
            else{
                buyingprice=prices[i];
                 buydate=i+1;
            }
        }
        if(maxprofit!=0) {
            System.out.println("The best day to buy stock is on day " + buydate);
            System.out.println("The best day to sell stock is on day " + selldate);
        }
        return maxprofit;

    }

    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
//        int prices[]={8,7,6,5,4,3};
        int profit =besttime(prices);
        if(profit!=0) {
            System.out.println("The maximum profit will be  :");
            System.out.println(profit + " Rs");
        }
        else{
            System.out.println("There is loss and no scope of profit");
        }
    }
}
