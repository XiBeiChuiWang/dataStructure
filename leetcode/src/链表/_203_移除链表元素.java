package 链表;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode newHead = head;

        while (head != null && head.val == val){
            newHead = head.next;
            head = head.next;
        }

        if (head == null){
            return newHead;
        }

        ListNode pre = head;

        while ((head = head.next) != null){
            if (head.val == val){
                pre.next = head.next;
            }else {
                pre = head;
            }
        }
        return newHead;
    }
}
