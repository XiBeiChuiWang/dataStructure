package 字节跳动._31_40;

import 字节跳动.tool.ListNode;

public class _32_160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aCount = 0;
        int bCount = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null){
            aCount++;
            a = a.next;
        }
        while (b != null){
            bCount++;
            b = b.next;
        }
        int sub = Math.abs(aCount - bCount);
        ListNode newNode;
        ListNode newNode1;
        if (aCount > bCount){
            newNode = headA;
            newNode1 = headB;
        }else {
            newNode = headB;
            newNode1 = headA;
        }

        for (int i = 1;i <= sub;i++){
            newNode = newNode.next;
        }

        while (newNode != null){
            if (newNode == newNode1){
                return newNode;
            }
            newNode = newNode.next;
            newNode1 = newNode1.next;
        }
        return null;
    }
}
