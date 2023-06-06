// Question 10:
// Delete middle element of a stack
// https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/

import java.util.Stack;

public class Question10 {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // code here
        Stack<Integer> helper = new Stack<>();
        if (sizeOfStack % 2 != 0) {
            for (int i = 1; i < Math.ceil((sizeOfStack + 1) / 2); i++) {
                helper.push(s.pop());
            }

            s.pop();

            for (int i = 1; i < Math.ceil((sizeOfStack + 1) / 2); i++) {
                s.push(helper.pop());
            }
        } else {
            for (int i = 1; i <= Math.ceil((sizeOfStack + 1) / 2); i++) {
                helper.push(s.pop());
            }

            s.pop();

            for (int i = 1; i <= Math.ceil((sizeOfStack + 1) / 2); i++) {
                s.push(helper.pop());
            }
        }
    }
}