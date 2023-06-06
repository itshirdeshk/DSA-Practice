public class Main {
    public static void main(String[] args) {
        // Singly Linked List

        LL list = new LL();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        list.insertLast(99);

        list.insert(100, 3);

        list.display();

        list.deleteFirst();

        list.display();

        list.deleteLast();

        list.display();

        list.delete(3);

        list.display();

        list.insertRec(23, 2);

        list.display();

        // System.out.println(list.find(3));

        // Doubly Linked List

        // DLL list = new DLL();
        // list.insertFirst(5);
        // list.insertFirst(4);
        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(1);

        // list.display();
        
        // list.insertLast(6);
        
        // list.display();
        // System.out.println();
        
        // list.insert(3, 99);
        
        // list.display();
        // System.out.println();

        // Circular Linked List

        // CLL list = new CLL();
        // list.insert(1);
        // list.insert(2);
        // list.insert(3);
        // list.insert(4);
        // list.insert(5);
        // list.insert(6);

        // list.display();

        // list.delete(4);

        // list.display();

    }
}
