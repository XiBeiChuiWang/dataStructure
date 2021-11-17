package 链表;

import tool.ListNode;

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;

        while (head != null){
            ListNode tail = prev;

            for (int i = 1;i <= k;i++){
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode next = tail.next;

            reverseList(head, tail);

            prev.next = tail;

            prev = head;

            head = next;
        }
        return hair.next;
    }

    private void reverseList(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;

        while (prev != tail){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
    }
}
