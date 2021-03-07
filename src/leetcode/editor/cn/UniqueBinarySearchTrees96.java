/**
  * 题目Id：96
  * 题目：不同的二叉搜索树
  * 日期：2021-03-05 10:22:42
*/
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 1028 👎 0

package leetcode.editor.cn;
public class UniqueBinarySearchTrees96{
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees96().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        //正常解法
//        if(n<=1){
//            return 1;
//        }
//        int[] dp = new int[n+1];
//        dp[0] =1;
//        dp[1] =1;
//        for (int i = 2; i <=n; i++) {
//            for(int j = 1;j<=i;j++){
//                dp[i] =dp[i]+ dp[j-1]*dp[i-j];
//            }
//        }
//        return dp[n];

        //卡塔兰数
        long sum = 1;
        for (int i = 0; i <n; ++i) {
           sum = sum*2*(2*i+1)/(i+2);
        }
        return (int)sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
