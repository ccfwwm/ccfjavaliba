package com.company;

import java.security.Key;

public class solutionMaxPQ <key extends Comparable<key>>{

    private Key[] pq;
    private int N = 0;

    public solutionMaxPQ(int cap){
        pq = (Key[]) new Comparable[cap+1];
    }


}
