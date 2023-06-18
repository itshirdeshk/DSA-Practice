// Question 3:
// Running Sum of 1d Array
// https://leetcode.com/problems/running-sum-of-1d-array/

public class Question3 {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] runningSum = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            runningSum[i] = sum;
        }

        // Using System.gc() helps you in getting more memory efficient code.
        // For getting more runtime efficient code, don't use System.gc().
        System.gc();
        return runningSum;
    }

    public int[] runningSumOptimized(int[] nums) {
        for(int i = 1 ; i < nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}