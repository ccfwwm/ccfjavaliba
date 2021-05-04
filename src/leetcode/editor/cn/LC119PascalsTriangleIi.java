package leetcode.editor.cn;
//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 281 👎 0

import java.util.LinkedList;
import java.util.List;

public class LC119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new LC119PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            LinkedList<Integer> list = new LinkedList<>();
            long cur = 1;
            for (int i = 0; i <= rowIndex; i++) {
                list.add((int) cur);
                cur = cur * (rowIndex - i) / (i + 1);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}