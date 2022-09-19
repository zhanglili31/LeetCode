package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//146 LRU 缓存
//2022-09-18 01:45:35
class LruCache2 {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        String testStr = "hello";
        String strArray[] = {"d", "b"};
//        Arrays.sort(strArray, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
        Arrays.sort(strArray,(o1,o2)->{
            return o1.compareTo(o2);
        });
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        //https://leetcode.cn/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/

        class Node<K, V> {
            K key;
            V val;
            Node<K, V> pre;
            Node<K, V> next;

            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }

        int capacity;
        int size;
        Map<Integer, Node<Integer, Integer>> map = new HashMap<Integer, Node<Integer, Integer>>();
        //初始化两个哨兵节点，简化代码
        Node<Integer, Integer> head = new Node<Integer, Integer>(-1, -1);
        Node<Integer, Integer> tail = new Node<Integer, Integer>(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;

        }

        //注意：每次调用put和get 都要将操作的数放在链表头

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node<Integer, Integer> node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node<Integer, Integer> node = map.get(key);
                node.val = value;
                moveToHead(node);
            } else {
                if (size >= capacity) {
                    size--;
                    deleteTail();
                }
                Node<Integer, Integer> node = new Node<Integer, Integer>(key, value);
                map.put(key, node);
                insertToHead(node);
                size++;
            }

        }

        //移动至头节点
        private void moveToHead(Node<Integer, Integer> node) {
            Node<Integer, Integer> pre = node.pre;
            Node<Integer, Integer> next = node.next;
            pre.next = next;
            next.pre = pre;
            //插入到头
            insertToHead(node);
        }

        //插入到头节点
        private void insertToHead(Node<Integer, Integer> node) {
            Node<Integer, Integer> headNext = head.next;
            head.next = node;
            node.pre = head;

            headNext.pre = node;
            node.next = headNext;
        }

        //删除最后一个节点
        private void deleteTail() {
            Node<Integer, Integer> node = tail.pre;
            map.remove(node.key);
            Node<Integer, Integer> pre = node.pre;
            pre.next = tail;
            tail.pre = pre;
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