package leetcode.editor.cn;
//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的矩阵来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。请你计算出粉刷
//完所有房子最少的花费成本。 
//
// 注意： 
//
// 所有花费均为正整数。 
//
// 示例： 
//
// 输入: [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
// Related Topics 动态规划 
// 👍 107 👎 0

public class LC256PaintHouse {
    public static void main(String[] args) {
        Solution solution = new LC256PaintHouse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int n = costs.length;
            if (n < 1) {
                return 0;
            }
            int red = costs[0][0];
            int green = costs[0][1];
            int blue = costs[0][2];
            int tmp_red;
            int tmp_green;
            for (int i = 1; i < n; i++) {
                tmp_red = red;
                tmp_green = green;
                red = costs[i][0] + Math.min(green, blue);
                green = costs[i][1] + Math.min(tmp_red, blue);
                blue = costs[i][2] + Math.min(tmp_red, tmp_green);
            }
            return Math.min(Math.min(red, green), blue);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}