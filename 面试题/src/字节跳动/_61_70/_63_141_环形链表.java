package 字节跳动._61_70;

import 字节跳动.tool.ListNode;

public class _63_141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
                if (fast == slow)
                    return true;
            }
        }
        return false;
    }
}
