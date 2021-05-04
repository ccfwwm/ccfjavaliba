package leetcode.editor.cn;
//给你一个 rows x cols 的屏幕和一个用 非空 的单词列表组成的句子，请你计算出给定句子可以在屏幕上完整显示的次数。 
//
// 注意： 
//
// 
// 一个单词不能拆分成两行。 
// 单词在句子中的顺序必须保持不变。 
// 在一行中 的两个连续单词必须用一个空格符分隔。 
// 句子中的单词总量不会超过 100。 
// 每个单词的长度大于 0 且不会超过 10。 
// 1 ≤ rows, cols ≤ 20,000. 
// 
//
// 
//
// 示例 1： 
//
// 输入：
//rows = 2, cols = 8, 句子 sentence = ["hello", "world"]
//
//输出：
//1
//
//解释：
//hello---
//world---
//
//字符 '-' 表示屏幕上的一个空白位置。
// 
//
// 
//
// 示例 2： 
//
// 输入：
//rows = 3, cols = 6, 句子 sentence = ["a", "bcd", "e"]
//
//输出：
//2
//
//解释：
//a-bcd- 
//e-a---
//bcd-e-
//
//字符 '-' 表示屏幕上的一个空白位置。
// 
//
// 
//
// 示例 3： 
//
// 输入：
//rows = 4, cols = 5, 句子 sentence = ["I", "had", "apple", "pie"]
//
//输出：
//1
//
//解释：
//I-had
//apple
//pie-I
//had--
//
//字符 '-' 表示屏幕上的一个空白位置。
// 
//
// 
// Related Topics 动态规划 
// 👍 60 👎 0

public class LC418SentenceScreenFitting {
    public static void main(String[] args) {
        Solution solution = new LC418SentenceScreenFitting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wordsTyping(String[] sentence, int rows, int cols) {
            int times = 0, i = 0, r = 1, c = 0; //r为行数，方便后续计算循环节
            while (r <= rows) {
                int len = sentence[i].length();
                if (c + len > cols) {//当前无法输出单词
                    r++;
                    c = 0;
                } else {
                    c += len + 1;//加上单词的长度包括空格
                    i++;
                    if (i == sentence.length) {//输出完整的一个句子
                        times++;
                        i = 0;
                        if (sentence[0].length() > cols - c) {//出现循环节
                            times = rows / r * times;
                            r = rows - (rows % r) + 1;
                            c = 0;
                        }
                    }
                }
            }
            return times;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}