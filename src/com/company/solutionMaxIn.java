package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;

public class solutionMaxIn {

    public int maxEnvelopes(int[][] envelopes){
        int n = envelopes.length;
        //按照宽度排序，如果宽度一样，则按照高度降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a ,int[] b){
                return a[0] == b[0] ? b[1]-a[1]:a[0]-b[0];
            }

        });

        //对高度数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }
        //二分查找
    public int lengthOfLIS(int[] nums){
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0, right = piles;
            //二分查找插入位置
            while (left<right){
                //防止越界
                int mid = left + (right-left)/2;
                if(top[mid] >= poker){
                    right = mid;
                }else {
                    left = mid +1;
                }
            }
            if (left == piles) piles++;
            //把这张牌放到牌堆顶
            top[left] = poker;
        }
        //牌堆数就是LIS长度
        return piles;
    }
   //dp查找
    public int lengthOfLISDP(int[] nums){

        int[] dp = new int[nums.length];
        //base case:dp数组全部都初始为1
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res  = 0;
        for (int i = 0; i < dp.length; i++) {
           res = Math.max(res,dp[i]);
        }
        return res;

    }


}
