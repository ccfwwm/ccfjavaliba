package com.company;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class solutionRandom {
    private Vector<Integer> nums = new Vector();
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, nums.size());
        nums.add(val);
        return true;

    }

    public boolean remove(int val) {

        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastVal = nums.lastElement();
        valToIndex.put(lastVal, index);
        valToIndex.remove(val);

        nums.remove(lastVal);
        nums.set(index, lastVal);

        return true;

    }

    public int getRandom() {
        int index = (int) (Math.random() * nums.size());
        return nums.elementAt(index);
    }


    //字符串去重，保证顺序，保证字典序最小,leetcode 318
    String removeDuplicateLetters(String s) {
        //保证顺序
        Stack<Character> stk = new Stack<>();
        //字符计数
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c])
                continue;
            while (!stk.isEmpty() && stk.peek() > c) {
                if (count[stk.peek()] <= 0) {
                    break;
                }
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.empty())
            sb.append(stk.pop());
        return sb.reverse().toString();

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


}


class solutionBlack {
    private int N;
    private Vector<Integer> blacklist;

    public solutionBlack(int N, Vector<Integer> blacklist) {
        this.N = N - blacklist.size();
        this.blacklist = blacklist;

    }

    int pick() {
        return 0;
    }

    //零钱问题
    public int coinChange(int[] coins, int amount) {
        //数组大小为amount+1,初始值无穷大
        //当目标金额为i时，至少需要d[i]枚银币凑出
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            //内层循环遍历所有状态的所有取值
            for (int coin : coins) {
                //子问题无解，跳过
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

}
