package 字节跳动._51_60;

import 字节跳动.tool.ListNode;

public class _59_445_两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;

        ListNode prev = null;
        while (l1 != null){
            ListNode next = l1.next;
            l1.next = prev;
            prev = l1;
            l1 = next;
        }

        l1 = prev;

        prev = null;
        while (l2 != null){
            ListNode next = l2.next;
            l2.next = prev;
            prev = l2;
            l2 = next;
        }
        l2 = prev;

        ListNode listNode = new ListNode(0);
        ListNode node = listNode;
        int c = 0;

        while (l1 != null || l2 != null){
            int sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += c;
            c = sum / 10;

            node.next = new ListNode(sum % 10);

            node = node.next;
        }

        if (c == 1){
            node.next = new ListNode(1);
        }

        prev = null;
        node = listNode.next;
        while (node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
