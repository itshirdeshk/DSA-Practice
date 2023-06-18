// Question 2:
// Concatenation of Array
// https://leetcode.com/problems/concatenation-of-array/

public class Question2 {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            ans[i] = nums[i];
            ans[i + length] = nums[i];
        }
        return ans;
    }

    public int[] getConcatenationOptimized(int[] nums) {
        int[] ans = new int[nums.length * 2];
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            ans[i] = nums[i];
            ans[i + length] = nums[i];
        }
        System.gc();
        return ans;
    }
}
