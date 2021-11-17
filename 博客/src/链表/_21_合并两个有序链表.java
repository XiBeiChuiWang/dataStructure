package 链表;

import tool.ListNode;

public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l1l = l1;
        ListNode l2l = l2;

        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1l != null && l2l != null){
            if (l1l.val <= l2l.val){
                node.next = l1l;
                l1l = l1l.next;
            }else {
                node.next = l2l;
                l2l = l2l.next;
            }
            node = node.next;
        }

        if (l1l == null){
            node.next = l2l;
        }else {
            node.next = l1l;
        }
        return head.next;
    }
}
