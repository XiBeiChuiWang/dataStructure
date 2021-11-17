package 字节跳动._41_50;

import 字节跳动.tool.ListNode;

public class _47_24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode h = node;
        while (h.next != null && h.next.next != null){
            ListNode next = h.next.next.next;
            ListNode second = h.next.next;
            ListNode first = h.next;
            h.next = second;
            second.next = first;
            first.next = next;
            h = first;
        }
        return node.next;
    }
}
