class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }

        int i=0;
        int j=1;
        int max_profit=0;

        while(j<prices.length){
            if(prices[i] >= prices[j]){
                i=j;
                j++;
            }else{
                max_profit = Math.max(max_profit, prices[j]-prices[i]);
                j++;
            }
        }
        return max_profit;
    }
}
