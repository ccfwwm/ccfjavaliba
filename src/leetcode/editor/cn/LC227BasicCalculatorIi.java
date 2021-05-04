package leetcode.editor.cn;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 391 👎 0

import java.util.Stack;

public class LC227BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new LC227BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            s=s+"+";
            int n = s.length();
            int sum = 0;
            int tmp = 0;
            char sign = '+';
            int i = 0;
            char c;
            Stack<Integer> stack = new Stack<>();
            while (i < n) {
                c = s.charAt(i);
                if (c == ' ') {
                    i++;
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    tmp = tmp * 10 + (c - '0');
                } else {
                    if (sign == '+') {
                        stack.push(tmp);
                    } else if (sign == '-') {
                        stack.push(-tmp);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * tmp);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / tmp);
                    }
                    sign = c;
                    tmp = 0;
                }
                i++;

            }
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}