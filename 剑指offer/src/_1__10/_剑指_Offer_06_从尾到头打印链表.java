package _1__10;

import printer.ListNode;

import java.util.Stack;

public class _剑指_Offer_06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};

        Stack<Integer> integers = new Stack<>();
        ListNode head1= head;
        while (head1 != null){
            integers.push(head1.val);
            head1 = head1.next;
        }
        int[] ints = new int[integers.size()];

        for (int i = 0;i <= ints.length - 1;i++){
            ints[i] = integers.pop();
        }
        return ints;
    }
}
