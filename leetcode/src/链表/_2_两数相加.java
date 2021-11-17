package 链表;

public class _2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode listNode = new ListNode(0);
        ListNode newlistNode = listNode;
        int b = 0;

        while (l1 != null || l2 != null) {
            int i = 0;

            if (l1 != null && l2 != null) {
                i = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                i = l2.val;
                l2 = l2.next;
            } else {
                i = l1.val;
                l1 = l1.next;
            }
            i = i + b;

            b = i / 10;

            listNode.next = new ListNode(i % 10);

            listNode = listNode.next;
        }

        if (b > 0) {
            listNode.next = new ListNode(b);
        }
        return newlistNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);

    }
}
