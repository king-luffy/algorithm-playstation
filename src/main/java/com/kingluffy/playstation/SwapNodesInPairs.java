package com.kingluffy.playstation;

import com.kingluffy.playstation.base.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class SwapNodesInPairs {
    private ListNode tmp;
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode result = head.next;
        swapFirst(head);
        while(true){
            if(head.next==null || head.next.next==null)
                break;
            swapNode(head);
            head=head.next.next;
        }
        return result;
    }
    private void swapFirst(ListNode node){
        tmp = node.next;
        node.next = tmp.next;
        tmp.next = node;
    }
    private void swapNode(ListNode node){
        tmp = node.next.next;
        swapFirst(node.next);
        node.next = tmp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head.next = new ListNode(2);
        cur = cur.next = new ListNode(3);
        cur.next = new ListNode(4);
        SwapNodesInPairs pairs = new SwapNodesInPairs();
        pairs.swapPairs(head);

        Queue<Integer> q = new LinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
    }
}
