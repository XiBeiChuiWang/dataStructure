package _2020_2._22;

import tool.ListNode;

public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

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
