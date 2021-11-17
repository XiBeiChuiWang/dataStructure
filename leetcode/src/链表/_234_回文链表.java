package 链表;

public class _234_回文链表 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int length = 1;
        ListNode headl = head;
        while (headl != null){
            length++;
            headl = headl.next;
        }
        headl = head;
        for (int i = 2;i <= length / 2;i++){
            headl = headl.next;
        }

        ListNode prev = null;
        ListNode curr = headl.next;
        while (curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        length--;
        for (int i = 1;i <= length / 2;i++){
            if (prev.val == head.val){
                head = head.next;
                prev = prev.next;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next =  new ListNode(2);
        node.next.next =  new ListNode(2);
        node.next.next.next =  new ListNode(1);
        System.out.println(isPalindrome(node));
    }
}
