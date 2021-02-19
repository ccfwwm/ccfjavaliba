package com.company;

import java.util.PriorityQueue;

public class solutionFindMedian {

    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    public solutionFindMedian(){
        //小顶堆
        large = new PriorityQueue<>();
        //大堆顶
        small = new PriorityQueue<>((a,b) -> {
            return b -a;
        });
    }


    //添加一个数字
    public void addNum(int num){
        if(small.size()>= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }


    //计算当前添加的所有数字的中位数
    public double findMedian(){
        //如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if(large.size()<small.size()){
            return small.peek();
        }else if(large.size()>small.size()){
            return large.peek();
        }
        //如果元素一样对，两个堆堆顶元素的平均数是中位数
        return (large.peek()+small.peek())/2;
    }
}
