package _21_30_;

import printer.ListNode;

public class _剑指_Offer_22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;

        ListNode head1 = head;
        int size = 0;
        while (head1 != null){
            size++;
            head1 = head1.next;
        }

        if (k > size) return null;
        head1 = head;
        for (int i = 0;i < size - k;i++){
            head1 = head1.next;
        }
        return head1;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1;i <= k;i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
