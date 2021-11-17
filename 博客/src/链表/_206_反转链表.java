package 链表;

import tool.ListNode;

public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode nex = head;

        while (nex != null){
            ListNode node = nex.next;
            nex.next = pre;
            pre = nex;
            nex = node;
        }
        return pre;
    }
}
