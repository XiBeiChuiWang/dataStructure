package _21_30_;

import printer.ListNode;

public class _剑指_Offer_24_反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode prev = null;

        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
