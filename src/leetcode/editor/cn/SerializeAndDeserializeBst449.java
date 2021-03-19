package leetcode.editor.cn;

import com.company.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBst449 {
    public static void main(String[] args) {
        Solution solution = new SerializeAndDeserializeBst449().new Solution();
    }
/**
 * 题目Id：449
 * 题目：序列化和反序列化二叉搜索树
 * 日期：2021-03-18 23:03:12
 */
//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 104] 
// 0 <= Node.val <= 104 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
//
// 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 
// 👍 166 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null#";
            }
            StringBuilder curString = new StringBuilder();
            curString.append(root.val).append("#");
            curString.append(serialize(root.left));
            curString.append(serialize(root.right));
            return curString.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            //    System.out.println("data="+data);
            if (data.equals("null#")) {
                return null;
            }
            List<String> list = new LinkedList<>(Arrays.asList(data.split("#")));
            //     System.out.println("list="+list);
            return dfs(list);
        }

        private TreeNode dfs(List<String> list) {
            String str = list.remove(0);
            if (str.equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(str));
            //        System.out.println("list ="+list);
            root.left = dfs(list);
            root.right = dfs(list);
            return root;

        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)

}