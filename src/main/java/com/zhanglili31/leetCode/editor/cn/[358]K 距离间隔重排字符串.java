package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//358 K 距离间隔重排字符串
//2022-05-12 11:40:43
class RearrangeStringKDistanceApart {

    public static void main(String[] args) {
        Solution solution = new RearrangeStringKDistanceApart().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "aabbcc";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.rearrangeString(testStr, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String rearrangeString(String s, int k) {
            if (k <= 1) {
                return s;
            }
            PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> {
                return b.getValue() - a.getValue();
            });
            Map<Character, Integer> map = new HashMap<>();
            Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            maxHeap.addAll(map.entrySet());
            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                sb.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                queue.offer(entry);
                if (queue.size() == k) {
                    Map.Entry<Character, Integer> qHead = queue.poll();
                    if (qHead.getValue() > 0) {
                        maxHeap.add(qHead);
                    }
                }
            }
            return sb.length() == s.length() ? sb.toString() : "";

        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}