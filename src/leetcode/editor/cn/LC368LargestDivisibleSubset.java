package leetcode.editor.cn;
//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数学 动态规划 
// 👍 333 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LC368LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new LC368LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.sort(nums);
            int maxSize = 1;
            int maxVal = nums[0];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                ++dp[i];
                if (dp[i] > maxSize) {
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }

            List<Integer> list = new LinkedList<>();
            if (maxSize == 1) {
                list.add(nums[0]);
                return list;
            }
            for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
                if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                    list.add(nums[i]);
                    maxVal = nums[i];
                    maxSize--;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}