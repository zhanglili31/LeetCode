package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//451 根据字符出现频率排序
//2022-10-17 04:17:20
class SortCharactersByFrequency {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new SortCharactersByFrequency().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        ListNode listNode = CreateListNode.stringToListNode("[1,2,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.frequencySort("aaccc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            int maxFrequency = 0;
            int t = 0;
            for (int i = 0; i < s.length(); i++) {
                t = map.getOrDefault(s.charAt(i), 0);
                map.put(s.charAt(i), t + 1);
                maxFrequency = Math.max(maxFrequency, t + 1);
            }
            List<List<Character>> frequency = new ArrayList<>(maxFrequency + 1);
            for (int i = 0; i <= maxFrequency; i++) {
                frequency.add(new ArrayList<>());
            }
            int value = 0;
            for (Character key : map.keySet()) {
                value = map.get(key);
                frequency.get(value).add(key);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = maxFrequency; i >= 0; i--) {
                List<Character> temp = frequency.get(i);
                if (temp.size() == 0) {
                    continue;
                }
                for (int j = 0; j < temp.size(); j++) {
                    for (int k = 0; k < i; k++) {
                        sb.append(temp.get(j));
                    }
                }
            }
            return sb.toString();


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}