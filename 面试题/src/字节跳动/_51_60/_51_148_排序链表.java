package 字节跳动._51_60;

import 字节跳动.tool.ListNode;

public class _51_148_排序链表 {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode sort = sort(head, slow);
        ListNode sort1 = sort(slow, tail);
        return marge(sort, sort1);
    }

    private ListNode marge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newListnode = new ListNode(0);
        ListNode nextListnode = newListnode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                nextListnode.next = l2;
                return newListnode.next;
            }
            if (l2 == null) {
                nextListnode.next = l1;
                return newListnode.next;
            }

            if (l1.val < l2.val) {
                nextListnode.next = l1;
                l1 = l1.next;
                nextListnode = nextListnode.next;
            } else {
                nextListnode.next = l2;
                l2 = l2.next;
                nextListnode = nextListnode.next;
            }
        }
        return newListnode.next;
    }

}
