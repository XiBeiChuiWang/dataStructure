package _21_30_;

import printer.ListNode;

public class _剑指_Offer_25_合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode hair = new ListNode(0);
        ListNode hair1 = hair;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                hair1.next = l1;
                l1 = l1.next;
            }else {
                hair1.next = l2;
                l2 = l2.next;
            }
            hair1 = hair1.next;
        }

        if (l1 != null){
            hair1.next = l1;
            return hair.next;
        }
        if (l2 != null){
            hair1.next = l2;
            return hair.next;
        }
        return hair.next;
    }
}
