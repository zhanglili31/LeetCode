package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1100 长度为 K 的无重复字符子串
//2022-06-07 15:46:00
class FindKLengthSubstringsWithNoRepeatedCharacters {

    public static void main(String[] args) {
        Solution solution = new FindKLengthSubstringsWithNoRepeatedCharacters().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
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
        public int numKLenSubstrNoRepeats(String s, int k) {
            int ans = 0;
            if (k > s.length()) {
                return ans;
            }
            int i = 0;
            int j = k;
            Map<Character, Integer> map = new HashMap<>();
            for (int l = 0; l < k; l++) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
            }

            while (j <= s.length()) {
                if (map.size() == k) {
                    ans++;
                }
                if (j < s.length()) {
                    char ch = s.charAt(i++);
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    ch = s.charAt(j++);
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }else{
                    j++;
                }
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}