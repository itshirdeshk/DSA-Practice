public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;

    }

    public void insertLast(int val) {

        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // insert using recursion

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.data == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public int deleteFirst() {
        int val = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {

        if (size <= 1) {
            return deleteFirst();
        }
        int val = tail.data;
        Node node = get(size - 2);
        tail = node;
        tail.next = null;

        return val;

    }

    public int delete(int index) {

        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node node = get(index - 1);
        int val = node.next.data;

        node.next = node.next.next;

        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, LL.Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Questions

    // Question 1:
    // Remove Duplicates from a sorted Linked List
    public void removeDuplicates() {
        Node node = head;
        while (node.next != null) {
            if (node.data == node.next.data) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }

        }
        tail = node;
        tail.next = null;
    }

    // Question 2:
    // Merge two sorted Linked List
    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.data < s.data) {
                ans.insertLast(f.data);
                f = f.next;
            } else {
                ans.insertLast(s.data);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.data);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.data);
            s = s.next;
        }

        return ans;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.data < second.data) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        }
        bubbleSort(row - 1, 0);
    }

    // Reverse of the Linked List using Recursion
    public void reverse(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // Question 3:
    // Reverse Linked List
    // In place reversal of a Linked List
    // https://leetcode.com/problems/reverse-linked-list/

    public void reverse(){
        if(size < 2) {
            return;
        }

        Node prev = null;
        Node pres = head;
        Node next = pres.next;

        while(pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;

    }
    
    public static void main(String[] args) {

        // Question 1:
        // LL list = new LL();
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(2);
        // list.insertLast(2);
        // list.insertLast(2);
        // list.insertLast(3);
        // list.insertLast(3);

        // list.display();

        // list.removeDuplicates();

        // list.display();

        // Question 2:
        LL first = new LL();
        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(3);

        LL second = new LL();
        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(6);
        second.insertLast(14);

        LL ans = LL.merge(first, second);
        ans.display();

    }
}