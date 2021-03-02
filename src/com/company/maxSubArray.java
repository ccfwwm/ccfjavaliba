package com.company;

import java.util.*;


public class maxSubArray {

    //最大子序和
    public int findMaxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        //base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;
        for (int i = 1; i < len; i++) {
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            res = Math.max(res, dp_1);
        }

        return res;

    }

    //备忘录，消除重叠问题
    int[][] memo;

    int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        //备忘录为-1,代表没有计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dp(s1, 0, s2, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        //base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }

    //备忘录，消除重叠问题
    int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0)
            return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        int pre, temp;
        for (int i = 1; i <= m; i++) {
            pre = 0;
            for (int j = 1; j <= n; j++) {
                temp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = 1 + pre;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                pre = temp;
            }
        }
        return dp[n];

    }

    public boolean canPartintion(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    //最大不相交区间
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0)
            return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //至少有一个区间不相交
        int count = 1;

        //排序后，第一个区间就是x
        int x_end = intvs[0][1];

        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                //找到下一个区间
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    public boolean isPossible(int[] nums) {
        int len = nums.length;
        if(len<3){
            return false;
        }
        Stack multi = new Stack();
        int count = 0;
        int slow = 0,fast = 1;
        while (fast<len){

        }



        return true;
    }


}












