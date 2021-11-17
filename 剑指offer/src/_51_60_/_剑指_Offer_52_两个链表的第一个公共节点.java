package _51_60_;

import printer.ListNode;

public class _剑指_Offer_52_两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode headA1 = headA;
        ListNode headB1 = headB;
        int aSize = 0;
        int bSize = 0;

        while (headA1 != null){
            aSize++;
            headA1 = headA1.next;
        }
        while (headB1 != null){
            bSize++;
            headB1 = headB1.next;
        }

        int abs = Math.abs(aSize - bSize);

        headA1 = headA;
        headB1 = headB;
        for (int i = 0;i < abs;i++){
            if (aSize > bSize){
                headA1 = headA1.next;
            }else {
                headB1 = headB1.next;
            }
        }

        while (headA1 != null){
            if (headA1 == headB1){
                return headA1;
            }else {
                headA1 = headA1.next;
                headB1 = headB1.next;
            }
        }
        return null;
    }
}
