// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    }


    //
//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        int cost = prices[0];
//        int profit = 0;
//        for (int i = 1; i < len; i++) {
//            cost = Math.min(cost, prices[i]);
//            profit = Math.max(profit, prices[i] - cost);
//        }
//        return profit;
//    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int begin = 0;
        int end = 1;
        int maxProfit = 0;
        while(end < len){
            if(prices[end] - prices[begin] > 0){
                maxProfit += prices[end] - prices[begin];
            }
            begin++;
            end++;
        }
        return maxProfit;
    }
}