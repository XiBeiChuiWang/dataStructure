package 字节跳动._41_50;

import 字节跳动.tool.ListNode;

import java.util.Stack;

public class _43_143_重排链表 {
    public static void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针找到中点
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNext = slow.next;
        slow.next = null;

        //反转右半部分
        ListNode prev = null;
        ListNode node = midNext;
        while (node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        //合并左半部分和右半部分
        ListNode h = head;
        while (prev != null){
            ListNode h_next = h.next;
            ListNode prev_next = prev.next;

            h.next = prev;
            prev.next = h_next;

            prev = prev_next;
            h = h_next;

        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(2);
        reorderList(node);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
