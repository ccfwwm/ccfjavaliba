package com.company;

public class binarySearch {

    /*
珂珂喜欢吃香蕉。这里有i堆香蕉，第i堆中有piles[i]根香蕉。警卫已经离开了，
将在H小时后回来。
珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，
从中吃掉K根。如果这堆香蕉少于K根，她将吃掉这堆的所有香蕉，
然后这一小时内不会再吃更多的香蕉。
珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
返回她可以在H小时内吃掉所有香蕉的最小速度K(K 为整数）。

     */
    public int minEatingSpeed(int[] piles, int H) {
        //H不能比piles的长度小，小的话此算法不成立
        int left = 1;
        //左闭右开，所以right得+1；
        int right = getMax(piles) + 1;
        while (left < right) {
            //防止溢出
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //如果最后不行，left就等于right,
        return left;
    }

    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        return max;
    }


    //包裹运输问题
    public int shipWithinDays(int[] weights, int D) {
        //载重可能的最小值
        int left = getMax(weights);
        //载重可能的最大值
        int right = getSum(weights) + 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (canFinishW(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean canFinishW(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length)
                    return true;
            }
        }
        return false;
    }

    int getSum(int[] w) {
        int sum = 0;
        for (int n : w) {
            sum += n;
        }
        return sum;
    }

}
