package com.company;

/**
 * The type Solution palindrome.
 */
public class solutionPalindrome {


    /**
     * Is palindrome boolean.
     * 判断字符串是否是字符串
     *
     * @param s the s
     * @return the boolean
     */
    boolean isPalindrome(String s){
        int left = 0, right = s.length() -1;
        while(left<right){
            if(s.indexOf(left)!= s.indexOf(right))
                return false;
            left++;
            right++;
        }

        return true;
    }

    /**
     * Traverse.二叉树遍历
     *
     * @param root the root
     */
    void traverse(TreeNode root){
        //前序遍历代码
        traverse(root.getLeft());
        //中序遍历代码
        traverse(root.getRight());
        //后序遍历代码
    }

    void traverseSample(ListNode head){
        //前序遍历代码
        traverse(head.next);
        //后序遍历代码
    }

    //模仿双指针判断回文
    ListNode left;
    boolean isPalindrome(ListNode head){
        left = head;
        return traverse(head);

    }
    boolean traverse(ListNode right){
        if(right == null)
            return true;
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    ListNode findMedium(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果fast !=null,则说明链表为奇数链表
        if (fast != null) {
            slow = slow.next;
        }

        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode pre= null,cur= head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    boolean isPalindromePlus(ListNode head){
        ListNode left = head;
        ListNode slow = findMedium(head);
        ListNode right = reverse(slow);
        while (right!=null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }



}
