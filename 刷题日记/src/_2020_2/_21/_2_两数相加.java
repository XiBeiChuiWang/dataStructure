package _2020_2._21;

import tool.ListNode;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode node = head;
        int jin  = 0;

        while (l1 != null && l2 != null){
            int i = l1.val + l2.val + jin;
            node.next = new ListNode(i % 10);
            jin = i / 10;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int i = l1.val + jin;
            node.next = new ListNode(i % 10);
            jin = i / 10;
            l1 = l1.next;
            node = node.next;
        }

        while (l2 != null){
            int i = l2.val + jin;
            node.next = new ListNode(i % 10);
            jin = i / 10;
            l2 = l2.next;
            node = node.next;
        }

        if (jin == 1){
            node.next = new ListNode(1);
        }

        return head.next;
    }

}
