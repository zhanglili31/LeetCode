package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//692 前K个高频单词
//2022-10-01 22:06:20
class TopKFrequentWords {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new TopKFrequentWords().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String str : words) {
                int frequency = map.getOrDefault(str, 0);
                map.put(str, frequency + 1);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue() - o1.getValue();
                    }

                }
            });
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.offer(entry);
            }
            List<String> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                res.add(pq.poll().getKey());
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}