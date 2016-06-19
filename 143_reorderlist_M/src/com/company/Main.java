package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {
    //Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    //reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
                return;

        ListNode slow = head;
        ListNode fast = head;

        // find midpoints
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }

        ListNode mid = slow.next;
        ListNode pre = null;
        ListNode tempmid = mid;
        // use stack to reverse second half link


        while(tempmid!= null) {
            ListNode next = tempmid.next;
            tempmid.next = pre;
            pre = tempmid;
            tempmid = next;
        }
        slow.next = null;

        // insert the second second half into first half
        while(head != null && pre != null) {
            ListNode next1 = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next1;
            head = next1;
        }

    }

    private static void test143(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        reorderList(l1);
        ListNode myl = l1;
        while(myl!= null) {
            System.out.println(myl.val);
            myl = myl.next;
        }


        reorderList(null);


    }
    public static void main(String[] args) {
	// write your code here
        test143();
    }
}
