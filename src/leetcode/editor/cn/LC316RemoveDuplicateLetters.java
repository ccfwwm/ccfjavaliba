package leetcode.editor.cn;
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 524 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class LC316RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new LC316RemoveDuplicateLetters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution{
        public String removeDuplicateLetters(String s) {
         Stack<Character> stack=new Stack<>();
         boolean[] instack = new boolean[256];
         int[] count=new int[265];
         for (int i=0;i<s.length();i++){
             count[s.charAt(i)]+=1;
         }
         for(char c:s.toCharArray()){
             count[c]--;
             if(instack[c]){
                 continue;
             }
             while (!stack.isEmpty()&&stack.peek()>c){
                 if(count[stack.peek()]==0){
                     break;
                 }
                 instack[stack.pop()]=false;
             }
             stack.push(c);
             instack[c]=true;
         }
        StringBuilder sb=new StringBuilder();
         while (!stack.isEmpty()){
             sb.append(stack.pop());
         }
         return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}