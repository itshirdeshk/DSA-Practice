// Question 9:
// Number of Recent Calls
// https://leetcode.com/problems/number-of-recent-calls/

import java.util.LinkedList;
import java.util.Queue;

public class Question9 {

    Queue<Integer> queue;

    public void RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        if (queue.isEmpty()) {
            queue.add(t);
            return 1;
        } else {
            if (t <= 3000) {
                queue.add(t);
            } else {
                int margin = t - 3000;
                while (queue.size() != 0 && queue.peek() < margin) {
                    queue.poll();
                }
                queue.add(t);
            }
            return queue.size();
        }
    }
}
