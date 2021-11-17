package 每日一题._3_;

import tool.ListNode;

public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int count = 0;

        ListNode head1 = head;
        while (head1 != null){
            head1 = head1.next;
            count++;
        }
        k %= count;

        head1 = head;
        for (int i = 0;i < count - k - 1;i++){
            head1 = head1.next;
        }

        ListNode newhead = head1.next;
        head1.next = null;
        head1 = newhead;
        for (int i = 0;i < k - 1;i++){
            head1 = head1.next;
        }
        head1.next = head;

        return newhead;
    }
}
