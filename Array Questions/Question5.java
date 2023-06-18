// Question 5:
// Shuffle the Array
// https://leetcode.com/problems/shuffle-the-array/

public class Question5 {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int counter = 0;
        for(int i = 0; i < n; i++) {
            arr[counter] = nums[i];
            counter++;
            arr[counter] = nums[i + n];
            counter++;
        }
        return arr;
    }
}