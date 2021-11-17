package _21_30_;

import printer.ListNode;

public class _面试题_02_08_环路检测 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null){
            if (fast == slow){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != slow){
            return null;
        }
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);

    }
}
