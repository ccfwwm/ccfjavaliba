/**
  * 题目Id：117
  * 题目：填充每个节点的下一个右侧节点指针 II
  * 日期：2021-03-10 15:26:29
*/
//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 373 👎 0

package leetcode.editor.cn;
public class PopulatingNextRightPointersInEachNodeIi117{
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi117().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {
            root = connection(root);
            return root;
        }
        private Node connection(Node root){
            if(root == null){
                return root;
            }
            if(root.left!= null && root.right !=null){
                root.left.next = root.right;
            }
            if(root.left!=null && root.right == null){
                root.left.next = getNext(root.next);
            }
            if(root.right!=null){
                root.right.next = getNext(root.next);
            }

            //一定要先递归右树，不然会出现左树找不到正确的右树next
            connection(root.right);
            connection(root.left);
            return root;
        }

        public Node getNext(Node root){
            if(root==null) return null;
            if(root.left!=null) return root.left;
            if(root.right!=null) return root.right;
            if(root.next!=null) return getNext(root.next);
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
