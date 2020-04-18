package com.kingluffy.playstation;

import com.kingluffy.playstation.base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RoopLink {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur!=null){
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        head.next=n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        ListNode result = new RoopLink().detectCycle(head);
        System.out.println(result.val);
    }
}
