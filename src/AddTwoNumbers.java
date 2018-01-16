import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xianeng on 2018/1/16.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
//        int a = System
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        System.out.println(a);
//        System.out.println(11/10);

        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
//        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int last = 0;

        ListNode returnListNode = new ListNode(-1);
        ListNode tempListNode = returnListNode;


        while (l1 != null || l2 != null) {
            if(tempListNode.val != -1) {
                tempListNode.next = new ListNode(-1);
                tempListNode = tempListNode.next;
            }

            int numberone = 0;
            int numbertwo = 0;
            if(l1 != null) {
                numberone = l1.val;
            }
            if(l2 != null) {
                numbertwo = l2.val;
            }

            if(tempListNode.val == -1) {
                tempListNode.val = (numberone + numbertwo + last) % 10;
                last = (numberone + numbertwo + last) / 10;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

        }

        if(last != 0) {
            System.out.println("sdfsd");
            tempListNode.next = new ListNode(last);
        }

        return returnListNode;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
