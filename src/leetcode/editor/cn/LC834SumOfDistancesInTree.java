package leetcode.editor.cn;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC834SumOfDistancesInTree {
    public static void main(String[] args) {
        Solution solution = new LC834SumOfDistancesInTree().new Solution();
    }

    /**
     * 题目Id：834
     * 题目：树中距离之和
     * 日期：2021-03-29 22:08:50
     */
//给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。 
//
// 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。 
//
// 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。 
//
// 示例 1: 
//
// 
//输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//输出: [8,12,6,10,10,10]
//解释: 
//如下为给定的树的示意图：
//  0
// / \
//1   2
//   /|\
//  3 4 5
//
//我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
//也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
// 
//
// 说明: 1 <= N <= 10000 
// Related Topics 树 深度优先搜索 
// 👍 270 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> graph = new ArrayList<>();
        //距离和
        private int[] disSum;
        //子树节点+自己
        private int[] nodeSum;

        public int[] sumOfDistancesInTree(int N, int[][] edges) {
            //初始化邻接表
            initGraph(edges, graph,N);
            disSum = new int[N];
            nodeSum = new int[N];
            //有N个节点，那么每个节点自己就是1
            Arrays.fill(nodeSum, 1);
            //第一次遍历，得到以N为子树的距离和
            postOrder(0, -1);
            //第二次比那里，得到内外子树的距离和
            preOrder(0, -1);
            return disSum;
        }

        private void postOrder(int root, int parent) {
            List<Integer> neighbors = graph.get(root);
            for (Integer neighbor : neighbors) {
                if(neighbor == parent) {
                    continue;
                }
                //遍历子节点和
                postOrder(neighbor, root);
                //node自身为1，for循环依次相加子节点
                nodeSum[root] += nodeSum[neighbor];
                //子树距离=求子树的和，每个子树的距离为子树距离+节点的的数量
                disSum[root] += disSum[neighbor] + nodeSum[neighbor];
            }
        }
        private void preOrder(int root, int parent) {
            List<Integer> neighbors = graph.get(root);
            for (Integer neighbor : neighbors) {
                if (neighbor == parent) {
                    continue;
                }
                //原语句,好理解
//           disSum[neighbor]= disSum[root]-nodeSum[neighbor]+graph.size()- nodeSum[neighbor];
                disSum[neighbor] = disSum[root] + graph.size() - (nodeSum[neighbor]<<1);
                preOrder(neighbor, root);
            }
        }

        private void initGraph(int[][] edges, List<List<Integer>> graph,int len) {
            for (int i = 0; i < len; i++) {
               graph.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < edges.length; i++) {
                graph.get(edges[i][0]).add(edges[i][1]);
                graph.get(edges[i][1]).add(edges[i][0]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}









