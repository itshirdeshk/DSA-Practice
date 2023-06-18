// Question 1:
// Build Array from Permutation
// https://leetcode.com/problems/build-array-from-permutation/

public class Question1 {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}