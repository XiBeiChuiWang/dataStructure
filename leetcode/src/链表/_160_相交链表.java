package 链表;

import java.util.Stack;

public class _160_相交链表 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Stack<ListNode> aStack = new Stack<>();
        Stack<ListNode> bStack = new Stack<>();
        while (headA != null) {
            aStack.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            bStack.push(headB);
            headB = headB.next;
        }

//        ListNode apop = null;
//        ListNode bpop = null;
        ListNode node = null;
        while (!aStack.isEmpty() && !bStack.isEmpty()) {
            ListNode apop = aStack.pop();
            ListNode bpop = bStack.pop();
            if (apop != bpop) {
                break;
            }else {
                node = apop;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node1 = new ListNode(4);
        node.next = new ListNode(6);
        ListNode node12 = new ListNode(1);
        node12.next = new ListNode(8);
        node.next.next = node12;
        node1.next = node12;
        ListNode intersectionNode = getIntersectionNode2(node, node1);
        System.out.println(intersectionNode.val);
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int alength = 0;
        int blength = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            alength++;
            a = a.next;
        }
        while (b != null) {
            blength++;
            b = b.next;
        }

        for (int i = 1;i <= Math.abs(alength - blength);i++){
            if (alength > blength){
                headA = headA.next;
            }else {
                headB = headB.next;
            }
        }

        while (headA != null){
            if (headA != headB){
                headA = headA.next;
                headB = headB.next;
            }else {
                break;
            }
        }
        return headA;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;

        }
        return curA;
    }
}
