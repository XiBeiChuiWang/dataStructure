package 链表;

import tool.ListNode;

public class _160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int aLength = 0;
        int bLength = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null){
            a = a.next;
            aLength++;
        }
        while (b != null){
            b = b.next;
            bLength++;
        }
        a = headA;
        b = headB;
        int abs = Math.abs(aLength - bLength);
        if (aLength > bLength){
            for (int i = 1;i <= abs;i++){
                a = a.next;
            }
        }else {
            for (int i = 1;i <= abs;i++){
                b = b.next;
            }
        }

        while (a != null){
            if (a == b){
                return a;
            }else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}
