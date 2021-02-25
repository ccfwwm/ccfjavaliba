package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class solutionQueue {

    public int[] maSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前k-1
                window.push(nums[i]);
            } else {
                //窗口向前滑动，加入新数字
                window.push(nums[i]);
                //记录当前窗口的最大值
                res.add(window.max());
                //移除旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        //需要转换成 int[]数组后再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);

        }
        return arr;

    }


}

class MonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();


    public void push(int n) {
        //将小于n的元素全部删除
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        //然后将n加入尾部
        q.addLast(n);

    }

    public int max() {
        //队首就是最大的
        return q.getFirst();
    }

    public void pop(int n) {
        //如果已经压缩，则不处理，如果刚好是队首，则弹出
        if (n == q.getFirst()) {
            q.pollFirst();
        }
    }

}
