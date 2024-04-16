/** 121. 
Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:       i j
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,2,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104 

*/


//solution one 
class Solution1 {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for(int i=0 ;i<prices.length ; i++){ // loop1 
            for( int j=i+1 ; j<prices.length ;j++){ // loop 2
                int temp = prices[j]  - prices[i];//sell value - buy value
                if(temp > maxprofit){ // max cheker
                   if(i<j){ // buy date should be greater than the sell date
                    maxprofit=temp; // update
                   }
                }

            }
        }
        return maxprofit;
    }
}

//solution2 
class Solution2 {
   public int maxProfit(int[] prices) {
        // stores the max profit 
        int maxprofit = 0,
        low = prices[0], //low price
        high = prices[0]; // high price
        // loop the arr
        for(int i=0 ;i<prices.length; i++){ // loop1 
            int val = prices[i];
            //if the val < low value ,change low = val
            if( val < low  ){
                low = val;
                //low value index < higher value index ,so change the value high = val , (Buy First (low) , Sell After (high))
                high =val;
            }
            //if the val > high value ,change high = val
            if(val>high){
                high =val;
            }
            //compare the max and update the value 
            maxprofit = maxprofit < high -low ? high -low : maxprofit;
        }
        return maxprofit;
    }
}

