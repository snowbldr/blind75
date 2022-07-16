package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Problem30_LC121_BestTimeToBuySell {

    static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > maxProfit){
                maxProfit = prices[i]-min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        assertThat(maxProfit(new int[]{7,1,5,3,6,4})).isEqualTo(5);
    }
}
