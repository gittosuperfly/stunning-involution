package main.algorithm;

import java.util.HashMap;

public class LruCacheTest { }
class LRUCache {
    HashMap<Integer, Node> map;
    DoubleList cache;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap();
        cache = new DoubleList();
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key); // 先将key标记为最近使用，再返回value
            return map.get(key).val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key); // 从原map中移除该key
            addRecently(key, value); // 更新最近使用
            return;
        }
        int size = cache.getSize();
        if (size == cap) { // 说明需要移除最久未使用的元素了
            removeLeastRecently();
        }
        // 走到这说明添加的是一个新元素
        addRecently(key, value);
    }

    public void makeRecently(int key) { // 将某个key标记为最近使用的元素（map中已存在的）
        Node x = map.get(key);
        cache.remove(x); // 先从双链表删除
        cache.addLast(x); // 再添加到链表末尾， 因为尾部是最近使用过的元素
    }

    public void addRecently(int key, int value) { // 添加最近使用过的元素， 原map中不存在该key
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x); // 同时记得更新map
    }

    public void deleteKey(int key) { // 删除某一个key对应的元素
        Node x = map.get(key);
        map.remove(key);
        cache.remove(x); // 在map中和cache中同时删除
    }

    public void removeLeastRecently() { // 删除最久未使用的元素
        Node oldNode = cache.removeHead(); // 最久未使用的一定在链表头部
        int oldKey = oldNode.key;
        map.remove(oldKey);
    }
}

/**
 * 双向链表
 */
class DoubleList {

    Node head, tail; // 伪头结点和伪尾结点
    int size; // 链表的长度

    public DoubleList() { // 初始化
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addLast(Node x) { // 添加到链表尾部，且越靠近链表尾部，越代表最近使用过
        // 如当前链表为： head <-> 1 <-> tail，加入结点x = 2
        x.pre = tail.pre;
        x.next = tail; // 完成结点2指向两端的箭头  head <-> 1 <- 2 -> tail; 此时tail.pre = 结点1还未断开
        tail.pre.next = x;
        tail.pre = x; // 完成由结点2两端指向结点2的箭头  head <-> 1 <-> 2 <-> tail;
        size++; // 更新链表长度
    }

    public void remove(Node x) { // 删除指定结点（该结点一定存在与链表）
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    public Node removeHead() { // 删除并返回头结点
        if (head.next == tail) return null; // 说明是空链表
        Node first = head.next;
        remove(first); // size在remove中更新
        return first;  // 用作在哈希表中移除最久未使用的数据值
    }

    public int getSize() { // 获取链表长度
        return size;
    }

}

class Node {
    int key, val; // 存储哈希表的key和value
    Node pre, next; //前后指针

    public Node(int key, int value) {
        this.key = key;
        this.val = value;

    }
}

