package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class solutionBinary {
    //寻找重复的子树根节点
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public LinkedList<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }


    // 验证BST的合法性
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    //删除BST中的一个元素
    TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            //关机步骤
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // 序列化字符串
    String SEP = ",";
    String NULL = "#";

    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        //前序遍历
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    //字符串反序列化为二叉树
    TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }

        return deserialize(nodes);
    }

    //反序列化（前序遍历）
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL))
            return null;
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(first);

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;


    }

    //后序遍历，寻找最近的公共祖先
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //三种情况
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;

    }


}


















