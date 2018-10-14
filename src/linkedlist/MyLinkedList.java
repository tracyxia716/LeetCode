package linkedlist;

class Node<T> {
    T node;
    Node<T> next;
    Node<T> pre;
}

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

//        list.addAtIndex(100, 30);
//        System.out.println(list.get(2));

        list.deleteAtIndex(5);

//        System.out.println(list.get(3));
        System.out.println(list.get(4));

        System.out.println(list.get(5));
//        System.out.println(list.get(101));

//        System.out.println(list.get(99));

//        System.out.println(list.get(2));
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
        for (int i = 0; i < 100; i++) {
            Node<Integer> node = new Node();
            current.next = node;
            node.pre = current;
            node.node = i + 1;
            current = node;
            length++;
        }

        current.next = tail;
        tail.pre = current;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > length) {
            return -1;
        }
        current = head;
        current = current.next;
        for (int i = 0; i < index - 1; i++) {
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
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        current = tail;
        Node<Integer> node = new Node<>();
        node.node = val;
        //指向尾节点的前一个
        node.pre = current.pre;
        //尾节点的前一个节点的next节点指向新节点
        node.pre.next = node;
        //尾节点的pre节点指向新节点
        current.pre = node;
        //新节点的next节点指向尾节点
        node.next = current;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<Integer> node = new Node<>();
        node.node = val;

        node.pre = current.pre;
        current.pre.next = node;

        node.next = current;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > length) {
            return;
        }
        current = head;
        current = current.next;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next.pre = current.pre;
        current.pre.next = current.next;

        current.next = null;
        current.pre = null;

//        System.out.println(current);
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