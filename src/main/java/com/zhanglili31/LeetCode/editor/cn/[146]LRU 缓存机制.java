package com.zhanglili31.LeetCode.editor.cn;

import com.zhanglili31.LeetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.LeetCode.editor.cn.utils.TreeNode;

import java.util.*;

//146LRU 缓存机制
//2021-11-11 00:27:43
class LruCache {
    public static void main(String[] args) {
        LruCache lruCache = new LruCache();
        int capacity = 10;
        LRUCache l = null;
        int op[][] = {{10}, {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3}, {5, 25}, {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3}, {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5}, {4}, {11, 4}, {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4}, {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};
        l = lruCache.new LRUCache(op[0][0]);
        int t = 0;
        for (int i = 1; i < op.length; i++) {
            System.out.println(i);
            if (op[i].length == 1) {
                t = l.get(op[i][0]);
            } else {
                l.put(op[i][0],
                      op[i][1]);
            }
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        public class Node<K, T> {
            public K key;
            public T value;
            public Node<K, T> next = null;
            public Node<K, T> pre = null;

            public Node() {
            }

            public Node(K key, T value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity = 0;
        Node<Integer, Integer> cache = null;//始终指向head
        //key-index-value
        Map<Integer, Node<Integer, Integer>> map = new HashMap<Integer, Node<Integer, Integer>>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int res = -1;
            Node<Integer, Integer> node = null;


            if (map.containsKey(key)) {
                node = map.get(key);
                res = node.value;
                if (node.pre != null) {
                    Node<Integer, Integer> pre = node.pre;
                    pre.next = node.next;
                    if (node.next != null)
                        node.next.pre = pre;

                    node.pre = null;
                    node.next = this.cache;

                    this.cache.pre = node;
                    this.cache = node;
                }
            }
            return res;

        }

        public void put(int key, int value) {
            Node<Integer, Integer> node = new Node<>(
                    key,
                    value
            );
            if (map.containsKey(key)) {
                Node<Integer, Integer> oldNode = map.get(key);
                if (oldNode.pre == null) {
                    node.next = oldNode.next;
                    if (oldNode.next != null) {
                        oldNode.next.pre = node;
                    }
                    this.cache = node;
                } else {
                    oldNode.pre.next = oldNode.next;
                    if(oldNode.next != null) {oldNode.next.pre = oldNode.pre;}

                    node.next = this.cache;
                    this.cache.pre = node;

                    this.cache = node;
                }

            } else {//不包含当前key
                if (this.cache == null) {
                    this.cache = node;
                } else {
                    node.next = this.cache;
                    this.cache.pre = node;
                    this.cache = node;
                }
            }
            map.put(
                    key,
                    node
            );
            if (map.size() > this.capacity) {
                Node<Integer, Integer> tmp = this.cache;

                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                map.remove(tmp.key);
                if (tmp.pre != null) {
                    tmp.pre.next = null;
                } else {
                    this.cache.next = null;
                }

            }

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
