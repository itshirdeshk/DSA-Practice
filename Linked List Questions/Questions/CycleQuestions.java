package Questions;

public class CycleQuestions {

    // Question 1:
    // Linked List Cycle
    // https://leetcode.com/problems/linked-list-cycle/

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public int cycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // Calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    // Question 2:
    // Linked List Cycle
    // https://leetcode.com/problems/linked-list-cycle-ii/

    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = cycleLength(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // Find the start node of the cycle

        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // Move both fast and slow until they meet at the start of the cycle
        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s;

    }

    public ListNode detectCycleOptimized(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                System.gc();
                return slow;
            }
        }
        System.gc();
        return null;
    }

    // Question 3:
    // Happy Number
    // https://leetcode.com/problems/happy-number/

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != slow);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }

    // Question 4:
    // Middle of the Linked List
    // https://leetcode.com/problems/middle-of-the-linked-list/

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Question 5:
    // Reverse Linked List
    // In place reversal of a Linked List
    // https://leetcode.com/problems/reverse-linked-list/

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;

    }

    // Question 6:
    // Reverse Linked List II
    // https://leetcode.com/problems/reverse-linked-list-ii/

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        // skip the first left - 1 nodes
        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // Reverse the list between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

    // Question 7:
    // Plaindrome Linked List
    // https://leetcode.com/problems/palindrome-linked-list

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverse(mid);

        ListNode reReveseHead = headSecond;

        // Now compare the both halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }

            head = head.next;
            headSecond = headSecond.next;
        }

        reverse(reReveseHead);
        return head == null || headSecond == null;
    }

    // Question 8:
    // Reorder List
    // https://leetcode.com/problems/reorder-list/

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);

        ListNode hf = head;
        ListNode hs = reverse(mid);

        // reorder the list

        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }

    // Question 8:
    // Reverse Nodes in k-Group
    // https://leetcode.com/problems/reverse-nodes-in-k-group/

    // This solution is incomplete
    // This solution also reversing the remaining end k elements but we don't have
    // to reverse it
    // So we have to modify the code accordingly

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (true) {

            ListNode last = prev;
            ListNode newEnd = current;

            // Reverse the list between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            if (current == null) {
                break;
            }
            prev = newEnd;
        }
        return head;
    }

    // Question 9:
    // Reverse alternate K nodes in a Singly Linked List
    // https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/

    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {

            ListNode last = prev;
            ListNode newEnd = current;

            // Reverse the list between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            // skip the k node
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }

        }
        return head;
    }

    // Question 10:
    // Rotate List
    // https://leetcode.com/problems/rotate-list/

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;

        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;

        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
