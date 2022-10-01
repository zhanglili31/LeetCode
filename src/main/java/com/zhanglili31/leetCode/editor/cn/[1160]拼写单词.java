package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateListNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.ListNode;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1160 拼写单词
//2022-10-02 02:33:02
class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        int dir8[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int dir4[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Solution solution = new FindWordsThatCanBeFormedByCharacters().new Solution();
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
        public int countCharacters(String[] words, String chars) {
            Map<Character, Integer> map1 = new HashMap<>();
            for (int i = 0; i < chars.length(); i++) {
                int v = map1.getOrDefault(chars.charAt(i), 0) + 1;
                map1.put(chars.charAt(i), v);
            }
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                Map<Character, Integer> map2 = new HashMap<>();
                for (int j = 0; j < words[i].length(); j++) {
                    int v = map2.getOrDefault(words[i].charAt(j), 0) + 1;
                    map2.put(words[i].charAt(j), v);
                }
                if (isOK(map1, map2)) {
                    res += words[i].length();
                }

            }
            return res;


        }

        private boolean isOK(Map<Character, Integer> map1, Map<Character, Integer> map2) {
            for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
                if (!map1.containsKey(entry.getKey())||map1.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}