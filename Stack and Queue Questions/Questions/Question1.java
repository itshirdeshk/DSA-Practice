// Question 1:
// Implement Queue using Stacks
// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class Question1 {
    public static void main(String[] args) {

    }

    class QueueUsingStackInsertEfficient {
        private Stack<Integer> first;
        private Stack<Integer> second;

        QueueUsingStackInsertEfficient() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void add(int item) {
            first.push(item);
        }

        public int remove() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }

            int removedItem = second.pop();

            while (!second.isEmpty()) {
                first.push(second.pop());
            }

            return removedItem;
        }

        public int peek() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }

            int item = second.peek();

            while (!second.isEmpty()) {
                first.push(second.pop());
            }

            return item;
        }

        public boolean isEmpty() {
            return first.isEmpty();
        }

    }

    class QueueUsingStackRemoveEfficient {
        private Stack<Integer> first;
        private Stack<Integer> second;

        QueueUsingStackRemoveEfficient() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void add(int item) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }

            first.push(item);

            while (!second.isEmpty()) {
                first.push(second.pop());
            }
        }

        public int remove() {

            return first.pop();
        }

        public int peek() {

            return first.peek();
        }

        public boolean isEmpty() {
            return first.isEmpty();
        }

    }
}