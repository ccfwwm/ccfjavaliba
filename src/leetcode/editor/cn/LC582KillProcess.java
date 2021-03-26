package leetcode.editor.cn;

import java.sql.ClientInfoStatus;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC582KillProcess {
    public static void main(String[] args) {
     Solution solution = new LC582KillProcess().new Solution();
    }
/**
  * 题目Id：582
  * 题目：杀掉进程
  * 日期：2021-03-23 18:17:33
*/
//系统中存在 n 个进程，形成一个有根树结构。给你两个整数数组 pid 和 ppid ，其中 pid[i] 是第 i 个进程的 ID ，ppid[i] 是第 
//i 个进程的父进程 ID 。 
//
// 每一个进程只有 一个父进程 ，但是可能会有 一个或者多个子进程 。只有一个进程的 ppid[i] = 0 ，意味着这个进程 没有父进程 。 
//
// 当一个进程 被杀掉 的时候，它所有的子进程和后代进程都要被杀掉。 
//
// 给你一个整数 kill 表示要杀掉进程的 ID ，返回杀掉该进程后的所有进程 ID 的列表。可以按 任意顺序 返回答案。 
// 
//
// 示例 1： 
//
// 
//输入：pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
//输出：[5,10]
//解释：涂为红色的进程是应该被杀掉的进程。
// 
//
// 示例 2： 
//
// 
//输入：pid = [1], ppid = [0], kill = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == pid.length 
// n == ppid.length 
// 1 <= n <= 5 * 104 
// 1 <= pid[i] <= 5 * 104 
// 0 <= ppid[i] <= 5 * 104 
// 仅有一个进程没有父进程 
// pid 中的所有值 互不相同 
// 题目数据保证 kill 在 pid 中 
// 
// Related Topics 树 队列 
// 👍 54 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            List<Integer> l = map.getOrDefault(ppid.get(i),new LinkedList<>());
            l.add(pid.get(i));
            map.put(ppid.get(i),l);
        }
        List<Integer> list =new LinkedList<>();
        list.add(kill);
        getAllKill(map,list,kill);
        return list;
    }
    private void getAllKill(HashMap<Integer,List<Integer>> map,List<Integer> list,int kill){
        if(map.containsKey(kill)){
            for (int id :
                    map.get(kill)) {
               list.add(id);
               getAllKill(map,list,id);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}