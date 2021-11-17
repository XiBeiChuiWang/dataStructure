package 字节跳动._41_50;

import 字节跳动.tool.ListNode;

public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
