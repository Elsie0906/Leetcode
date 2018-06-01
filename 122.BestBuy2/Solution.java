/*
* time complexity: O(N)
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        boolean buying = false;
        
        for(int i=0; i<prices.length-1; i++){
            if(buying == false){
                if(prices[i] < prices[i+1]){
                    buying = true;
                    profit -= prices[i];
                }
            }
            else{
                if(prices[i] > prices[i+1]){
                    buying = false;
                    profit += prices[i];
                }
            }
        }
        
        // check last item
        
        if(buying == true){
            profit += prices[prices.length-1];
        }
        
        return profit;
    }
}