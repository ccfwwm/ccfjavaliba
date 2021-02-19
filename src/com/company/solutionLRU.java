package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//链表节点
class Node {
    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

//双向hash链表
class DoubleList {
    //头尾旭节点
    private Node head, tail;
    //链表元素数
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在链表尾部添加节点x,时间O(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    //删除链表中的x节点，（x一定存在）
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表中的第一个节点，并返回该节点，时间O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    //返回链表长度，时间o(1)
    public int getSize() {
        return size;
    }

}

//LRU缓存机制，Least Recently Used,自编实现LinkedHashMap
public class solutionLRU {

    //key-> Node(key,val)
    private HashMap<Integer, Node> map;
    //Node(k1,v1)<->Node(k2,v2)
    private DoubleList cache;
    //最大容量
    private int cap;

    public solutionLRU(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    //将某个key提升为最近使用的
    private void makeRecently(int key) {
        Node x = map.get(key);
        //链表尾部就是最近使用的元素。
        cache.addLast(x);
        //map中添加key映射
        map.put(key, x);
    }

    //添加最近使用的元素
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        map.put(key, x);
    }

    //删除一个key
    private void deleteKey(int key) {
        Node x = map.get(key);
        //从链表汇总删除
        cache.remove(x);
        //从map中删除
        map.remove(key);
    }

    //删除最久未使用的元素
    private void removeLeastRecently() {
        //链表头部的第一个元素就是最久未使用的。
        Node deleteNode = cache.removeFirst();
        //map中也需要删除
        int deletedKey = deleteNode.key;
        map.remove(deletedKey);

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //将该数据提升为最近使用的
        makeRecently(key);
        //返回Node.val
        return map.get(key).val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        if (cap == cache.getSize()) {
            //删除最久未使用的元素
            removeLeastRecently();
        }
        //添加为最近使用的元素
        addRecently(key, val);

    }


}

//内置实现
class LRUCache{
    int cap;
    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity){
        this.cap = capacity;
    }

    public  int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        makeRecenty(key);
        return cache.get(key);
    }

    public void put(int key,int val){
        if(cache.containsKey(key)){
            //修改key的值
            cache.put(key,val);
            makeRecenty(key);
            return;
        }
        if(cache.size()>=this.cap){
            //链表头部就是最久未使用的key
            HashMap.Entry<Integer,Integer> iterator;
            iterator = cache.entrySet().iterator().next();
            int oldestKey = (int) iterator.getKey();
            //或者如下
           // int oldestKey = cache.keySet().iterator().next();

            cache.remove(oldestKey);
        }
        cache.put(key,val);
    }



    private  void makeRecenty(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);

    }
}




