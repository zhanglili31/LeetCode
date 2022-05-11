package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//340 至多包含 K 个不同字符的最长子串
//2022-05-11 15:54:25
class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtMostKDistinctCharacters().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int ans = 0;
            int i = 0;
            int j = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (i < s.length()) {
                while (map.size() <= k && j < s.length()) {
                    char ch = s.charAt(j);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    if (map.size() > k) {
                        j++;
                        break;
                    }
                    ans = Math.max(ans, j - i + 1);
                    j++;
                }
                char ch = s.charAt(i);
                int num = map.get(ch);
                num--;
                if (num == 0) {
                    map.remove(ch);
                } else {
                    map.put(ch, num);
                }
                i++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}