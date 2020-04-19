package com.kingluffy.playstation.no2;

import com.kingluffy.playstation.base.ListNode;

/**
 * No.2
 *
 * 双指针依次相加合并链表，记录进位到下一个节点
 *
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //进位
        int up=0;

        // 返回参数
        ListNode head = new ListNode(0);

        // 当前指针
        ListNode cur=head;
        ListNode next;
        int v1,v2,tmp;

        if(l1==null && l2==null){
            return cur;
        }

        v1=l1==null?0:l1.val;
        v2=l2==null?0:l2.val;
        tmp=v1+v2+up;
        cur.val=tmp%10;
        up=tmp/10;

        while(true){
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
            if(l1==null && l2==null && up==0){
                return head;
            }

            v1=l1==null?0:l1.val;
            v2=l2==null?0:l2.val;
            tmp=v1+v2+up;
            up=tmp/10;

            next=new ListNode(tmp%10);
            cur.next=next;
            cur=next;
        }
    }
}
