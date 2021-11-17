package _11_20_;

import printer.ListNode;

public class _剑指_Offer_18_删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;

        ListNode fast = head;
        if (val == head.val){
            head = head.next;
            return head;
        }else {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null){
            if (val == fast.val){
                slow.next = fast.next;
                return head;
            }else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return head;
    }
}
