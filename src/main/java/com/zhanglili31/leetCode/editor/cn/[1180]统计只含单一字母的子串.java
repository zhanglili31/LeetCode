package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1180 统计只含单一字母的子串
//2022-06-12 14:27:36
class CountSubstringsWithOnlyOneDistinctLetter {

    public static void main(String[] args) {
        Solution solution = new CountSubstringsWithOnlyOneDistinctLetter().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.countLetters("aaaaaaaaaasafdsfdsafdsgfadsdddsdd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countLetters(String s) {
            s = s + " ";
            int ans = 0;
            int len = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    len++;
                }
                if (s.charAt(i) != s.charAt(i - 1) || i == s.length() - 1) {
                    ans += len * (len + 1) / 2;
                    len = 1;
                }


            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}