package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC545BoundaryOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new LC545BoundaryOfBinaryTree().new Solution();
    }
/**
 * 题目Id：545
 * 题目：二叉树的边界
 * 日期：2021-03-21 12:51:06
 */
//二叉树的 边界 是由 根节点 、左边界 、按从左到右顺序的 叶节点 和 逆序的右边界 ，按顺序依次连接组成。 
//
// 左边界 是满足下述定义的节点集合： 
//
// 
// 根节点的左子节点在左边界中。如果根节点不含左子节点，那么左边界就为 空 。 
// 如果一个节点在左边界中，并且该节点有左子节点，那么它的左子节点也在左边界中。 
// 如果一个节点在左边界中，并且该节点 不含 左子节点，那么它的右子节点就在左边界中。 
// 最左侧的叶节点 不在 左边界中。 
// 
//
// 右边界 定义方式与 左边界 相同，只是将左替换成右。即，右边界是根节点右子树的右侧部分；叶节点 不是 右边界的组成部分；如果根节点不含右子节点，那么右边界
//为 空 。 
//
// 叶节点 是没有任何子节点的节点。对于此问题，根节点 不是 叶节点。 
//
// 给你一棵二叉树的根节点 root ，按顺序返回组成二叉树 边界 的这些值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3,4]
//输出：[1,3,4,2]
//解释：
//- 左边界为空，因为二叉树不含左子节点。
//- 右边界是 [2] 。从根节点的右子节点开始的路径为 2 -> 4 ，但 4 是叶节点，所以右边界只有 2 。
//- 叶节点从左到右是 [3,4] 。
//按题目要求依序连接得到结果 [1] + [] + [3,4] + [2] = [1,3,4,2] 。 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3,4,5,6,null,null,null,7,8,9,10]
//输出：[1,2,4,7,8,9,10,6,3]
//解释：
//- 左边界为 [2] 。从根节点的左子节点开始的路径为 2 -> 4 ，但 4 是叶节点，所以左边界只有 2 。
//- 右边界是 [3,6] ，逆序为 [6,3] 。从根节点的右子节点开始的路径为 3 -> 6 -> 10 ，但 10 是叶节点。
//- 叶节点从左到右是 [4,7,8,9,10]
//按题目要求依序连接得到结果 [1] + [2] + [4,7,8,9,10] + [6,3] = [1,2,4,7,8,9,10,6,3] 。 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 
// 👍 63 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            if(root ==null){
                return null;
            }
            List<Integer> rootList = new LinkedList<>();
            rootList.add(root.val);
            if(root.left ==null && root.right ==null){
                return rootList;
            }
            List<Integer> leftList = new LinkedList<>();
            findLeft(root, leftList);
            List<Integer>  leafList = new LinkedList<>();
            findLeaf(root,leafList);
            List<Integer> rightList = new LinkedList<>();
            findRight(root, rightList);
            if (leftList != null) {
                rootList.addAll(leftList);
            }
            if(leafList !=null){
                rootList.addAll(leafList);
            }
            if (rightList != null) {
                rootList.addAll(rightList);
            }
            return rootList;
        }

        private void findLeaf(TreeNode root,List<Integer> list){
            if(root ==null){
                return;
            }
            if(root.left ==null && root.right ==null){
               list.add(root.val);
            }
            findLeaf(root.left,list);
            findLeaf(root.right,list);
        }


        private void findLeft(TreeNode root, List<Integer> list) {
            if (root.left == null) {
                return;
            }
            int flag = 1;
            while (root.left != null || root.right != null) {
                if (flag == 1) {
                    while (root.left != null) {
                        if (root.left.left == null && root.left.right == null) {
                            return;
                        } else if (root.left.left == null) {
                            list.add(root.left.val);
                            root = root.left;
                            flag = 2;
                            break;
                        }else {
                            list.add(root.left.val);
                            root = root.left;
                        }
                    }
                } else {
                    if(root.right.left !=null){
                        list.add(root.right.val);
                        root = root.right;
                        flag = 1;
                        continue;
                    }
                    while (root.right != null) {
                        if (root.right.right == null && root.right.left == null) {
                            return;
                        } else if (root.right.right == null) {
                            list.add(root.right.val);
                            root = root.right;
                            flag = 1;
                            break;
                        }else {
                            list.add(root.right.val);
                            root = root.right;
                        }
                    }
                }
            }
        }

        private void findRight(TreeNode root, List<Integer> list) {
            if (root.right == null) {
                return;
            }
            int flag = 2;
            while (root.left != null || root.right != null) {
                if (flag == 1) {
                    if(root.left.right !=null){
                        list.add(0,root.left.val);
                        root = root.left;
                        flag = 2;
                        continue;
                    }
                    while (root.left != null) {
                        if (root.left.left == null && root.left.right == null) {
                            return;
                        } else if (root.left.left == null) {
                            list.add(0, root.left.val);
                            root = root.left;
                            flag = 2;
                            break;
                        }else {
                            list.add(0, root.left.val);
                            root = root.left;
                        }
                    }
                } else {
                    while (root.right != null) {
                //        System.out.println("root.right ="+root.right.val);
                        if (root.right.right == null && root.right.left == null) {
                            return;
                        } else if (root.right.right == null) {
                            list.add(0, root.right.val);
                            root = root.right;
                            flag = 1;
                            break;
                        }else {
                            list.add(0, root.right.val);
                            root = root.right;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}