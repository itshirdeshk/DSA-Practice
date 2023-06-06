// Question 3:
// Largest Rectangle in Histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

public class Question3 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);

            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private int getMax(int[] arr, Stack<Integer> stack, int max, int i){
        int area;
        int popped = stack.pop();
        if(stack.isEmpty()) {
            area = arr[popped] * i;
        }
        else {
            area = arr[popped] * (i - 1 - stack.peek());
        }

        return Math.max(max, area);
    }
}