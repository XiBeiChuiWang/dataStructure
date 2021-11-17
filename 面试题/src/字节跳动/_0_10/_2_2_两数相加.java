package 字节跳动._0_10;

import 字节跳动.tool.ListNode;

public class _2_2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

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

        return listNode.next;
    }
}
