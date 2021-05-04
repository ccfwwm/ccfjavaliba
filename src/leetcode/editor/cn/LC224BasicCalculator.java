package leetcode.editor.cn;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 560 👎 0

import java.util.Stack;

public class LC224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new LC224BasicCalculator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Stack<String> stack = new Stack<>();
            int len = s.length();
            int i = 0;
            stack.push("0");
            stack.push("+");
            int tmp = 0;
            String cur = "";
            while (i < len) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                    continue;
                }
                if (c != ')') {
                    stack.push(Character.toString(c));
                    i++;
                    continue;
                }
                cur = "";
                tmp = 0;
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    String top = stack.pop();
                    if (top.equals("-")) {
                        tmp -= Integer.parseInt(cur);
                        cur = "";
                    } else if (top.equals("+")) {
                        tmp += Integer.parseInt(cur);
                        cur = "";
                    } else {
                        cur = top + cur;
                    }
                }
                stack.pop();
                if(!cur.equals(""))
                    tmp += Integer.parseInt(cur);

                stack.push(Integer.toString(tmp));
                i++;
            }
            int sum = 0;
            String pre = "";
            while (!stack.isEmpty()) {
                String top = stack.pop();
                if (top.equals("+")&&!pre.equals("")) {

                    sum += Integer.parseInt(pre);
                    pre = "";
                } else if (top.equals("-")&&!pre.equals("")) {
                    sum -= Integer.parseInt(pre);
                    pre = "";
                } else {
                    pre =top+pre;
                }
            }

            return sum;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}