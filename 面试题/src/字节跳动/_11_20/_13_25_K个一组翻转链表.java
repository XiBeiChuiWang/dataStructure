package 字节跳动._11_20;

import 字节跳动.tool.ListNode;

public class _13_25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;

        while (head != null){
            ListNode tail = prev;
            //判断是否结尾
            for (int i = 1;i <= k;i++){
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] listNodes = myReverse(head, tail);

            head = listNodes[0];
            tail = listNodes[1];
            //连接新链表
            prev.next = head;

            prev = tail;
            head = nex;

        }
        return hair.next;

    }
    private ListNode[] myReverse(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail,head};
    }
}
