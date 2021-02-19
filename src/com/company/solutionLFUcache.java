package com.company;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class solutionLFUcache {
    //key 到 val 的映射，我们称为 KV 表
    HashMap<Integer, Integer> keyToVal;

    //key 到 freq 的映射，我们后面称为 KF 表。
    HashMap<Integer, Integer> keyToFreq;

    //freq 到 key 列表的映射，我们后文称为 FK 表。
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    //记录最小的频次
    int minFreq;

    //记录LFU的缓存的最大容量
    int cap;

    public solutionLFUcache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加key 对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (this.cap <= 0)
            return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
            return;
        }
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        //putIfAbsent() 方法会先判断指定的键（key）是否存在，不存在则将键/值对插入到 HashMap 中，freq=1不存在执行。
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        //新建1对应的linkedhashSet后，添加对应的键到列表中
        freqToKeys.get(1).add(key);
        this.minFreq = 1;

    }

    private void removeMinFreqKey() {
        //freq 最小的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //最先插入的key,最应该淘汰
        int deleteKey = keyList.iterator().next();
        //更新FK 表
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        //更新 KV表
        keyToVal.remove(deleteKey);
        //更新KF表
        keyToFreq.remove(deleteKey);
    }


    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        //更新KF表
        keyToFreq.put(key, freq + 1);
        //更新FK表
        //将key从freq对应的列表中删除
        freqToKeys.get(freq).remove(key);
        //将key加入freq+1对应的列表中删除
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        //如果freq对应的列表空了，移除这个freq;
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            //如果这个freq恰好是minFreq,更新minFreq
            if (freq == this.minFreq)
                this.minFreq++;
        }
    }


}
