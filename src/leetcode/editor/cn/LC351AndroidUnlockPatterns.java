package leetcode.editor.cn;
//我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。用户可以设置一个 “解锁模式” ，通过连接特定序列中的点，形成一系列彼此连接的线
//段，每个线段的端点都是序列中两个连续的点。如果满足以下两个条件，则 k 点序列是有效的解锁模式： 
//
// 
// 解锁模式中的所有点 互不相同 。 
// 假如模式中两个连续点的线段需要经过其他点，那么要经过的点必须事先出现在序列中（已经经过），不能跨过任何还未被经过的点。 
// 
//
// 
//
// 以下是一些有效和无效解锁模式的示例： 
//
// 
// 
//
// 
// 无效手势：[4,1,3,6] ，连接点 1 和点 3 时经过了未被连接过的 2 号点。 
// 无效手势：[4,1,9,2] ，连接点 1 和点 9 时经过了未被连接过的 5 号点。 
// 有效手势：[2,4,1,3,6] ，连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。 
// 有效手势：[6,5,4,1,9,2] ，连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。 
// 
//
// 给你两个整数，分别为 m 和 n ，那么请你统计一下有多少种 不同且有效的解锁模式 ，是 至少 需要经过 m 个点，但是 不超过 n 个点的。 
//
// 两个解锁模式 不同 需满足：经过的点不同或者经过点的顺序不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 1, n = 1
//输出：9
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 2
//输出：65
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 9 
// 
// Related Topics 动态规划 回溯算法 
// 👍 82 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LC351AndroidUnlockPatterns {
    public static void main(String[] args) {
        Solution solution = new LC351AndroidUnlockPatterns().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;
        boolean[] marked = new boolean[10];
        UnionFind uf = new UnionFind(10);

        public int numberOfPatterns(int m, int n) {
            //经过点的范围1<=m,n<=9
            initializeUF();
            for (int i = 1; i < 10; i++) {
                dfs(i, 1, m, n);
            }
            return ans;
        }

        private void dfs(int s, int currentKeyCount, int lo, int hi) {
            //长度符合题意
            if (currentKeyCount >= lo && currentKeyCount <= hi) {
                ans++;//不返回
            } else if (currentKeyCount > hi) {
                return;
            }
            marked[s] = true;
            for (int i = 1; i < 10; i++) {
                //是否是同一分支
                boolean crrossNumber = uf.connected(s, i);
                //i未被访问，且位于不同分支，继续
                //i未被访问，且位于相同同分支，但中间节点（5)被访问过，则继续搜索
                //其他情况剪枝
                //>>>1表示无符合右移，等于s/2
                if (!marked[i] && (!crrossNumber || marked[(s + i) >>> 1])) {
                    dfs(i, currentKeyCount + 1, lo, hi);
                }
            }
            marked[s] = false;

        }

        private void initializeUF() {
            uf.union(1, 3);
            uf.union(1, 9);
            uf.union(1, 7);
            uf.union(4, 6);
            uf.union(2, 8);
        }

        class UnionFind {
            int[] parent;

            public UnionFind(int count) {
                parent = new int[count];
                for (int i = 0; i < count; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public void union(int p, int q) {
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot == qRoot) {
                    return;
                }
                parent[qRoot] = parent[pRoot];
            }

            public boolean connected(int x, int y) {
                return find(x) == find(y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}