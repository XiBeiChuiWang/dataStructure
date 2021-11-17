package 字节跳动._51_60;

import 字节跳动.tool.ListNode;

public class _56_92_反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode node = newHead;
        ListNode left = newHead;
        for (int i = 1;i < m;i++){
            node = node.next;
            left = left.next;
        }
        node = node.next;

        ListNode mid = node;
        ListNode prev = null;
        for (int i = 1;i <= n - m + 1;i++){
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        left.next = prev;
        node.next = mid;
        return newHead.next;
    }
}
