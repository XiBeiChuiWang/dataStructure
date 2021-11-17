package 字节跳动._21_30;

import 字节跳动.tool.ListNode;

public class _25_19_删除链表的倒数第N个节点 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode first = node;
        ListNode second = node;
        for (int i = 0;i < n;i++){
            first = first.next;
        }

        while (first.next != null){
            first = first.next;
            second = second.next;
        }

        ListNode ne = second.next.next;

        second.next = ne;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        removeNthFromEnd(node,2);
    }
}
