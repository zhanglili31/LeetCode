package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.*;

//159 至多包含两个不同字符的最长子串
//2022-05-04 07:43:36
class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int res = 2;
            if (s.length() < 3)
                return s.length();
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(0), 1);
            if (map.containsKey(s.charAt(1))) {
                map.put(s.charAt(1), 2);
            } else {
                map.put(s.charAt(1), 1);
            }
            for (int i = 0, j = 2; j < s.length(); j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() <= 2) {
                    res = Math.max(res, j - i + 1);
                }
                while (map.size() > 2) {
                    ch = s.charAt(i);
                    int nums = map.get(ch);
                    map.put(ch, --nums);
                    if (nums == 0) {
                        map.remove(ch);
                    }
                    i++;
                }
            }
            return res;

        }

        public int lengthOfLongestSubstringTwoDistinct2(String s) {
            Set<Character> set = new HashSet<>();
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length() + 1; j++) {
                    String subStr = s.substring(i, j);
                    set.clear();
                    for (int k = 0; k < subStr.length(); k++) {
                        set.add(subStr.charAt(k));
                        if (set.size() > 2)
                            break;
                    }
                    if (set.size() <= 2) {
                        res = Math.max(res, subStr.length());
                    }

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}