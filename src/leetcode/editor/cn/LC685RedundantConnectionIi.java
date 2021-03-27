package leetcode.editor.cn;

import javax.swing.plaf.IconUIResource;

public class LC685RedundantConnectionIi {
    public static void main(String[] args) {
        Solution solution = new LC685RedundantConnectionIi().new Solution();
    }

    /**
     * 题目Id：685
     * 题目：冗余连接 II
     * 日期：2021-03-27 16:50:58
     */
//在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节
//点没有父节点。 
//
// 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条
//附加的边不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
//vi 的一个父节点。 
//
// 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[1,2],[1,3],[2,3]]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
//输出：[4,1]
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 
// Related Topics 树 深度优先搜索 并查集 图 
// 👍 233 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
            int len = edges.length;
            int[] inDegree = new int[len + 1];
            ///记录指向某个节点的边的条数，入度。
            for (int[] edge : edges) {
                inDegree[edge[1]]++;
            }

            //先查收删除构成入度为2的边，看是否形成环
            //从后往前，则是第一个
            for (int i = len - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 2) {
                    if (!judgeCircle(edges, len, i)) {
                        return edges[i];
                    }
                }
            }
            //再尝试删除入度为1的边，看看是否形成环
            for (int i = len - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 1) {
                    if (!judgeCircle(edges, len, i)) {
                        return edges[i];
                    }
                }
            }
            return new int[0];
        }

        private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
            UnionFind unionFind = new UnionFind(len + 1);
            for (int i = 0; i < len; i++) {
                if (i == removeEdgeIndex) {
                    continue;
                }
                if (!unionFind.union(edges[i][0], edges[i][1])) {
                    //合并失败，表示i0 和i1在一个连通分量里。构成了环
                    return true;
                }
            }
            return false;
        }

    }

    class UnionFind {
        //代表元法
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootX] = rootY;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


















