package leetcode.editor.cn;

import com.company.TreeNode;
import jdk.jshell.spi.SPIResolutionException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MostFrequentSubtreeSum508{
    public static void main(String[] args) {
     Solution solution = new MostFrequentSubtreeSum508().new Solution();
    }
/**
  * 题目Id：508
  * 题目：出现次数最多的子树元素和
  * 日期：2021-03-19 12:42:34
*/
//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 107 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxCount;
    HashMap<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root ==null){
            return new int[]{};
        }
        maxCount = 0;
        map = new HashMap<>();
        dfs(root);
        return mapToArray(map);
    }
    private int dfs(TreeNode root){
        if(root ==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum =left+right+root.val;
        int curCount = map.getOrDefault(sum,0)+1;
        if(curCount>=maxCount){
            maxCount =curCount;
        }
        map.put(sum,curCount);
        return sum;
    }

    private int[] mapToArray(HashMap<Integer,Integer> map){
        int size = map.size();
        int[] arr= new int[size];
        int i = 0;
        for (int cur:
                map.keySet()) {
                if(map.get(cur)== maxCount){
                    arr[i] = cur;
                    i++;
                }
        }
        int[] arr2 = new int[i];
        for (int j = 0;j<i;j++){
            arr2[j] = arr[j];
        }

        return arr2;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}