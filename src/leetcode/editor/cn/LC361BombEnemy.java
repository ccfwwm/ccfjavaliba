package leetcode.editor.cn;
//想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据： 
//
// 
// 'W' 表示一堵墙 
// 'E' 表示一个敌人 
// '0'（数字 0）表示一个空位 
// 
//
// 
//
// 请你计算一个炸弹最多能炸多少敌人。 
//
// 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。 
//
// 注意：你只能把炸弹放在一个空的格子里 
//
// 示例: 
//
// 输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//输出: 3 
//解释: 对于如下网格
//
//0 E 0 0 
//E 0 W E 
//0 E 0 0
//
//假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
// 
// Related Topics 动态规划 
// 👍 53 👎 0

import jdk.jshell.spi.ExecutionControl;

public class LC361BombEnemy {
    public static void main(String[] args) {
        Solution solution = new LC361BombEnemy().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxKilledEnemies(char[][] grid) {
            //大体思路，分四个方向，上下左右能炸掉的敌人，然后合并计算
            //上下左右,以上为例dp[i][j]=dp[i][j-1]+graid[i][j]是否为E,如为w则为0;
            //合并，则sum=上下左右;
            int m = grid.length;
            if (m < 1) {
                return 0;
            }
            int n = grid[0].length;
            if (m == 1 && n == 1) {
                return 0;
            }

            //上
            int[][] top = new int[m][n];
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 'W' && grid[i - 1][j] != 'W') {
                        if (grid[i - 1][j] == 'E') {
                            top[i][j] = top[i - 1][j] + 1;
                        } else {
                            top[i][j] = top[i - 1][j];
                        }
                    }
                }
            }
            //下
            int[][] bottom = new int[m][n];
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 'W' && grid[i + 1][j] != 'W') {
                        if (grid[i + 1][j] == 'E') {
                            bottom[i][j] = bottom[i + 1][j] + 1;
                        } else {
                            bottom[i][j] = bottom[i + 1][j];
                        }
                    }
                }
            }

            //左
            int[][] left = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (grid[i][j] != 'w' && grid[i][j - 1] != 'W') {
                        if (grid[i][j - 1] == 'E') {
                            left[i][j] = left[i][j - 1] + 1;
                        } else {
                            left[i][j] = left[i][j - 1];
                        }
                    }
                }
            }
            //右
            int[][] right = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = n - 2; j >= 0; j--) {
                    if (grid[i][j] != 'w' && grid[i][j + 1] != 'W') {
                        if (grid[i][j + 1] == 'E') {
                            right[i][j] = right[i][j + 1] + 1;
                        } else {
                            right[i][j] = right[i][j + 1];
                        }
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0') {
                        sum = Math.max(sum, top[i][j] + bottom[i][j] + left[i][j] + right[i][j]);
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}