// Question 4:
// Richest Customer Wealth
// https://leetcode.com/problems/richest-customer-wealth/

public class Question4 {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        int wealthSum = 0;

        for (int i = 0; i < accounts.length; i++) {
            for(int j = 0; j < accounts[i].length; j++) {
                wealthSum += accounts[i][j];
            }
            if(wealthSum > wealth) {
                wealth = wealthSum;
            }
            wealthSum = 0;
        }
        return wealth;
    }
}
