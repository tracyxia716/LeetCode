package linkedlist;


public class MyLinkedList {
    class Node<T> {
        T node;
        Node<T> next;
        Node<T> pre;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();


        list.addAtHead(1);
//        list.addAtTail(3);
        list.addAtIndex(1,2);
        System.out.println(list.get(1));
        System.out.println(list.get(0));
        System.out.println(list.get(2));


//        list.deleteAtIndex(1);
//        System.out.println(list.get(1));


//        System.out.println(list.get(104));
    }


    private Node<Integer> head;
    private Node<Integer> current;
    private Node<Integer> tail;

    private int length = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new Node<>();
        current = new Node<>();
        tail = new Node<>();

        current = head;

        current.next = tail;
        tail.pre = current;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= length || index < 0) {
            return -1;
        }
        current = head;
        current = current.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.node;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        current = head;
        Node<Integer> node = new Node<>();
        node.node = val;

        node.next = current.next;
        current.next = node;

        node.pre = current;
        node.next.pre = node;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        current = tail;
        Node<Integer> node = new Node<>();

        node.node = val;

        node.next = current;
        node.pre = current.pre;

        node.pre.next = node;
        node.next.pre = node;

        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length || index < 0) {
            return;
        }
        current = head;
        current = current.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<Integer> node = new Node<>();
        node.node = val;

        node.pre = current.pre;
        current.pre.next = node;

        node.next = current;
        current.pre = node;
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) {
            return;
        }
        current = head;
        current = current.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next.pre = current.pre;
        current.pre.next = current.next;

        current.next = null;
        current.pre = null;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */