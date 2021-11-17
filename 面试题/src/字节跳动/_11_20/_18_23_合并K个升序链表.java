package 字节跳动._11_20;

import 字节跳动.tool.ListNode;

public class _18_23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length);

    }

    private ListNode mergeKLists(ListNode[] lists ,int l,int r) {
        if (r - l == 1) return lists[l];
        if (l >= r) return null;
        int mid = (l + r) / 2;
        return merge(mergeKLists(lists, l, mid),mergeKLists(lists, mid, r));
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode newListNode = new ListNode(0);
        ListNode prev = newListNode;
        while (l1 != null || l2 != null){
            if (l1 == null){
                prev.next = l2;
                return newListNode.next;
            }
            if (l2 == null){
                prev.next = l1;
                return newListNode.next;
            }

            if (l1.val <= l2.val){
                prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
            }else {
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        return newListNode.next;
    }
}
