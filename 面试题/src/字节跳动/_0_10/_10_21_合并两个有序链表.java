package 字节跳动._0_10;

import 字节跳动.tool.ListNode;

public class _10_21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newListnode = new ListNode(0);
        ListNode nextListnode = newListnode;
        while (l1 != null || l2 != null){
            if (l1 == null){
                nextListnode.next = l2;
                return newListnode.next;
            }
            if (l2 == null){
                nextListnode.next = l1;
                return newListnode.next;
            }

            if (l1.val < l2.val){
                nextListnode.next = l1;
                l1 = l1.next;
                nextListnode = nextListnode.next;
            }else {
                nextListnode.next = l2;
                l2 = l2.next;
                nextListnode = nextListnode.next;
            }
        }
        return newListnode.next;
    }
}
