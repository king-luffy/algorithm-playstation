package com.kingluffy.playstation;

/**
 * No.122
 */
public class Profits2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        int tmp = 0;
        for(int i=0;i<len-1;i++){
            tmp = prices[i+1]-prices[i];
            if(tmp>0){
                profit+=tmp;
            }
        }
        return profit;
    }
}
