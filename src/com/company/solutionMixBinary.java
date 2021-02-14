package com.company;

public class solutionMixBinary {

    //满二叉树节点数
    public int countNodesPerfect(TreeNode root){
       int h = 0;
       while (root!=null){
           root = root.left;
           h++;
       }
        return (int) Math.pow(2, h) - 1;
    }

    //计算完全二叉树节点数
    public int countNodesComplete(TreeNode root){
        TreeNode l = root,r = root;
        int hl= 0, hr = 0;
        while (l != null){
            l = l.left;
            hl ++;
        }
        while (r != null){
            r = r.right;
            hr ++;
        }
        if(hl == hr) {
            return (int) Math.pow(2,hl) -1;
        }

        return 1+ countNodesComplete(root.left) + countNodesComplete(root.right);

    }
}
