package com.company;
import java.util.Stack;
import java.util.Vector;

public class soulotionMonotonousStack {

    //下一个更大的数
    public Vector<Integer> nextGreaterElement(Vector<Integer> nums){
       Vector<Integer> res =  new Vector<Integer>(nums.size());
        Stack<Integer> s = new Stack<Integer>();
        //倒着往栈里放
        for(int i = nums.size()-1;i>=0;i--){
            //判定个子高矮
            while (!s.empty() && s.peek()<=nums.get(i) ){
                s.pop();
            }
            // nums[i]身后的 next great number
            res.set(i,s.empty() ? -1:s.peek());
            s.push(nums.get(i));
        }

        return res;

    }

   //下一个更暖的日期，需要等待的天数
   public Vector<Integer> dailyTemperatures(Vector<Integer> Tep){
       Vector<Integer> res =  new Vector<Integer>(Tep.size());
       Stack<Integer> s = new Stack<Integer>();
       //倒着往栈里放
       for(int i = Tep.size()-1;i>=0;i--){
           //判定个子高矮
           while (!s.empty() && Tep.get(s.peek())<=Tep.get(i) ){
               s.pop();
           }
           // Tep[i]身后的更暖天气
           res.set(i,s.empty() ? -1:(s.peek()-i));
           s.push(i);
       }

       return res;

   }
   //环形数组求下一个更大的数

   public Vector<Integer> nextGreaterArrElement(Vector<Integer> nums){
        int n = nums.size();
       Vector<Integer> res =  new Vector<Integer>(n);
       Stack<Integer> s = new Stack<Integer>();
       //倒着往栈里放,假装数组长度翻倍，
       for(int i = 2*n-1;i>=0;i--){
           //判定个子高矮
           while (!s.empty() && s.peek()<=nums.get(i%n) ){
               s.pop();
           }
           // nums[i]身后的 next great number
           res.set(i%n,s.empty() ? -1:s.peek());
           s.push(nums.get(i%n));
       }

       return res;

   }


}
