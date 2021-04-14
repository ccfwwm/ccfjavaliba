package leetcode.editor.cn;

import javax.print.DocFlavor;
import java.util.Map;
import java.util.Stack;

public class LC32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LC32LongestValidParentheses().new Solution();
    }

    /**
     * 题目Id：32
     * 题目：最长有效括号
     * 日期：2021-04-12 11:30:31
     */
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1262 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
    //动态规划
    class Solution {
        public int longestValidParentheses(String s) {
            if (s.length() < 2) {
                return 0;
            }
            int[] dp = new int[s.length()];
            dp[0] = 0;
            int maxLen = 0;
            int index = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        if (i - 2 >= 0) {
                            dp[i] = dp[i - 2] + 2;
                        } else {
                            dp[i] = 2;
                        }
                    } else {
                        index = i - dp[i - 1] - 1;
                        if (index >= 0 && s.charAt(index) == '(') {
                            if (index - 1 >= 0) {
                                dp[i] = dp[i - 1] + dp[index - 1] + 2;
                            } else {
                                dp[i] = dp[i - 1] + 2;
                            }
                        }
                    }
                }
                maxLen = dp[i] > maxLen ? dp[i] : maxLen;
            }
            return maxLen;
        }
    }


    //栈
//class Solution {
//    public int longestValidParentheses(String s) {
//        int maxLen = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//           if(s.charAt(i)=='('){
//               stack.push(i);
//           }else{
//               stack.pop();
//               if(stack.isEmpty()){
//                   stack.push(i);
//               }else{
//                   maxLen = maxLen>i-stack.peek()?maxLen:i-stack.peek();
//               }
//           }
//        }
//        return maxLen;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}