package com.company;

import javax.swing.*;

public class solutionUF {

    //Union-Find算法

    //记录连通分量
    private int count;

    //节点x的父亲是parent[x];
    private int[] parent;

    //树的节点量
    private int[] size;

    public solutionUF(int n) {
        //初始化，一开始不连通
        this.count = n;
        //父节点指针初始指向自己
        parent = new int[n];
        //最初树的节点为1
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //连通两个图
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        //连通两棵树,小树接到大叔下面
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        //连通量减小1
        count--;
    }

    //返回某个节点X的根节点
    private int find(int x) {
        //根节点parent[x] == x
        while (parent[x] != x) {
            //路径压缩，非常巧妙
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    //返回连通分量个数
    public int getCount() {
        return count;
    }

    //判断是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    //判断算式合法性
    boolean equationsPossible(String[] equations) {
        solutionUF sUF = new solutionUF(26);
        //先相等的字母连通
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                sUF.union(x - 'a', y - 'a');
            }
        }

        //判断！= 是否冲突
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (sUF.connected(x - 'a', y - 'a')) ;
                return false;
            }
        }
        return true;
    }


}
