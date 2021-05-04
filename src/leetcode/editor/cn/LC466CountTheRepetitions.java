package leetcode.editor.cn;
//由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 
//
// 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得
//，但不能从 “acbbe” 获得。 
//
// 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S
//1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。 
//
// 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。 
//
// 
//
// 示例： 
//
// 输入：
//s1 ="acb",n1 = 4
//s2 ="ab",n2 = 2
//
//返回：
//2
// 
// Related Topics 动态规划 
// 👍 139 👎 0

public class LC466CountTheRepetitions {
    public static void main(String[] args) {
        Solution solution = new LC466CountTheRepetitions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int len1 = s1.length();
            int len2 = s2.length();
            //特判
            if (len1 == 0 || len2 == 0 || n1 == 0 || n2 == 0) {
                return 0;
            }
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            //记录下一个要匹配的s2中字符的下标
            int index2 = 0;
            //记录s2循环的次数，loopTImesOnS2是index2的函数
            int loopTimesOnS2 = 0;
            //当s1循环了i次以后，s2循环了几次
            int[] times = new int[n1];
            //当s1循环了i次以后，s2下一个字符匹配的下标（上一个字符匹配完以后是index2++,所有这里是下一个）
            int[] next = new int[n1];

            //暴力解法优化，一边遍历，一边找出循环节，找到就直接计算结果
            for (int i = 0; i < n1; i++) {
                //指针index1在s1上循环游走
                for (int index1 = 0; index1 < len1; index1++) {
                    //如果匹配到s2中的字符
                    if (chars1[index1] == chars2[index2]) {
                        index2++;
                    }
                    //匹配完一个s2,计数器+1，重置s2下标
                    if (index2 == len2) {
                        //循环扫描，因此index2重置为0
                        index2 = 0;
                        loopTimesOnS2++;
                    }
                }
                //记录了s1遍历i次后（从0开始），s2已经完整遍历了多少次
                times[i] = loopTimesOnS2;
                //记录了s1遍历了i次以后（从0开始），s2上index2的位置。
                //由于匹配完成后执行了index2++,所以此时index2指向下一个要匹配的字符
                next[i] = index2;
                //循环节一定是在：s1至少循环了一次以后
                //s2即将匹配的字符下标恰好等于s1刚刚循环一次以后，s2即将要匹配的下标，就是index2==next[0]的含义
                if (i > 0 && index2 == next[0]) {
                    //说明出现了循环节，直接计算结果，来自三个部分

                    //第一部分
                    int headCount = times[0];

                    //第二部分
                    // 这里难理解的话，一定要结合定义，看图理解，
                    // (n1 - 1)，要减去 1 个，因为从 s1 已经循环了一次开始，才出现的循环节
                    // (n1 - 1) / i 表示剩下的部分有多少个红色大括号段（见图）
                    // times[i] - times[0] 表示：每个循环节里出现了几个 s2
                    // ((n1 - 1) / i) * (times[i] - times[0]) 就表示中间那部分里面 s2 出现的次数
                    int circulateCount = ((n1 - 1) / i) * (times[i] - times[0]);

                    // 第 三 部分：结尾部分
                    // (n1 - 1) % i 相对于 (n1 - 1) / i 而言，就是不能整除的部分
                    // 减去 times[0] 是因为计算 times[i] 的时候计算的是前缀和，headCount 这部分已经计算过了，要把它删掉（写成两部分的和也可以）
                    int endCount = times[(n1 - 1) % i] - times[0];

                    //总结
                    //三个部分相加
                    return (headCount + circulateCount + endCount) / n2;
                }
            }
            //走到这里，没有发现循环节，n1-1是最后一次遍历s1的下标
            return times[n1 - 1] / n2;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}





