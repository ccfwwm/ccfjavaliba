package leetcode.editor.cn;
//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 104 
// 
// Related Topics 二分查找 动态规划 
// 👍 513 👎 0

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class LC354RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new LC354RussianDollEnvelopes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            if (n == 0) {
                return n;
            }
            // Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
            //一维递增，二维递减
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0])
                        return o2[1] - o1[1];
                    return o1[0] - o2[0];
                }
            });
//            for (int i = 0; i < n; i++) {
//                System.out.println(envelopes[i][0] + " " + envelopes[i][1]);
//            }

            int[] f = new int[n];
            int ans = 1;
            for (int i = 0; i < n; i++) {
                f[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (envelopes[j][1] < envelopes[i][1]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }

//        boolean check(int[][] es, int mid, int i) {
//            return es[mid][0] < es[i][0] && es[mid][1] < es[i][1];
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}