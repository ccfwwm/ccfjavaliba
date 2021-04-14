package leetcode.editor.cn;
public class LC70ClimbingStairs {
    public static void main(String[] args) {
     Solution solution = new LC70ClimbingStairs().new Solution();
    }
/**
  * 题目Id：70
  * 题目：爬楼梯
  * 日期：2021-04-13 09:09:40
*/
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1595 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int first =1;
        int second = 2;
        int sum =0;
        for (int i = 3; i <=n; i++) {
           sum=first+second;
           first = second;
           second =sum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}