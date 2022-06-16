package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//面试题 01.04 回文排列
//2022-06-16 23:48:02
class PalindromePermutationLcci {

    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
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
        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            Iterator iterator = map.entrySet().iterator();
            int single = 0;
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) iterator.next();
                if (entry.getValue() % 2 == 1) {
                    single++;
                    if (single > 1) {
                        return false;
                    }
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}