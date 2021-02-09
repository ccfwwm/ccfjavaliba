package com.company;
/**
 * @implNote 实现数组反转类
 */
public class solutionClass {
    ListNode reverse(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode successor = null;//后驱节点

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }

    //递归实现区间反转
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    //迭代实现,反转整个链表
    ListNode reverseIteration(ListNode head) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = head;
        nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    //反转区间[a,b) 的元素，注意是左闭右开,返回反转后的链表头结点
    ListNode reverseIteration(ListNode a,ListNode b){
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;

    }
    ListNode reverseKGroup(ListNode head,int k) {
        //数组到达末尾的时候返回
        if (head == null)
            return null;
        //区间[a,b) 包含K个待反转元素
        ListNode a, b;
       a = b = head;
       for(int i = 0;i<k;i++){
           if(b == null) return head;
           b= b.next;
       }
       //反转前K个元素
        ListNode newHead = reverseIteration(a,b);
       //递归后反转后续链表并连接起来。
        a.next = reverseKGroup(b,k);
        return newHead;

    }
}
