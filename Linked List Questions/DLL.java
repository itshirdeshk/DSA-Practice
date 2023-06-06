public class DLL {

    private Node head;

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.data + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Printing in reverse");
        while (last != null) {
            System.out.print(last.data + " -> ");
            last = last.prev;
        }
        System.out.println("START");

    }

    public void insertLast(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            temp.prev = null;
            temp.next = null;
            return;
        }

        Node node = head;
        Node last = null;

        while (node != null) {
            last = node;
            node = node.next;
        }

        last.next = temp;
        temp.next = null;
        temp.prev = last;
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

    public void insert(int after, int data) {
        Node p = find(after);

        if (p == null) {
            System.out.println("Doesn't Exist");
            return;
        }

        Node node = new Node(data);
        node.next = p.next;
        node.prev = p;
        // p.next.prev = node;
        p.next = node;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    private class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }
}
