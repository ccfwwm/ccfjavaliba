package leetcode.editor.cn;
//在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要
//被重新涂色。 
//
// 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区 [{1}, {2,2}
//, {3,3}, {2}, {1,1}] 。） 
//
// 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中： 
//
// 
// houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。 
// cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。 
// 
//
// 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n
// = 2, target = 3
//输出：9
//解释：房子涂色方案为 [1,2,2,1,1]
//此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
//涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
// 
//
// 示例 2： 
//
// 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n
// = 2, target = 3
//输出：11
//解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
//此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
//给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
// 
//
// 示例 3： 
//
// 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, 
//n = 2, target = 5
//输出：5
// 
//
// 示例 4： 
//
// 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3
//, target = 3
//输出：-1
//解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
// 
//
// 
//
// 提示： 
//
// 
// m == houses.length == cost.length 
// n == cost[i].length 
// 1 <= m <= 100 
// 1 <= n <= 20 
// 1 <= target <= m 
// 0 <= houses[i] <= n 
// 1 <= cost[i][j] <= 10^4 
// 
// Related Topics 动态规划 
// 👍 107 👎 0

public class LC1473PaintHouseIii {
    public static void main(String[] args) {
        Solution solution = new LC1473PaintHouseIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            //INF最大值， /2是为了防止越界
            int INF = Integer.MAX_VALUE / 2;
            //三个维度分别对应房子编号。颜色编号，分区编号
            int[][][] dp = new int[m + 1][n + 1][target + 1];

            //将每一个位置初始化
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    //房子编号和分区编号同时为0是，初始化为0
                    for (int k = 0; k <= target; k++) {
                        dp[i][j][k] = (i == 0 && k == 0) ? 0 : INF;
                    }
                }
            }

            //遍历每个房子
            for (int i = 1; i <= m; i++) {
                //获取房子对应颜色，其中0表示未上色
                int color = houses[i - 1];
                //遍历每种可能的颜色
                for (int j = 1; j <= n; j++) {
                    //遍历每种分区方案，分区方案必然从1开始,并且k不可能大于房子的个数。
                    for (int k = 1; k <= i && k <= target; k++) {
                        //第i间已经上色
                        if (color != 0) {
                            //本来的颜色已经固定，不能再刷当前的颜色，则置为INF
                            if (j != color) {
                                dp[i][j][k] = INF;
                                //与房子的颜色相同。则转移比较
                            } else {
                                //当前房子已经粉刷过，所以当前房子的费用不需要计算在内
                                //1,当前颜色为新分区，前后房子颜色不同
                                //即从上一分区，不同颜色 的房子中，找花费最少的情况
                                int tmp1 = INF;
                                for (int p = 1; p <= n; p++) {
                                    if (p != j) {
                                        tmp1 = Math.min(tmp1, dp[i - 1][p][k - 1]);
                                    }
                                }
                                //2,不形成新分区,则分区相同,前后房子颜色相同.
                                int tmp2 = dp[i - 1][j][k];
                                //两种情况中，取最小值。
                                dp[i][j][k] = Math.min(tmp1, tmp2);

                            }
                            //第i间房子未上色
                        } else {
                            //1,给当前颜色设立新分区，前后房子颜色不同。
                            //即上一分区中，不同颜色中，取花费最小的情况
                            int tmp1 = INF;
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp1 = Math.min(tmp1, dp[i - 1][p][k - 1]);
                                }
                            }
                            //2,不形成新分区。前后房子颜色相同
                            //即取上一分区，相同颜色的房子
                            int tmp2 = dp[i - 1][j][k];
                            //两者情况中，找花费最少的，同时加上当前要粉刷的漆的颜色的金额。
                            dp[i][j][k] = Math.min(tmp1, tmp2) + cost[i - 1][j - 1];
                        }
                    }
                }
            }
            //从考虑所有房子，形成分区为target的所有颜色方案中找答案。
            int ans = INF;
            for (int j = 1; j <= n; j++) {
                ans = Math.min(ans, dp[m][j][target]);
            }
            return ans == INF ? -1 : ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}







