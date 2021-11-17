package 链表;

public class a141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null || fast.next != null){
            if (fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
