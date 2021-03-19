package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.LinkedList;

/**
 * 题目Id：431
 * 题目：将 N 叉树编码为二叉树
 * 日期：2021-03-18 14:25:54
 */
//设计一个算法，可以将 N 叉树编码为二叉树，并能将该二叉树解码为原 N 叉树。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。类似地，一个二叉
//树是指每个节点都有不超过 2 个孩子节点的有根树。你的编码 / 解码的算法的实现没有限制，你只需要保证一个 N 叉树可以编码为二叉树且该二叉树可以解码回原始 N
// 叉树即可。 
//
// 例如，你可以将下面的 3-叉 树以该种方式编码： 
//
// 
//
// 
//
// 
//
// 注意，上面的方法仅仅是一个例子，可能可行也可能不可行。你没有必要遵循这种形式转化，你可以自己创造和实现不同的方法。 
//
// 注意： 
//
// 
// N 的范围在 [1, 1000] 
// 不要使用类成员 / 全局变量 / 静态变量来存储状态。你的编码和解码算法应是无状态的。 
// 
// Related Topics 树 
// 👍 35 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        return encodeDfs(root, 0);
    }

    private TreeNode encodeDfs(Node root, int direction) {
        if (root == null) {
            return null;
        }
        //当前root vall
        TreeNode encodeRoot = new TreeNode(root.val);
        //前驱指针
        TreeNode prev = encodeRoot;
        int size = root.children.size();
        //父节点为方向为右，则子节点为左
        if (direction == 0) {
            for (int i = 0; i < size; i++) {
                prev.left = encodeDfs(root.children.get(i), 1);
                prev = prev.left;
            }
            //同理
        } else {
            for (int i = 0; i < size; i++) {
                prev.right = encodeDfs(root.children.get(i), 0);
                prev = prev.right;
            }
        }
        return encodeRoot;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        return decodeDfs(root, 0);
    }

    private Node decodeDfs(TreeNode root, int direction) {
        if (root == null) {
            return null;
        }
        TreeNode pre = root;
        Node decodeRoot = new Node(root.val, new LinkedList<Node>());
        int index = 0;
        if (direction == 0) {
            while (pre.left != null) {
                decodeRoot.children.add(decodeDfs(pre.left, 1));
                pre = pre.left;
            }
        } else {
            while (pre.right != null) {
                decodeRoot.children.add(decodeDfs(pre.right, 0));
                pre = pre.right;
            }
        }
        return decodeRoot;

    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
//leetcode submit region end(Prohibit modification and deletion)
