package com.company;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    public void setVal(int val) {
        this.val = val;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
    public int getVal() {
        return val;
    }
    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }
}