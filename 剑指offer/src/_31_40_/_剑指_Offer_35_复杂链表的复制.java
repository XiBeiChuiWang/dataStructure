package _31_40_;

import printer.Node;

import java.util.HashMap;
import java.util.HashSet;

public class _剑指_Offer_35_复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node head1 = head;

        while (head1 != null){
            nodeNodeHashMap.put(head1,new Node(head1.val));
            head1 = head1.next;
        }

        head1 = head;
        while (head1 != null){
            nodeNodeHashMap.get(head1).next = nodeNodeHashMap.get(head1.next);
            nodeNodeHashMap.get(head1).random = nodeNodeHashMap.get(head1.random);
            head1 = head1.next;
        }
        return nodeNodeHashMap.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node1;
        node2.random = node1;
        new _剑指_Offer_35_复杂链表的复制().copyRandomList(node1);
    }
}
