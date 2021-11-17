package 链表;

import tool.ListNode;

public class _19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        int length = 0;
        ListNode p = head;
        while (p != null){
            p = p.next;
            length++;
        }
        p = hair;

        for (int i = 1;i <= length - n;i++){
            p = p.next;
        }
        p.next = p.next.next;
        return hair.next;
    }
}
