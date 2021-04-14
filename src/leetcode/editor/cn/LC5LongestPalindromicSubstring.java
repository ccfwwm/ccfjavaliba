package leetcode.editor.cn;

public class LC5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LC5LongestPalindromicSubstring().new Solution();
    }

    /**
     * 题目Id：5
     * 题目：最长回文子串
     * 日期：2021-04-11 14:34:32
     */
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3496 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
    //马拉车算法
    public class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            //得到预处理字符串
            String str = addBoundaries(s, '#');
            //新字符串长度，也可以试str.length()
            int sLen = 2 * len + 1;
            //数组p,记录当前位置的回文子串的半径
            int[] p = new int[sLen];

            //双指针，maxRight为扫描的最右边，center 为最右边回文子串的中心
            int maxRight = 0;
            int center = 0;
            //当前遍历的中心最大长度,初始为1个字符
            int maxLen = 1;
            //开始遍历起点，默认为索引0
            int start = 0;

            for (int i = 0; i < sLen; i++) {
                if (i < maxRight) {
                    //当前i,以center为中心的，镜像位置
                    int mirror = 2 * center - i;
                    //保守估计，若p[mirror]<=maxRight-i,则p[i]=p[mirror];
                    //若p[mirror]>maxRight-i,则最大半径只能为MaxRight-i,
                    //否则p[i]右边超出maxRight,无法保证为回文子串.
                    p[i] = Math.min(maxRight - i, p[mirror]);
                }

                //下一次尝试扩散的左右点,当前回文子串半径+1
                int left = i - (1 + p[i]);
                int right = i + (1 + p[i]);
                //在获取镜像后，有无可能增加回文子串，不会重复判断，如果长度为1，则不会进入当前循环。
                while (left >=0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                    p[i]++;
                    left--;
                    right++;
                }

                //更新max,当前半径超过maxRight，得更新maxRight
                if (i + p[i] > maxRight) {
                    maxRight = i + p[i];
                    center = i;
                }
                //更新起点和长度
                if (p[i] > maxLen) {
                    maxLen = p[i];
                    start = (i - maxLen) / 2;
                }

            }
            return s.substring(start, start + maxLen);


        }


        //预处理，分割字符串
        private String addBoundaries(String s, char divide) {
            int len = s.length();
            if (len == 0) {
                return "";
            }
            //排除分割字符不在字符串内
            if (s.indexOf(divide) != -1) {
                throw new IllegalArgumentException("参数错误，存在当前分割字符");
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(divide);
                sb.append(s.charAt(i));
            }
            sb.append(divide);
            return sb.toString();
        }
    }


//class Solution {
//    public String longestPalindrome(String s) {
//        int length = s.length();
//        boolean[] dp = new boolean[length];
//        int[] pathIndex = new int[]{0,0};
//        for (int start = length-1; start >=0 ; start--) {
//            for (int end = length - 1; end >= start; end--)
//            {
////                System.out.println("path="+pathIndex[0]+" "+pathIndex[1]+" len "+len+" start="+start);
//                dp[end] = (end-start< 3 || dp[end - 1]) && s.charAt(start) == s.charAt(end);
//                if (dp[end] && (pathIndex[1] - pathIndex[0]) < (end - start)) {
//                    pathIndex[0] = start;
//                    pathIndex[1] = end;
//                }
//            }
//        }
////         System.out.println("path="+pathIndex[0]+" "+pathIndex[1]);
//       return s.substring(pathIndex[0],pathIndex[1]+1);
//
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

}
















