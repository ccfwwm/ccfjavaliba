package leetcode.editor.cn;
//假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此
//类推。请你计算出粉刷完所有房子最少的花费成本。 
//
// 注意： 
//
// 所有花费均为正整数。 
//
// 示例： 
//
// 输入: [[1,5,3],[2,9,4]]
//输出: 5
//解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5; 
//     或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5. 
// 
//
// 进阶： 
//您能否在 O(nk) 的时间复杂度下解决此问题？ 
// Related Topics 动态规划 
// 👍 67 👎 0

public class LC265PaintHouseIi {
    public static void main(String[] args) {
        Solution solution = new LC265PaintHouseIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostII(int[][] costs) {
            int n = costs.length;
            if (n == 0) {
                return 0;
            }
            int k = costs[0].length;
            if(n==1&&k==1){
                return costs[0][0];
            }
            if(k==1&&n>k){
                return -1;
            }

            //n个房子，刷当前k种颜色，最小为多少
            int[][] dp = new int[n][2];
            findMin(dp[0],costs[0]);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    if(costs[i-1][j]==dp[i-1][0]){

                    }
                }
            }

            return dp[n-1][0];
        }

        private void  findMin(int[] dp,int[] nums){
            int first,second;
            if(nums[0]<=nums[1]){
               first=nums[0];
               second=nums[1];
            }else {
                first=nums[1];
                second=nums[2];
            }
            for (int i = 2; i <nums.length; i++) {
               if(nums[i]<first){
                   second=first;
                   first=nums[i];
               }else if(nums[i]<second){
                   second=nums[i];
               }
            }

            dp[0]= first;
            dp[1] = second;
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

}