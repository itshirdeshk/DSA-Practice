// Question 8:
// Remove All Adjacent Duplicates In String
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

import java.util.Stack;

public class Question8 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbba"));    
    }

    public static String removeDuplicates(String s) {
        String str = "";
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(ch);
            } else {
                if (ch == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        // For more runtime optimization, do this question without using stack
        // For more memory optimization, use StringBuilder instead of String

        if (stack.empty()) {
            str = "";
        } else {
            while(!stack.empty()) {
                str = stack.pop() + str;
            }
        }
        return str;
    }
}
