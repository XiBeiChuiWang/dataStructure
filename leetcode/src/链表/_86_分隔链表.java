package 链表;

public class _86_分隔链表 {
    public static ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode l = first;
        ListNode r = second;
        while (head != null){
            if (head.val < x){
                l.next = head;
                l = l.next;
            }else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        l.next = second.next;
        r.next = null;
        return first.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        ListNode partition = partition(node, 3);
        while (partition != null){
            System.out.println(partition.val);
            partition = partition.next;
        }
    }
}
