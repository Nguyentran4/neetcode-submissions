class Solution {
    public int maxProfit(int[] prices) {
       int maxP = 0;
       int minPr = prices[0];

       for(int i = 0; i < prices.length; i++){
            maxP = Math.max(maxP, prices[i] - minPr);
            minPr = Math.min(minPr, prices[i]);
       } 

       return maxP;
    }
}
