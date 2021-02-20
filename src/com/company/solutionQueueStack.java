package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class solutionQueueStack {
}

//栈实现队列
class MyQueue {
    private Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int peek() {
        if (s2.isEmpty()) {
            //把s1元素压入s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public int pop() {
        //先调用peek保证s2非空
        peek();
        return s2.pop();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}

//队列实现栈
class MyStack{

    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;

    //添加元素到栈顶
    public void push(int x){
        q.offer(x);
        top_elem = x;

    }
   //删除栈顶元素并返回
    public  int pop(){
        int size = q.size();
        //留下2个元素
        while (size>2){
            q.offer(q.poll());
            size--;
        }
       //记录新的队尾元素
       top_elem = q.peek();
        q.offer(q.poll());
        //弹出实际作为栈的队尾元素
        return q.poll();

    }
   //返回栈顶元素
    public  int top(){
        return top_elem;
    }
   //判断栈是否为空
    public boolean empty(){
        return q.isEmpty();
    }


}
