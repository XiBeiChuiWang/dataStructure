package 每日一题._3_;

import tool.ListNode;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode next = head.next;

        while (next != null){
            if (prev.val == next.val){
                prev.next = next.next;
                next = next.next;
                continue;
            }else {
                prev = next;
                next = next.next;
            }
        }
        return head;
    }
}
